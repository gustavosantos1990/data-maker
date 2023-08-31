package org.gdas.bigreportsapi.controller;

import org.gdas.bigreportsapi.mocking.MockGenerator;
import org.gdas.bigreportsapi.model.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/mock")
public class MockController {

    private final MockGenerator<Mock> mockMockGenerator;

    public MockController() {
        this.mockMockGenerator = new MockGenerator<>();
    }

    @GetMapping
    public ResponseEntity<?> get() {
        Mock mock = new Mock();
        mockMockGenerator.fill(mock);
        return ResponseEntity.ok(mock);
    }

}
