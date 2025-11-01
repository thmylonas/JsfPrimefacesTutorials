package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.locale_services._base;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services._base.AbstractService;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@Getter
@Setter
public abstract class AbstractLocaleService extends AbstractService {

    /**
     * The final EN_LOCALE (Locale.ENGLISH)
     */
    protected static final Locale EN_LOCALE = new Locale.Builder()
            .setLanguage("en")
            .setRegion("US")
            .build();

    /**
     * The final GR_LOCALE
     */
    protected static final Locale GR_LOCALE = new Locale.Builder()
            .setLanguage("el")
            .setRegion("GR")
            .build();

    /**
     * The Map<String, Locale> of entries: (localeCode, Locale)
     */
    protected static final Map<String, Locale> LOCALES_MAP = new LinkedHashMap<>() {{
        put("En", EN_LOCALE);
        put("Gr", GR_LOCALE);
    }};

    /**
     * The global current Locale in the application
     */
    protected Locale locale;

    public String loadFlagCss() {
        return locale == EN_LOCALE ? "change_lang_en" : "change_lang_gr";
    }
}

// TODO: In "Facelets", during language switch, the WebFilter must filter the URL
