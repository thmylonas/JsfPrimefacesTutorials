package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.images_services;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer._enums.ImagesEnum;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.images_services._base.ImagesService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "primefacesContentFlowService")
@ViewScoped
public class PrimefacesContentFlowService extends ImagesService {

    private final Integer[] IMAGES_INDEXES_ARRAY = new Integer[]{1, 2, 0};
    private List<ImagesEnum> listOfImagesFilteredByIndexes;

    @PostConstruct
    private void init() {
        listOfImagesFilteredByIndexes = initializeListOfImagesFilteredByIndexes();
    }

    private List<ImagesEnum> initializeListOfImagesFilteredByIndexes() {
        return filterListOfImagesByIndexes(LIST_OF_IMAGES_ENUMS, IMAGES_INDEXES_ARRAY);
    }

    public List<ImagesEnum> getListOfImagesFilteredByIndexes() {
        return listOfImagesFilteredByIndexes;
    }
}
