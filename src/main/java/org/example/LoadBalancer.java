package org.example;

import java.net.URL;
import java.util.Random;

public class LoadBalancer {

    private UrlRegistry urlRegistry;

    public LoadBalancer(UrlRegistry urlRegistry) {
        this.urlRegistry = urlRegistry;
    }

    URL getUrl() {
        if (urlRegistry.getRegisteredUrls().isEmpty()) {
            throw new EmptyUrlRegistryException();
        }
        var randomIndex = new Random().nextInt(urlRegistry.getRegisteredUrls().size()-1);
        return urlRegistry.getRegisteredUrls().stream().toList().get(randomIndex);
    }
}
