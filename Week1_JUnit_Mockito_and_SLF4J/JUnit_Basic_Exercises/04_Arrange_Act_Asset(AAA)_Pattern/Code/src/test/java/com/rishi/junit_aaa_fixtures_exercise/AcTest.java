package com.rishi.junit_aaa_fixtures_exercise;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AcTest {

    private SmartAc ac;

    // Setup: runs before every single test
    @Before
    public void setUp() {
        System.out.println("Setting up AC to default 24 degrees...");
        ac = new SmartAc(24);
    }

    @Test
    public void testCoolingFunction() {
        // Arrange
        int dropDegrees = 4;
        int expectedTemp = 20;

        // Act
        ac.coolDown(dropDegrees);

        // Assert
        assertEquals(expectedTemp, ac.getCurrentTemperature());
    }

    @Test
    public void testHeatingFunction() {
        // Arrange
        int raiseDegrees = 3;
        int expectedTemp = 27;

        // Act
        ac.heatUp(raiseDegrees);

        // Assert
        assertEquals(expectedTemp, ac.getCurrentTemperature());
    }

    // Teardown: runs after every single test
    @After
    public void tearDown() {
        System.out.println("Turning off AC instance...");
        ac = null;
    }
}