package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.images_services;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer._enums.ImagesEnum;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.images_services._base.ImagesService;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean(name = "_alt_primefacesContentFlowService")
@ViewScoped
@Getter
public class PrimefacesContentFlowAltService extends ImagesService {

    private static final Integer[] IMAGES_INDEXES_ARRAY = new Integer[]{1, 2, 0};

    private List<String> listOfImagesNamesFilteredByIndexes;

    @PostConstruct
    private void init() {
        listOfImagesNamesFilteredByIndexes = initializeListOfImagesNamesFilteredByIndexes();
    }

    private List<String> initializeListOfImagesNamesFilteredByIndexes() {
        return filterListOfImagesByIndexes(LIST_OF_IMAGES_ENUMS, IMAGES_INDEXES_ARRAY).
                stream().map(ImagesEnum::getImageName).collect(Collectors.toList());
    }
}
