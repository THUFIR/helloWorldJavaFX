package net.bounceme.dur.fx;

import com.google.maps.errors.ApiException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.logging.Logger;
import net.bounceme.dur.fx.google.GoogleBooksQuery;
import net.bounceme.dur.fx.google.GoogleMapsQuery;

public class App {

    private static final Logger log = Logger.getLogger(App.class.getName());
    private Properties properties = new Properties();

    public static void main(String[] args) throws IOException, GeneralSecurityException, ApiException, InterruptedException     {
        new App().runApp();
    }

    private void runApp() throws IOException, GeneralSecurityException, ApiException, InterruptedException   {
        properties.loadFromXML(App.class.getResourceAsStream("/properties.xml"));
        
       // GoogleBooksQuery googleBooksQuery = new GoogleBooksQuery();
     //   googleBooksQuery.bookQuery(properties);
        
     //   GoogleMapsQuery gmq = new GoogleMapsQuery();
     //   gmq.query(properties);
        
    }
}
