package de.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LogRequest {

    private String traceId;

    @NotBlank
    private String application;

    private String userId;
    private String message;
    private ClientInfo client;
    private String timestamp;

    @Data
    public static class ClientInfo {
        private String userAgent;
        private String windowResolution;
        private String screenResolution;
    }
}
