package net.bounceme.dur.fx;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.logging.Logger;
import net.bounceme.dur.fx.google.GoogleBookQuery;

public class App {

    private static final Logger log = Logger.getLogger(App.class.getName());
    private Properties properties = new Properties();

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        new App().runApp();
    }

    private void runApp() throws IOException, GeneralSecurityException {
        properties.loadFromXML(App.class.getResourceAsStream("/properties.xml"));
        GoogleBookQuery g = new GoogleBookQuery();
        g.foo(properties);
    }
}
