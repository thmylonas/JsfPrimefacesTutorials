package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.images_services._base;

import com.thomasmylonas.jsf_primefaces_tutorials.helpers.HelperClass;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer._enums.AppImage;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services._base.AbstractService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name = "imagesService")
@ViewScoped
public class ImagesService extends AbstractService {

    protected static final List<AppImage> APP_IMAGES = Arrays.asList(AppImage.values());

    public String fetchImageDescriptionForName(String imageName) {
        return AppImage.fetchImageDescriptionForName(imageName);
    }

    public String fetchImageFullNameWithPathForName(String imageName) {
        return AppImage.fetchAppImageForName(imageName).fetchImageFullNameWithPath();
    }

    public AppImage fetchAppImage(AppImage appImage) {
        return appImage;
    }

    public AppImage fetchAppImageForName(String imageName) {
        return AppImage.fetchAppImageForName(imageName);
    }

    protected List<AppImage> filterImagesByIndexes(List<AppImage> appImages, Integer[] imagesIndexesArray) {
        return HelperClass.filterListByIndexes(appImages, imagesIndexesArray);
    }
}
