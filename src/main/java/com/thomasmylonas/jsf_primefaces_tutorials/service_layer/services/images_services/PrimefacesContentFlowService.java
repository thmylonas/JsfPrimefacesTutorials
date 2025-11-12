package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.images_services;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer._enums.AppImage;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.images_services._base.ImagesService;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "primefacesContentFlowService")
@ViewScoped
@Getter
public class PrimefacesContentFlowService extends ImagesService {

    private static final Integer[] IMAGES_INDEXES_ARRAY = new Integer[]{1, 2, 0};
    private List<AppImage> imagesFilteredByIndexes;

    @PostConstruct
    private void init() {
        imagesFilteredByIndexes = initializeImagesFilteredByIndexes();
    }

    private List<AppImage> initializeImagesFilteredByIndexes() {
        return filterImagesByIndexes(APP_IMAGES, IMAGES_INDEXES_ARRAY);
    }
}
