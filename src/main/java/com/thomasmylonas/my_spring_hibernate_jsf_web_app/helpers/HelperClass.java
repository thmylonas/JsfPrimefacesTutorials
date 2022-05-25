package com.thomasmylonas.my_spring_hibernate_jsf_web_app.helpers;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models._general_models.GenericArray;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
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
        return string == null || string.equals("");
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

    /**
     * @param propertiesPath ********************************************************
     * @return ********************************************************
     * @throws IOException "Properties::load" throws "IOException"
     */
    public static Properties loadPropertiesFile(String propertiesPath) throws IOException {

        Properties properties = new Properties();
        if (isStringNullOrEmpty(propertiesPath)) {
            return properties;
        }
        properties.load(HelperClass.class.getClassLoader().getResourceAsStream(propertiesPath));
        return properties;
    }

    /**
     * @param propertiesPath ********************************************************
     * @param propertyName   ********************************************************
     * @return ********************************************************
     * @throws IOException "HelperClass::loadPropertiesFile" throws "IOException"
     */
    public static String getPropertyValueFromProperties(String propertiesPath, String propertyName) throws IOException {

        if (isStringNullOrEmpty(propertiesPath) || isStringNullOrEmpty(propertyName)) {
            return "";
        }
        return loadPropertiesFile(propertiesPath).getProperty(propertyName);
    }

    /**
     * This method displays the Objects of a List, in a String separated with delimiter.
     * If list is List<Long> or List<Float>, the flag "displayLongFloatSigns" checks if Longs/Floats
     * will be displayed with "L"/"f" at the end
     * If list IS NOT List<Long> & List<Float>, the flag "displayLongFloatSigns" is not in use. Any value can be used
     * for the flag "displayLongFloatSigns", which has no effect in the method
     *
     * @param list                  The list to display its Objects
     * @param delimPrefixSuffix     A String array String[] with the pattern: [delimiter, prefix, suffix], where:
     *                              delimiter: The delimiter which separates the Objects in the String
     *                              prefix: The prefix in the display String
     *                              suffix: The suffix in the display String
     * @param displayLongFloatSigns A flag checking if Longs/Floats will be displayed with "L"/"f" at the end
     * @param <T>                   The generic type of the Objects of the List<T> list
     * @return A String of Objects separated with delimiter
     */
    public static <T> String displayListToString(List<T> list, String[] delimPrefixSuffix, boolean displayLongFloatSigns) {

        return (list == null || delimPrefixSuffix == null || delimPrefixSuffix.length < 3) ?
                null :
                list.stream().map(x -> {
                    if (x instanceof Long) {
                        return displayLongFloatSigns ? x + "L" : x.toString();
                    } else if (x instanceof Float) {
                        return displayLongFloatSigns ? x + "f" : x.toString();
                    } else {
                        return x.toString();
                    }
                }).collect(Collectors.joining(delimPrefixSuffix[0], delimPrefixSuffix[1], delimPrefixSuffix[2]));
    }

    /**
     * This method displays the Objects of an Array, in a String separated with delimiter.
     * If Array is Long[] or Float[], the flag "displayLongFloatSigns" checks if Longs/Floats
     * will be displayed with "L"/"f" at the end
     * If Array IS NOT Long[] or Float[], the flag "displayLongFloatSigns" is not in use. Any value can be used
     * for the flag "displayLongFloatSigns", which has no effect in the method
     *
     * @param array                 The Array to display its Objects
     * @param delimPrefixSuffix     A String array String[] with the pattern: [delimiter, prefix, suffix], where:
     *                              delimiter: The delimiter which separates the Objects in the String
     *                              prefix: The prefix in the display String
     *                              suffix: The suffix in the display String
     * @param displayLongFloatSigns A flag checking if Longs/Floats will be displayed with "L"/"f" at the end
     * @param <T>                   The generic type of the Objects of the Array
     * @return A String of Objects separated with delimiter
     */
    public static <T> String displayArrayToString(T[] array, String[] delimPrefixSuffix, boolean displayLongFloatSigns) {
        return displayListToString(Arrays.stream(array).collect(Collectors.toList()), delimPrefixSuffix, displayLongFloatSigns);
    }

    /**
     * @param list         ********************************************************
     * @param indexesArray ********************************************************
     * @param <T>          ********************************************************
     * @return ********************************************************
     */
    public static <T> List<T> filterListByIndexes(List<T> list, Integer[] indexesArray) {

        List<Integer> filteredIndexesList = Arrays.stream(indexesArray).filter(index -> (index >= 0 && index < list.size())).collect(Collectors.toList());
        return isArrayNullOrEmpty(indexesArray) || isListNullOrEmpty(list) ?
                Collections.emptyList() :
                filteredIndexesList.stream().map(list::get).collect(Collectors.toList());
    }

    public static Date getDate(int year, int month, int day) {

        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day); // cal.set(1972, Calendar.SEPTEMBER, 24);
        return cal.getTime();
    }
}
