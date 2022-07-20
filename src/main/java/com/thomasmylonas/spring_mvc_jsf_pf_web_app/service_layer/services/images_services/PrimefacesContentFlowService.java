package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.images_services;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer._enums.ImagesEnum;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.images_services._base.ImagesService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import java.util.List;

@Service(value = "primefacesContentFlowService")
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
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
