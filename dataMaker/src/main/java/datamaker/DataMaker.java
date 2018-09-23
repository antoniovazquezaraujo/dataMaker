package datamaker;

/**
 * DataMaker.
 * Generador de datos.
 * Genera listas o árboles de datos con apariencia real.
 * Basado en la biblioteca Faker (http://dius.github.io/java-faker)
 * Autor: Antonio Vazquez Araujo
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
    // tamaños min/max de las colecciones
    protected int minSize = -1, maxSize = -1;
    // profundidad min/max de los árboles
    protected int minDepth = -1, maxDepth = -1;
    // semilla de entropía
    protected Random random = new Random();
    // locale
    protected Locale locale = new Locale("es_ES");
    // faker, el que proporciona los datos
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

    // Crea un arbol de objetos de una clase T (versión tipada para comodidad)
    @SuppressWarnings("unchecked")
    public <T> T make(Class<T> clazz) {
        return (T) makeObject(clazz);
    }

    // Crea un arbol de objetos de cualquier clase
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
                    }
                }
            }
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException
                | IntrospectionException e) {
            LOGGER.error("Error ejecutando getter " + e);
        }
        return ret;
    }

    // Crea un arbol de la clase dada, con TreeItems
    public <T> TreeItem<T> makeTree(Class<T> clazz) {
        Object object = make(clazz);
        return makeTree(object);
    }

    // Convierte un arbol de objetos en un arbol de TreeItems
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
            LOGGER.error("Error obteniendo descriptor " + e);
        }
        return ret;
    }

    public <T> List<T> makeList(Class<T> clazz) {
        return makeObjectList(clazz);
    }

    public <T> ObservableList<T> makeObservableList(Class<T> clazz) {
        return makeObjectObservableList(clazz);
    }

    // Zona privada
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

    // Calcula el tamaño de las colecciones.
    // Primero mira los datos parámetro. Si no se han pasado busca los de las anotaciones
    // Si tampoco hay anotaciones, el tamaño será -1 y no se crearán elementos
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
            // Usamos esto, porque creo que hay un fallo en numberBetween en faker
            int range = (int) ((DataMaker.faker.number().randomNumber() % ((max - min) + 1)));
            return min + range;
        }
        return -1;
    }

    // Calcula la profundidad. Mira primero los parámetros. Si no hay mira las anotaciones.
    // Si tampoco hay, la profundidad será -1, con lo que no se creará nada
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
            // Usamos esto, porque creo que hay un fallo en numberBetween en faker
            int range = (int) ((DataMaker.faker.number().randomNumber() % ((max - min) + 1)));
            return min + range;
        }
        return -1;
    }

    // Llena de datos las colecciones de un objeto con una profundidad dada y el método que devuelve la colección
    // Teóricamente solo llena la colección indicada, pero es recursivo y llena las que contenga cada elemento ad
    // infinitum
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
                    fillCollections(elementType, newObject, depth-1, method);
                    collectionGetMethod.invoke(fieldValue, newObject);
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
                    | NoSuchMethodException | SecurityException | InstantiationException e) {
                LOGGER.error("Error llenando colecciones " + e);
            }
        }
        return object;
    }
}
