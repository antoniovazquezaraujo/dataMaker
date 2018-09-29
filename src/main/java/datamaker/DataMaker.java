package datamaker;

/**
 * DataMaker.
 * Data generator.
 * Generates lists or data trees with real appearance
 * Based on Faker (http://dius.github.io/java-faker)
 *
 * @author <a href="antoniovazquezaraujo@gmail.com">Antonio Vazquez Araujo</a>
 *
 */
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.javafaker.Faker;

import datamaker.annotations.ExternalCollection;
import datamaker.annotations.SelfCollection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

public class DataMaker {
    // min/max sizes of collections
    protected int minSize = -1, maxSize = -1;
    // min/max deep of tress
    protected int minDepth = -1, maxDepth = -1;
    // entropy seed
    protected Random random = new Random();
    // locale
    protected Locale locale = new Locale("es_ES");
    // faker, the data generator
    protected static Faker faker = new Faker(new Locale("es_ES"), new Random());

    private static final Logger LOGGER = LoggerFactory.getLogger(DataMaker.class);

    public static Faker faker() {
        return DataMaker.faker;
    }

    public DataMaker() {
        faker = new Faker(this.locale, this.random);
    }

    private DataMaker resetLocale() {
        this.locale = new Locale("es_ES");
        faker = new Faker(this.locale, this.random);
        return this;
    }

    public DataMaker setLocaleName(String localeName) {
        this.locale = new Locale(localeName);
        try {
            faker = new Faker(this.locale, this.random);
        } catch (Exception e) {
            resetLocale();
        }
        return this;
    }

    public DataMaker resetSeed() {
        this.random = new Random();
        faker = new Faker(this.locale, this.random);
        return this;
    }

    public DataMaker setSeed(int n) {
        this.random = new Random(n);
        faker = new Faker(this.locale, this.random);
        return this;
    }

    public DataMaker resetAll() {
        resetSeed();
        resetLocale();
        resetSizeOfCollections();
        resetDepthOfSelfCollections();
        return this;
    }

    public DataMaker resetSizeOfCollections() {
        setSizeOfCollections(-1);
        return this;
    }

    public DataMaker setSizeOfCollections(int size) {
        setSizeOfCollections(size, size);
        return this;
    }

    public DataMaker setSizeOfCollections(int minSize, int maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
        return this;
    }

    public DataMaker resetDepthOfSelfCollections() {
        setDepthOfSelfCollections(-1);
        return this;
    }

    public DataMaker setDepthOfSelfCollections(int depth) {
        setDepthOfSelfCollections(depth, depth);
        return this;
    }

    public DataMaker setDepthOfSelfCollections(int minDepth, int maxDepth) {
        this.minDepth = minDepth;
        this.maxDepth = maxDepth;
        return this;
    }

    // Create a tree of objects of a class T (typed version for convenience)
    @SuppressWarnings("unchecked")
    public <T> T make(Class<T> clazz) {
        return (T) makeObject(clazz);
    }

    // Create a tree of objects of any class
    public Object makeObject(Class clazz) {
        Object ret = null;
        try {
            ret = clazz.newInstance();
            for (java.beans.PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(clazz)
                    .getPropertyDescriptors()) {
                Method method = propertyDescriptor.getReadMethod();
                if (Collection.class.isAssignableFrom(method.getReturnType())) {
                    int depth = calculateDepth(method);
                    if (depth != -1) {
                        fillCollections(clazz, ret, depth, method);
                    } else {
                    }
                }
            }
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException
                | IntrospectionException e) {
            LOGGER.error("Error ejecutando getter " + e);
        }
        return ret;
    }

    // Create a tree of the given class, with TreeItems
    public <T> TreeItem<T> makeTree(Class<T> clazz) {
        Object object = make(clazz);
        return makeTree(object);
    }

    // Converts an object tree into a TreeItems tree
    // Convert any selfCollection into a treeItem children
    public TreeItem makeTree(Object t) {
        TreeItem ret = new TreeItem(t);
        Class clazz = t.getClass();
        try {
            for (java.beans.PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(clazz)
                    .getPropertyDescriptors()) {
                Method method = propertyDescriptor.getReadMethod();
                if (Collection.class.isAssignableFrom(method.getReturnType())) {
                    if (method.isAnnotationPresent(SelfCollection.class)) {
                        Collection children = (Collection) method.invoke(t);
                        for (Object child : children) {
                            ret.getChildren().add(makeTree(child));
                        }
                        children.clear();
                    }
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | IntrospectionException e) {
            LOGGER.error("Error obtaining descriptor " + e);
        }
        return ret;
    }



    public <T> List<T> makeList(Class<T> clazz) {
        return makeObjectList(clazz);
    }

    public <T> ObservableList<T> makeObservableList(Class<T> clazz) {
        return makeObjectObservableList(clazz);
    }

    // Private zone
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private List makeObjectList(Class clazz) {
        List ret = new ArrayList();
        int size = calculateSize();
        for (int n = 0; n < size; n++) {
            ret.add(makeObject(clazz));
        }
        return ret;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private ObservableList makeObjectObservableList(Class clazz) {
        ObservableList ret = FXCollections.observableArrayList();
        int size = calculateSize();
        for (int n = 0; n < size; n++) {
            ret.add(makeObject(clazz));
        }
        return ret;
    }

    // Calculates the size of the collections.
    // First look at the parameter data. If they have not been received, looks for those in the annotations
    // If there are no annotations either, the size will be -1 and no elements will be created
    private int calculateSize() {
        return calculateSize(null);
    }

    private int calculateSize(Method method) {
        int min = this.minSize;
        int max = this.maxSize;
        if ((min == -1) || (max == -1)) {
            if (method != null) {
                if (method.isAnnotationPresent(SelfCollection.class)) {
                    min = method.getAnnotation(SelfCollection.class).minSize();
                    max = method.getAnnotation(SelfCollection.class).maxSize();
                } else if (method.isAnnotationPresent(ExternalCollection.class)) {
                    ExternalCollection annotation = method.getAnnotation(ExternalCollection.class);
                    min = annotation.minSize();
                    max = annotation.maxSize();
                }
            }
        }
        if ((min != -1) && (max != -1)) {
            if (min == max) {
                return min;
            }
            // We use this because there is a fail in numberBetween in Faker
            int range = (int) ((DataMaker.faker.number().randomNumber() % ((max - min) + 1)));
            return min + range;
        }
        return -1;
    }

    // Depth is calculated. The parameters are looked at first. If there is not, then the annotations are looked at.
    // If there is not either, the depth will be -1, so nothing will be created
    private int calculateDepth(Method method) {
        int min = this.minDepth;
        int max = this.maxDepth;
        if (((min == -1) || (max == -1)) && method.isAnnotationPresent(SelfCollection.class)) {
            min = method.getAnnotation(SelfCollection.class).minDepth();
            max = method.getAnnotation(SelfCollection.class).maxDepth();
        }
        if ((min != -1) && (max != -1)) {
            if (min == max) {
                return min;
            }
            // We use this because there is a fail in numberBetween in Faker
            int range = (int) ((DataMaker.faker.number().randomNumber() % ((max - min) + 1)));
            return min + range;
        }
        return -1;
    }

    // It fills with data the collections of an object with a given depth and the method that returns the collection
    // Theoretically, it only fills the indicated collection, but it is recursive and also fills the ones contained in
    // each element to infinity
    private Object fillCollections(Class clazz, Object object, int depth, Method method) {
        if (depth <= 0) {
            return object;
        }
        method.setAccessible(true);
        int size = calculateSize(method);
        if (size != -1) {
            Class elementType = clazz;
            if (method.isAnnotationPresent(ExternalCollection.class)) {
                elementType = method.getAnnotation(ExternalCollection.class).type();
            }
            Object fieldValue;
            try {
                fieldValue = method.invoke(object);
                Method collectionGetMethod = fieldValue.getClass().getMethod("add", Object.class);
                for (int n = 0; n < size; n++) {
                    Object newObject = elementType.newInstance();
                    fillCollections(elementType, newObject, depth - 1, method);
                    collectionGetMethod.invoke(fieldValue, newObject);
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
                    | NoSuchMethodException | SecurityException | InstantiationException e) {
                LOGGER.error("Error filling collections " + e);
            }
        }
        return object;
    }
}
