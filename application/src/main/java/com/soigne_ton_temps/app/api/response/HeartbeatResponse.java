package com.soigne_ton_temps.app.api.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

public class HeartbeatResponse {
    public final String token;
    public final OffsetDateTime time;

    @JsonCreator
    public HeartbeatResponse(@JsonProperty(value = "token", required = true) String token) {
        this.token = token;
        this.time = OffsetDateTime.now();
    }
}
