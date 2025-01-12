package com.soigne_ton_temps.app.api;

import com.soigne_ton_temps.app.api.response.HeartbeatResponse;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/heartbeat")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HeartbeatResource {
    private final Logger logger = LoggerFactory.getLogger(HeartbeatResource.class);

    @GET
    public HeartbeatResponse heartbeat(@QueryParam("token") @NotNull String token) {
        logger.info("Received heartbeat : " + token);
        return new HeartbeatResponse(token);
    }
}
