package org.gdas.bigreportsapi.controller;

import org.gdas.bigreportsapi.config.JSONWriter;
import org.gdas.bigreportsapi.mocking.MockGenerator;
import org.gdas.bigreportsapi.model.Mock;

import static spark.Spark.get;

public class MockController {

    private final MockGenerator mockMockGenerator = new MockGenerator();

    public MockController() {
        exposeGet();
    }

    private void exposeGet() {
        get("/v1/mock", (req, res) -> {
            res.type("application/json");
            return mockMockGenerator.create(Mock.class);
        }, new JSONWriter());
    }

}
