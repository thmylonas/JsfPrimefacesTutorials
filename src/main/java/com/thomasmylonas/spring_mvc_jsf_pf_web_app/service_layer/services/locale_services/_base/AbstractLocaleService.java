package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.locale_services._base;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services._base.AbstractService;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public abstract class AbstractLocaleService extends AbstractService {

    /**
     * The global current Locale in the application
     */
    protected Locale locale;

    /**
     * The final EN_LOCALE (Locale.ENGLISH)
     */
    protected final Locale EN_LOCALE = new Locale("en", "US");

    /**
     * The final GR_LOCALE
     */
    protected final Locale GR_LOCALE = new Locale("el", "GR");

    /**
     * The Map<String, Locale> of entries: (localeCode, Locale)
     */
    protected final Map<String, Locale> LOCALES_MAP = new LinkedHashMap<>() {{
        put("En", EN_LOCALE);
        put("Gr", GR_LOCALE);
    }};

    @PostConstruct
    private void init() {
        locale = EN_LOCALE;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Locale getEnLocale() {
        return EN_LOCALE;
    }

    public Locale getGrLocale() {
        return GR_LOCALE;
    }

    public String loadFlagCss() {
        return locale == EN_LOCALE ? "change_lang_en" : "change_lang_gr";
    }
}

// TODO: In "Facelets", during language switch, the WebFilter must filter the URL
