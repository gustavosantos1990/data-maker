package org.gdas.bigreportsapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.gdas.bigreportsapi.model.annotation.Mocked;
import org.gdas.bigreportsapi.model.annotation.MockedProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Mock implements Mocked {

    @JsonProperty
    @MockedProperty
    private UUID id;

    @JsonProperty("social_number")
    @MockedProperty(onlyDigits = true, size = 11)
    private String socialNumber;

    @JsonProperty("first_name")
    @MockedProperty(size = 10)
    private String firstName;

    @JsonProperty("last_name")
    @MockedProperty(size = 10)
    private String lastName;

    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @MockedProperty
    private LocalDate birthday;

    @JsonProperty
    @MockedProperty(size = 50)
    private String address;

    @JsonProperty
    @MockedProperty(max = 9999)
    private Long number;

    @JsonProperty
    @MockedProperty(size = 30)
    private String complement;

    @JsonProperty
    @MockedProperty(size = 20)
    private String neighborhood;

    @JsonProperty
    @MockedProperty(size = 30)
    private String city;

    @JsonProperty
    @MockedProperty(size = 30)
    private String state;

    @JsonProperty
    @MockedProperty(size = 30)
    private String country;

    @JsonProperty("hiring_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @MockedProperty
    private LocalDate hiring_date;

    @JsonProperty
    @MockedProperty(min = 10_000, max = 1_000_000)
    private BigDecimal salary;

}
