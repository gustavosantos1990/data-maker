package org.gdas.bigreportsapi.mocking;

import org.gdas.bigreportsapi.model.annotation.MockedProperty;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class MockGenerator {

    private final Random random = new Random();

    public <T> T create(Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getConstructor();
            T newInstance = constructor.newInstance();
            for (Field field : newInstance.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(MockedProperty.class)) {
                    field.setAccessible(true);
                    Class<?> fieldType = field.getType().arrayType().getComponentType();
                    MockedProperty mockProperty = field.getAnnotation(MockedProperty.class);
                    Object generatedValue = valueFromType(fieldType, mockProperty);
                    field.set(newInstance, generatedValue);
                }
            }
            return newInstance;
        } catch(IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e   ) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }

    private Object valueFromType(Class<?> clazz, MockedProperty mock) {
        if (String.class.equals(clazz)) return mock.onlyDigits() ? random(mock.size(), false, true) : randomAlphabetic(mock.size());
        if (UUID.class.equals(clazz)) return UUID.randomUUID();
        if (Long.class.equals(clazz)) return random.nextLong(mock.min(), mock.max());
        if (LocalDate.class.equals(clazz)) return LocalDate.now();
        if (BigDecimal.class.equals(clazz)) return BigDecimal.valueOf(random.nextLong(mock.min(), mock.max()));
        return new Object();
    }

}
