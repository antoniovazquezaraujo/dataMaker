package datamaker;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import datamaker.annotations.SelfCollection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*
 * Pruebas para poder mostrar en modo texto los datos con las colecciones anidadas.
 * No es simple, porque necesitas enviar el nombre de la colección a expandir, y si esa tiene más elementos anidados, debería poder enviarse también la colección a expandir de cada una, hasta el infinito. Cómo hacer eso?
 * De momento se queda como idea.
 */
public class DataPrinter {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataMaker.class);
    public static final String COLUMN_SEPARATOR = "\t";
    public static final String ROW_SEPARATOR = "\n";


    public static String print(Class clazz, Collection col) {
        PropertyDescriptor[] propertyDescriptors = null;
        propertyDescriptors = extractPropertyDescriptors(clazz, propertyDescriptors);
        String ret = extractFieldNames(propertyDescriptors) + ROW_SEPARATOR;
        for (Object x : col) {
            ret += extractFieldValues(x, propertyDescriptors, "children") + ROW_SEPARATOR;
        }
        return ret;
    }

    public static String print(Object o) {
        Class clazz = o.getClass();
        PropertyDescriptor[] propertyDescriptors = null;
        propertyDescriptors = extractPropertyDescriptors(clazz, propertyDescriptors);
        return extractFieldNames(propertyDescriptors) + ROW_SEPARATOR
                + extractFieldValues(o, propertyDescriptors, "children");
    }

    private static String extractFieldNames(PropertyDescriptor[] propertyDescriptors) {
        StringBuilder ret = new StringBuilder();
        ObservableList<PropertyDescriptor> list = FXCollections.observableArrayList(propertyDescriptors);
        // @formatter:off
        return list.stream()
                .filter(t -> (t.getWriteMethod()!=null) || Collection.class.isAssignableFrom(t.getReadMethod().getReturnType()))
                .map(t -> t.getName())
                .collect(Collectors.joining(COLUMN_SEPARATOR));
        // @formatter:on
    }

    private static String extractFieldValues(Object o, PropertyDescriptor[] propertyDescriptors,
            String collectionFieldNameToShow) {
        ObservableList<PropertyDescriptor> list = FXCollections.observableArrayList(propertyDescriptors);
        // @formatter:off
        StringBuilder ret = new StringBuilder(list.stream()
                .filter(t -> (t.getWriteMethod()!=null) || Collection.class.isAssignableFrom(t.getReadMethod().getReturnType()))
                .map(t -> {
                    StringBuilder sb = new StringBuilder();
                    Method method = t.getReadMethod();
                    try {
                        Object value = method.invoke(o);
                        if (Collection.class.isAssignableFrom(method.getReturnType())) {
                            if (method.isAnnotationPresent(SelfCollection.class)) {
                                Collection children;
                                children = (Collection) value;
                                sb.append("[" + children.size() + "]");
                            }
                        } else {
                            sb.append(value);
                        }
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    return sb.toString();
                })
                .collect(Collectors.joining(COLUMN_SEPARATOR)));
        // @formatter:on
        if (collectionFieldNameToShow != null) {
            ret.append((list.stream().filter(t -> (t.getName().equals(collectionFieldNameToShow))).map(t -> {
                Method method = t.getReadMethod();
                Collection value;
                try {
                    value = (Collection) method.invoke(o);
                    return print(method.getDeclaringClass(), value);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                return null;
            }).collect(Collectors.joining(COLUMN_SEPARATOR, "\n\t", ""))));

        }
        return ret.toString();
    }

    private static PropertyDescriptor[] extractPropertyDescriptors(Class clazz,
            PropertyDescriptor[] propertyDescriptors) {
        try {
            propertyDescriptors = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
        } catch (IntrospectionException e1) {
            e1.printStackTrace();
        }
        return propertyDescriptors;
    }
}
