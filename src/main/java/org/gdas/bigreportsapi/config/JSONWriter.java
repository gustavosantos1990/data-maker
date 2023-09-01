package org.gdas.bigreportsapi.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import spark.ResponseTransformer;

public class JSONWriter implements ResponseTransformer {

    private final ObjectMapper mapper;

    public JSONWriter() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public String render(Object o) throws Exception {
        return mapper.writeValueAsString(o);
    }

}
