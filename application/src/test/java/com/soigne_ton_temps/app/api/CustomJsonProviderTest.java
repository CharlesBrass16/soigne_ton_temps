package com.soigne_ton_temps.app.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.soigne_ton_temps.app.api.CustomJsonProvider;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomJsonProviderTest {

    @Test
    public void whenCreatingCustomJsonProvider_thenMapperIsConfiguredCorrectly() {
        CustomJsonProvider provider = new CustomJsonProvider();
        ObjectMapper mapper = provider.locateMapper(Object.class, MediaType.APPLICATION_JSON_TYPE);

        assertNotNull(mapper);
        assertFalse(mapper.getDeserializationConfig().isEnabled(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES));
        assertFalse(mapper.getSerializationConfig().isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS));
        assertTrue(mapper.getDateFormat() instanceof StdDateFormat);
    }
}
