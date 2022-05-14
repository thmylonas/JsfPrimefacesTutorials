package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class Messages extends ResourceBundle {

    private static final String BUNDLE_NAME = "resource_bundles.messages";
    private static final String BUNDLE_EXTENSION = "properties";
    private static final String CHARSET = "UTF-8";
    private static final Control UTF8_CONTROL = new UTF8Control();

    public Messages() {
        setParent(ResourceBundle.getBundle(BUNDLE_NAME, FacesContext.getCurrentInstance().getViewRoot().getLocale(), UTF8_CONTROL));
    }

    @Override
    protected Object handleGetObject(String key) {
        return parent.getObject(key);
    }

    @Override
    public Enumeration<String> getKeys() {
        return parent.getKeys();
    }

    private static class UTF8Control extends Control {

        /**
         * The below code is copied from default "Control::newBundle" implementation.
         * Only the PropertyResourceBundle line is changed to read the file as UTF-8.
         *
         * @param baseName The base bundle name of the resource bundle, a fully qualified class name
         * @param locale   The locale for which the resource bundle should be instantiated
         * @param format   The resource bundle format to be loaded
         * @param loader   The ClassLoader to use to load the bundle
         * @param reload   The flag to indicate bundle reloading; true if reloading an expired resource bundle, false otherwise
         * @return The resource bundle instance, or null if none could be found
         * @throws IOException If an error occurred when reading resources using any I/O operations
         */
        public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
                throws IOException {

            String bundleName = toBundleName(baseName, locale);
            String resourceName = toResourceName(bundleName, BUNDLE_EXTENSION);
            ResourceBundle bundle = null;
            InputStream stream = null;
            if (reload) {
                URL url = loader.getResource(resourceName);
                if (url != null) {
                    URLConnection connection = url.openConnection();
                    if (connection != null) {
                        connection.setUseCaches(false);
                        stream = connection.getInputStream();
                    }
                }
            } else {
                stream = loader.getResourceAsStream(resourceName);
            }
            if (stream != null) {
                try {
                    bundle = new PropertyResourceBundle(new InputStreamReader(stream, CHARSET));
                } finally {
                    stream.close();
                }
            }
            return bundle;
        }
    }
}
