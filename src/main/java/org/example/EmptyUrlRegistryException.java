package org.example;

public class EmptyUrlRegistryException extends RuntimeException {

    public EmptyUrlRegistryException() {
        super("Url registry is empty! Please add some urls first!");
    }
}
