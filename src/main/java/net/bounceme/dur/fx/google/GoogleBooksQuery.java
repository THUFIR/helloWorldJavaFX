package net.bounceme.dur.fx.google;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.services.books.Books;
import com.google.api.services.books.BooksRequestInitializer;
import java.util.Properties;
import java.util.logging.Logger;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books.Volumes;
import com.google.api.services.books.Books.Volumes.List;
import com.google.api.services.books.model.Volume;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class GoogleBooksQuery {

    private static final Logger log = Logger.getLogger(GoogleBooksQuery.class.getName());

    public void bookQuery(Properties properties) throws GeneralSecurityException, IOException {

        String key = properties.getProperty("api_key");
        String query = properties.getProperty("text_to_translate");
        String app = properties.getProperty("application_name");

        log.info("key\t\t" + key);
        log.info("app\t\t" + app);
        log.info("book\t\t" + query);

        JsonFactory jsonFactory;
        jsonFactory = new JacksonFactory();

        final Books books = new Books.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, null)
                .setApplicationName(app)
                .setGoogleClientRequestInitializer(new BooksRequestInitializer(key))
                .build();

        List volumesList = books.volumes().list(query);
        volumesList.setFilter("ebooks");

        log.info(volumesList.toString());

        com.google.api.services.books.model.Volumes volumes = volumesList.execute();

        for (Volume volume : volumes.getItems()) {
            Volume.VolumeInfo volumeInfo = volume.getVolumeInfo();
            Volume.SaleInfo saleInfo = volume.getSaleInfo();
            
            log.info(saleInfo.toPrettyString());
        }

    }
}
