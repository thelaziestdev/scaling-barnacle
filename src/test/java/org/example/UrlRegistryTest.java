package org.example;

import org.junit.jupiter.api.Test;


import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class UrlRegistryTest {

    private UrlRegistry urlRegistry = new UrlRegistry();

    @Test
    void givenValidUrlItShouldBeRegistered() throws MalformedURLException {
        //given
        var url = new URL("http://mydomain.com");

        //when
        urlRegistry.register(url);

        //then
        var result = urlRegistry.getRegisteredUrls().stream().findFirst().get();
        assertEquals(result.toString(), url.toString());
    }

    @Test
    void givenRegistryWithMaxSizeExceededWhenAddingNewUrlItShouldThrowException() throws MalformedURLException {
        //given
        var url = new URL("http://mydomain.com");
        for (int i = 0; i < 10; i++) {
            urlRegistry.register(new URL("http://mydomain" + i + ".com"));
        }

        assertThrows(UrlRegistryMaxSizeExceededException.class, () -> {
            urlRegistry.register(url);
        });
    }

    @Test
    void givenRegistryWithMaxSizeExceededWhenAddingNewUrlItShouldThrowException2() throws MalformedURLException {
        //given
        var url = new URL("http://mydomain1.com");
        for (int i = 0; i < 10; i++) {
            urlRegistry.register(new URL("http://mydomain" + i + ".com"));
        }

        assertThrows(UrlRegistryMaxSizeExceededException.class, () -> {
            urlRegistry.register(url);
        });
    }

    @Test
    void givenUrlInRegistryWhenAddingTheSameItShouldNotIncreaseTheSizeOfRegistry() throws MalformedURLException {
        //given
        var url = new URL("http://mydomain.com");
        urlRegistry.register(url);

        //when
        urlRegistry.register(new URL("http://mydomain.com"));

        //then
        var result = urlRegistry.getRegisteredUrls().size();
        assertEquals(1, result);
    }

    @Test
    void givenRegistryWithMaxSizeExceededWhenAddingNewUrlItShouldThrowException3() throws MalformedURLException {
        //given
        var url = new URL("http://mydomain.com");
        for (int i = 0; i < 10; i++) {
            urlRegistry.register(new URL("http://mydomain" + i + ".com"));
        }

        assertThrows(UrlRegistryMaxSizeExceededException.class, () -> {
            urlRegistry.register(url);
        });
    }

}
