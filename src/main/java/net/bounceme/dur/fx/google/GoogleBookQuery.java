package net.bounceme.dur.fx.google;

import java.util.Properties;
import java.util.logging.Logger;

public class GoogleBookQuery {

    private static final Logger log = Logger.getLogger(GoogleBookQuery.class.getName());

    public void foo(Properties properties) {

        log.info("starting");
        String key = properties.getProperty("api_key");
        String book = properties.getProperty("text_to_translate");

        log.info("key\t\t" + key);
        log.info("book\t\t" + book);

    }
}
