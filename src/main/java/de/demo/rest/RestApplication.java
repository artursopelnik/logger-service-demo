package de.demo.rest;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api/v1")
public class RestApplication extends Application {
    // No additional configuration needed for this simple application
}
