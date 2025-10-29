package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.locale_services;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.locale_services._base.AbstractLocaleService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.util.Locale;
import java.util.Map;

@ManagedBean(name = "faceletsLocaleService")
@Getter
@Setter
public class FaceletsLocaleService extends AbstractLocaleService {

    /**
     * This is the value of the "p:selectBooleanButton".
     * if (english==true) then locale==EN_LOCALE
     * if (english==false) then locale==GR_LOCALE
     */
    private boolean english;

    @PostConstruct
    private void init() {
        english = true;
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
