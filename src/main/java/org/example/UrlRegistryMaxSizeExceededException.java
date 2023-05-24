package org.example;

public class UrlRegistryMaxSizeExceededException extends RuntimeException {

    public UrlRegistryMaxSizeExceededException() {
        super("UrlRegistry maximum size exceeded. Please remove some urls first!");
    }
}
