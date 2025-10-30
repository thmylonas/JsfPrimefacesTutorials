package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.images_services._base;

import com.thomasmylonas.jsf_primefaces_tutorials.helpers.HelperClass;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer._enums.ImagesEnum;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services._base.AbstractService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name = "imagesService")
@ViewScoped
public class ImagesService extends AbstractService {

    protected final List<ImagesEnum> LIST_OF_IMAGES_ENUMS = Arrays.asList(ImagesEnum.values());

    public String getImageDescriptionForName(String imageName) {
        return ImagesEnum.getImageDescriptionForName(imageName);
    }

    public String getImageFullNameWithPathForName(String imageName) {
        return ImagesEnum.getImagesEnumForName(imageName).getImageFullNameWithPath();
    }

    public ImagesEnum getImagesEnum(ImagesEnum imagesEnum) {
        return imagesEnum;
    }

    public ImagesEnum getImagesEnumForName(String imageName) {
        return ImagesEnum.getImagesEnumForName(imageName);
    }

    protected List<ImagesEnum> filterListOfImagesByIndexes(List<ImagesEnum> listOfImagesEnums, Integer[] imagesIndexesArray) {
        return HelperClass.filterListByIndexes(listOfImagesEnums, imagesIndexesArray);
    }
}
