package com.eclipse.restsebootstrap;

import jakarta.ws.rs.SeBootstrap;
import java.io.IOException;
import jakarta.ws.rs.core.Application;

/**
 * This class configures and starts the SeBootstrap. This is the embedded
 * server. It uses the class that extended Application, RestConfig, to define
 * the classes that contain web service methods.
 *
 * @author Ken Fogel
 */
public class RestBootstrap {

    public static void main(String[] args) throws InterruptedException, IOException {

        // Instance of a class that extends Application
        Application app = new RestApplication();

        // Configure the service for http
        SeBootstrap.Configuration configuration = SeBootstrap.Configuration.
                builder()
                .host("localhost")
                .port(8080)
                .protocol("http")
                .build();
        
        // Start the embedded server and the web service
        SeBootstrap.start(app, configuration);
        // Keep the service running until the application is stopped
        Thread.currentThread().join();
    }
}
