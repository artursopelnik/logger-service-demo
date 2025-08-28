package de.demo.service;

import de.demo.dto.LogRequest;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class SplunkService {

    public String sendToSplunk(LogRequest logRequest, String userId) {
        // Dummy-Logik: generiere eine Splunk-RequestId
        // Hier später REST-Call zu Splunk einfügen
        return UUID.randomUUID().toString();
    }
}
