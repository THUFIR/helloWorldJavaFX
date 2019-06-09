package net.bounceme.dur.fx.google;

import java.util.Properties;
import java.util.logging.Logger;

public class GoogleBookQuery {

    private static final Logger log = Logger.getLogger(GoogleBookQuery.class.getName());

    public void foo(Properties properties) {

        String key = properties.getProperty("api_key");
        String originalLanguage = properties.getProperty("original_language");
        String translatedLanguage = properties.getProperty("translated_language");
        String text = properties.getProperty("text_to_translate");

        log.info("key\t\t" + key);
        log.info("from\t\t" + originalLanguage);
        log.info("to\t\t" + translatedLanguage);
        log.info("text\t\t" + text);

    }
}
