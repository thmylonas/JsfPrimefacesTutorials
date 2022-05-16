package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.services.locale_services;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.services.locale_services._base.AbstractLocaleService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.util.Locale;
import java.util.Map;

@Service(value = "faceletsLocaleService")
public class FaceletsLocaleService extends AbstractLocaleService {

    /**
     * This is the value of the "p:selectBooleanButton".
     * if (isEnglish==true) then locale==EN_LOCALE
     * if (isEnglish==false) then locale==GR_LOCALE
     */
    private boolean isEnglish;

    @PostConstruct
    private void init() {
        isEnglish = true;
    }

    public boolean isEnglish() {
        return isEnglish;
    }

    public void setEnglish(boolean english) {
        isEnglish = english;
    }

    private boolean isLocaleEnglish(Locale locale) {
        return locale == EN_LOCALE;
    }

    public void switchLocale(ValueChangeEvent event) {

        Boolean hasLocaleChanged = (Boolean) event.getNewValue();

        for (Map.Entry<String, Locale> localeEntry : LOCALES_MAP.entrySet()) {
            if (isLocaleEnglish(localeEntry.getValue()) == hasLocaleChanged) {
                FacesContext.getCurrentInstance().getViewRoot().setLocale(localeEntry.getValue());
                locale = localeEntry.getValue();
                //LocaleContextHolder.setLocale(locale);
            }
        }
    }
}
