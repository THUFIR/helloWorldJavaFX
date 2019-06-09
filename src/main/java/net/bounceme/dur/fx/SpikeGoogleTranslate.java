package net.bounceme.dur.fx;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.translate.Translate;
import com.google.api.services.translate.TranslateRequestInitializer;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.logging.Logger;

public class SpikeGoogleTranslate {

    private static final Logger log = Logger.getLogger(SpikeGoogleTranslate.class.getName());

    public void translate(Properties properties) throws IOException, GeneralSecurityException {
        String key = properties.getProperty("api_key");
        String originalLanguage = properties.getProperty("original_language");
        String translatedLanguage = properties.getProperty("translated_language");
        String text = properties.getProperty("text");
        log.info(key + originalLanguage + translatedLanguage + text);

        // set key created via google cloud console
        final TranslateRequestInitializer KEY_INITIALIZER = new TranslateRequestInitializer(key);

        // Set up the HTTP transport and JSON factory
        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

        // set up translate
        final Translate translate = new Translate.Builder(httpTransport, jsonFactory, null)
                .setApplicationName("My Project")
                .setTranslateRequestInitializer(KEY_INITIALIZER)
                .build();

        // list languages
        {
            System.out.println(translate.languages().list().execute());
            // output: {"languages":[{"language":"af"},{"language":"ar"},{"language":"az"},{"language":"be"},{"language":"bg"},{"language":"bn"},{"language":"bs"},{"language":"ca"},{"language":"ceb"},{"language":"cs"},{"language":"cy"},{"language":"da"},{"language":"de"},{"language":"el"},{"language":"en"},{"language":"eo"},{"language":"es"},{"language":"et"},{"language":"eu"},{"language":"fa"},{"language":"fi"},{"language":"fr"},{"language":"ga"},{"language":"gl"},{"language":"gu"},{"language":"ha"},{"language":"hi"},{"language":"hmn"},{"language":"hr"},{"language":"ht"},{"language":"hu"},{"language":"hy"},{"language":"id"},{"language":"ig"},{"language":"is"},{"language":"it"},{"language":"iw"},{"language":"ja"},{"language":"jw"},{"language":"ka"},{"language":"kk"},{"language":"km"},{"language":"kn"},{"language":"ko"},{"language":"la"},{"language":"lo"},{"language":"lt"},{"language":"lv"},{"language":"mg"},{"language":"mi"},{"language":"mk"},{"language":"ml"},{"language":"mn"},{"language":"mr"},{"language":"ms"},{"language":"mt"},{"language":"my"},{"language":"ne"},{"language":"nl"},{"language":"no"},{"language":"ny"},{"language":"pa"},{"language":"pl"},{"language":"pt"},{"language":"ro"},{"language":"ru"},{"language":"si"},{"language":"sk"},{"language":"sl"},{"language":"so"},{"language":"sq"},{"language":"sr"},{"language":"st"},{"language":"su"},{"language":"sv"},{"language":"sw"},{"language":"ta"},{"language":"te"},{"language":"tg"},{"language":"th"},{"language":"tl"},{"language":"tr"},{"language":"uk"},{"language":"ur"},{"language":"uz"},{"language":"vi"},{"language":"yi"},{"language":"yo"},{"language":"zh"},{"language":"zh-TW"},{"language":"zu"}]}
        }

        // translate
        {
            // phrases
            final ImmutableList<String> phrasesToTranslate = ImmutableList.<String>builder().add("Hello world").add("Where can I walk my dog").build();
            // perform
            System.out.println(translate.translations().list(phrasesToTranslate, "fr").execute());
            // output: {"translations":[{"detectedSourceLanguage":"en","translatedText":"Bonjour le monde"},{"detectedSourceLanguage":"en","translatedText":"Où puis-je promener mon chien"}]}
        }
    }

}
