package de.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogResponse {

    private String status;
    private String message;

    public static LogResponse success() {
        return new LogResponse("SUCCESS", "Log erfolgreich verarbeitet");
    }

    public static LogResponse error(String message) {
        return new LogResponse("ERROR", message);
    }

    public static LogResponse unauthorized() {
        return new LogResponse("UNAUTHORIZED", "Ungültiger Token");
    }
}
