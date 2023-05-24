package org.example;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class UrlRegistry {

    private volatile Set<URL> registeredUrls = new HashSet<>();

    public synchronized void register(URL url) {
        if(registeredUrls.size() == 10 && !registeredUrls.contains(url)) {
            throw new UrlRegistryMaxSizeExceededException();
        }
        registeredUrls.add(url);
    }

    public Set<URL> getRegisteredUrls() {
        return new HashSet<>(registeredUrls);
    }


}

