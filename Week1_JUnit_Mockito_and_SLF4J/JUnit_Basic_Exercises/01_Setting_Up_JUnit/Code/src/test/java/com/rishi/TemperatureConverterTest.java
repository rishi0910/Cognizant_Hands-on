package com.rishi;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// Test suite for checking temperature conversion logic
public class TemperatureConverterTest {

    private final TemperatureConverter evalTarget = new TemperatureConverter();

    // Test case for Celsius to Fahrenheit conversion
    @Test
    public void verifyThermalConversion() {
        double expectedFahrenheit = 77.0;
        double realFahrenheit = evalTarget.convertToFahrenheit(25.0);
        
        assertEquals("Conversion mismatch.", expectedFahrenheit, realFahrenheit, 0.001);
    }

    // Test case for freezing point validation
    @Test
    public void verifyFreezingEvaluation() {
        boolean checkState = evalTarget.isFreezingPoint(-5.0);
        assertTrue("Freezing point check failed.", checkState);
    }
}