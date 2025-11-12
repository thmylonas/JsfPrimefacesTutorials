package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.images_services;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer._enums.AppImage;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.images_services._base.ImagesService;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean(name = "primefacesContentFlowAltService")
@ViewScoped
@Getter
public class PrimefacesContentFlowAltService extends ImagesService {

    private static final Integer[] IMAGES_INDEXES_ARRAY = new Integer[]{1, 2, 0};

    private List<String> imagesNamesFilteredByIndexes;

    @PostConstruct
    private void init() {
        imagesNamesFilteredByIndexes = initializeImagesNamesFilteredByIndexes();
    }

    private List<String> initializeImagesNamesFilteredByIndexes() {
        return filterImagesByIndexes(APP_IMAGES, IMAGES_INDEXES_ARRAY).stream()
                .map(AppImage::getImageName).collect(Collectors.toList());
    }
}
