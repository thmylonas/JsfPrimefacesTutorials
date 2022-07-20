package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models._general_models;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models._base.AbstractModel;

import java.lang.reflect.Array;

/**
 * This class represents a generic array T[]
 *
 * @param <T> The generic type of the elements of the T[] array
 * @author Thomas_Mylonas
 * @since 07-Mar-2021
 */
public class GenericArray<T> extends AbstractModel {

    private final T[] genericElementsArray;

    @SuppressWarnings("unchecked")
    public GenericArray(Class<T> clazz, int capacity) {
        genericElementsArray = (T[]) Array.newInstance(clazz, capacity);
    }

    public T[] getGenericElementsArray() {
        return genericElementsArray;
    }
}
