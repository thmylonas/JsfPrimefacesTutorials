package com.thomasmylonas.spring_mvc_jsf_pf_web_app.helpers;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models._general_models.GenericArray;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * This is a Helper class which contains public static Java methods for general use.
 *
 * @author Thomas_Mylonas
 * @since 16-May-2022
 */
public abstract class HelperClass {

    /**
     * The method checks if a String is "null" or "empty"
     *
     * @param string The String we check if it is "null" or "empty"
     * @return A boolean which checks if a String is "null" or "empty"
     */
    public static boolean isStringNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    /**
     * The method checks if an Array is "null" or "empty"
     *
     * @param array The Array we check if it is "null" or "empty"
     * @return A boolean which checks if an Array is "null" or "empty"
     */
    public static <T> boolean isArrayNullOrEmpty(T[] array) {
        return array == null || array.length == 0;
    }

    /**
     * The method checks if a List is "null" or "empty"
     *
     * @param list The List we check if it is "null" or "empty"
     * @return A boolean which checks if a List is "null" or "empty"
     */
    public static <T> boolean isListNullOrEmpty(List<T> list) {
        return list == null || list.isEmpty();
    }

    /**
     * This method transforms a List<T> to T[] with generic way.
     *
     * @param list         The list of objects with type T, to transform
     * @param genericArray The temporary array T[], to store the resulting transformation
     * @param <T>          The generic type of the elements of the List<T> list
     * @return The resulting transformation
     */
    public static <T> T[] transformListToArray(List<T> list, GenericArray<T> genericArray) {
        return (isListNullOrEmpty(list) || genericArray == null) ? null : list.toArray(genericArray.getGenericElementsArray());
    }

    public static Properties loadPropertiesFile(String propertiesPath) throws IOException {

        Properties properties = new Properties();
        if (isStringNullOrEmpty(propertiesPath)) {
            return properties;
        }
        properties.load(HelperClass.class.getClassLoader().getResourceAsStream(propertiesPath)); // IOException
        return properties;
    }

    public static String fetchPropertyValueFromProperties(String propertiesPath, String propertyName) throws IOException {

        if (isStringNullOrEmpty(propertiesPath) || isStringNullOrEmpty(propertyName)) {
            return "";
        }
        return loadPropertiesFile(propertiesPath).getProperty(propertyName); // IOException
    }

    public static String displayStringListAsString(String[] array, String[] delimPrefixSuffix) {
        return Arrays.stream(array).collect(Collectors.joining(delimPrefixSuffix[0], delimPrefixSuffix[1], delimPrefixSuffix[2]));
    }

    public static <T> List<T> filterListByIndexes(List<T> list, Integer[] indexesArray) {

        List<Integer> filteredIndexesList = Arrays.stream(indexesArray).filter(index -> (index >= 0 && index < list.size())).toList();
        return isArrayNullOrEmpty(indexesArray) || isListNullOrEmpty(list) ?
                Collections.emptyList() :
                filteredIndexesList.stream().map(list::get).collect(Collectors.toList());
    }

    public static LocalDate buildDate(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }
}
