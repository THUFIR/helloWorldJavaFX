package net.bounceme.dur.fx;

import java.util.logging.Logger;

public class App {

    private static final Logger LOG = Logger.getLogger(App.class.getName());
//    private Properties properties = new Properties();

    public void runApp() {
        LOG.info("how to import java fx?");
    }

    public static void main(String[] args) {
        new App().runApp();
    }
}
