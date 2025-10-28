package com.thomasmylonas.spring_mvc_jsf_pf_web_app._alt_copies_not_used._alt._alt_services._alt_images_services;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer._enums.ImagesEnum;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.images_services._base.ImagesService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean(name = "_alt_primefacesContentFlowService")
@ViewScoped
public class _alt_PrimefacesContentFlowService extends ImagesService {

    private final Integer[] IMAGES_INDEXES_ARRAY = new Integer[]{1, 2, 0};
    private List<String> listOfImagesNamesFilteredByIndexes;

    @PostConstruct
    private void init() {
        listOfImagesNamesFilteredByIndexes = initializeListOfImagesNamesFilteredByIndexes();
    }

    private List<String> initializeListOfImagesNamesFilteredByIndexes() {
        return filterListOfImagesByIndexes(LIST_OF_IMAGES_ENUMS, IMAGES_INDEXES_ARRAY).
                stream().map(ImagesEnum::getImageName).collect(Collectors.toList());
    }

    public List<String> getListOfImagesNamesFilteredByIndexes() {
        return listOfImagesNamesFilteredByIndexes;
    }
}
