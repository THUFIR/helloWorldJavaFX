package net.bounceme.dur.fx.google;

import com.google.gson.JsonObject;
import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixRow;
import com.google.maps.model.TravelMode;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class GoogleMapsQuery {

    private static final Logger log = Logger.getLogger(GoogleMapsQuery.class.getName());

    public GoogleMapsQuery() {
    }

    public void query(Properties properties) throws ApiException, InterruptedException, IOException {
        log.info("how to get the travel time between two zip codes?");

        String key = properties.getProperty("api_key");
        String origin = properties.getProperty("origin");
        String destination = properties.getProperty("destination");

        log.info(key);
        log.info(origin);
        log.info(destination);

        GeoApiContext distanceCalculator = new GeoApiContext.Builder()
                .apiKey(key)
                .build();

        DistanceMatrixApiRequest distanceMatrixRequest = DistanceMatrixApi.newRequest(distanceCalculator);
        DistanceMatrix distanceMatrixResult = distanceMatrixRequest.origins(origin)
                .destinations(destination)
                .mode(TravelMode.DRIVING)
                .avoid(RouteRestriction.TOLLS)
                .language("en-US")
                .await();

        log.info(distanceMatrixResult.toString());

        DistanceMatrixRow[] rows = distanceMatrixResult.rows;
        int length = rows.length;

        JsonObject jo = new JsonObject();
        
        for (Object object : rows) {
            log.info(object.toString());
        }
        
       
      
        
        
        
        
    }

}
