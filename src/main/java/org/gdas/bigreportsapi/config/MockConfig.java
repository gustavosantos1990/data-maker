package org.gdas.bigreportsapi.config;

import org.gdas.bigreportsapi.mocking.MockGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockConfig {

    @Bean
    public MockGenerator mockGenerator() {
        return new MockGenerator();
    }
}
