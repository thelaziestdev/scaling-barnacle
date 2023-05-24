package org.example;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class LoadBalancerTest {

    @Test
    void givenRegistryWithAddressesItShouldReturnOneOfAddressesCorrectly() throws MalformedURLException {
        // given
        var urlRegistry =  new UrlRegistry();
        for (int i = 0; i < 10; i++) {
            urlRegistry.register(new URL("http://mydomain" + i + ".com"));
        }
        var loadBalancer = new LoadBalancer(urlRegistry);

        // when
        var result = loadBalancer.getUrl();

        // then
        assertTrue(urlRegistry.getRegisteredUrls().contains(result));

    }

}
