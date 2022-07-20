package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.images_services._base;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.helpers.HelperClass;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer._enums.ImagesEnum;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services._base.AbstractService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

@Service(value = "imagesService")
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
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

    @SuppressWarnings("unused")
    public ImagesEnum getImagesEnumForName(String imageName) {
        return ImagesEnum.getImagesEnumForName(imageName);
    }

    protected List<ImagesEnum> filterListOfImagesByIndexes(List<ImagesEnum> listOfImagesEnums, Integer[] imagesIndexesArray) {
        return HelperClass.filterListByIndexes(listOfImagesEnums, imagesIndexesArray);
    }
}
