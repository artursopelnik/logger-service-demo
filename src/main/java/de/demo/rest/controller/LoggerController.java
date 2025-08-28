package de.demo.rest.controller;

import de.demo.dto.LogRequest;
import de.demo.dto.LogResponse;
import de.demo.service.AuthenticationService;
import de.demo.service.SplunkService;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.UUID;

@Data
@Path("/log")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoggerController {

    private static final Logger LOGGER = LogManager.getLogger(LoggerController.class);

    @Inject
    private AuthenticationService authenticationService;

    @Inject
    private SplunkService splunkService;

    @POST
    public Response logData(@HeaderParam("Auth") String authCookie,
                            @Valid LogRequest logRequest) {

        String requestTraceId = UUID.randomUUID().toString();

        LOGGER.info("Log-Request erhalten - TraceId: {}, Application: {}",
                logRequest.getTraceId(), logRequest.getApplication());

        try {
            /*
            if (!authenticationService.isValidToken(authCookie)) {
                LOGGER.warn("Authentifizierung fehlgeschlagen - TraceId: {}", requestTraceId);
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(LogResponse.unauthorized())
                        .build();
            }

            String userId = authenticationService.extractUserIdFromToken(authCookie);

            if (logRequest.getRequestId() == null || logRequest.getRequestId().isEmpty()) {
                logRequest.setRequestId(requestTraceId);
            }

            if (logRequest.getUserId() == null || logRequest.getUserId().isEmpty()) {
                logRequest.setUserId(userId);
            }

            String splunkRequestId = splunkService.sendToSplunk(logRequest, userId); */

            String userId = "dummy-user";

            LOGGER.info("Log erfolgreich verarbeitet - TraceId: {}, User: {}, User: {}",
                    requestTraceId, userId, userId);

            return Response.status(Response.Status.CREATED)
                    .entity(LogResponse.success())
                    .build();

        } catch (Exception e) {
            LOGGER.error("Fehler beim Verarbeiten des Log-Requests - TraceId: {}", requestTraceId, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(LogResponse.error("Interner Serverfehler beim Verarbeiten des Log-Requests"))
                    .build();
        }
    }
}
