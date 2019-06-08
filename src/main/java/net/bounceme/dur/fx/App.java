package net.bounceme.dur.fx;

import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class App {

    private static final Logger log = Logger.getLogger(App.class.getName());
    private Properties properties = new Properties();

    private void distance() throws IOException, ApiException, InterruptedException  {
        log.info("how to load key and set the context?");

        properties.loadFromXML(App.class.getResourceAsStream("/properties.xml"));
        String key = properties.getProperty("api_key");
        String origin = properties.getProperty("origin");
        String destination = properties.getProperty("destinatio");

        
        log.info(key);
        log.info(origin);
        log.info(destination);
        
        GeoApiContext distCalcer = new GeoApiContext.Builder()
                .apiKey(key)
                .build();

        DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(distCalcer);
        DistanceMatrix result = req.origins(origin)
                .destinations(destination)
                .mode(TravelMode.DRIVING)
                .avoid(RouteRestriction.TOLLS)
                .language("en-US")
                .await();

        /*
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(GOOGLE_MAPS_API_KEY)
                .build();
        DistanceMatrixApiRequest distanceMatrixApiRequest = DistanceMatrixApi.newRequest(context)
                .mode(TravelMode.DRIVING)
                .trafficModel(TrafficModel.BEST_GUESS)
                .departureTime(Instant.now().atZone(ZoneOffset.UTC).toInstant())
                .destinations(destination)
                .origins(origin);
         */
    }

    public static void main(String[] args) throws IOException, ApiException, InterruptedException {
        new App().distance();
    }
}
