package com.skyscanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class HoenScannerApplication extends Application<HoenScannerConfiguration> {
    public static void main(final String[] args) throws Exception {
        new HoenScannerApplication().run(args);
    }

    @Override
    public String getName() {
        return "hoen-scanner";
    }

    @Override
    public void initialize(final Bootstrap<HoenScannerConfiguration> bootstrap) { }

    @Override
    public void run(final HoenScannerConfiguration configuration,
                    final Environment environment) throws IOException {
        ObjectMapper mapper = environment.getObjectMapper();
        List<SearchResult> searchResults = new ArrayList<>();
        searchResults.addAll(loadResults(mapper, "rental_cars.json"));
        searchResults.addAll(loadResults(mapper, "hotels.json"));
        environment.jersey().register(new SearchResource(searchResults));
        System.out.println("Welcome to Hoen Scanner!");
    }

    private List<SearchResult> loadResults(ObjectMapper mapper, String filename)
            throws IOException {
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream(filename)) {
            if (stream == null) {
                throw new IOException("Missing required resource: " + filename);
            }
            return mapper.readValue(stream, new TypeReference<List<SearchResult>>() { });
        }
    }
}
