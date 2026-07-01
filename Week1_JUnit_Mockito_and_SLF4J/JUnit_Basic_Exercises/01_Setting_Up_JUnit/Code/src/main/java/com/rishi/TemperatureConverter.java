package com.rishi;

//Method to handle temperature conversion and freezing point checks
public class TemperatureConverter {
	// Converts Celsius to Fahrenheit
    public double convertToFahrenheit(double celsiusValue) {
        return (celsiusValue * 9 / 5) + 32;
    }

    // Checks if the temperature is at or below freezing point
    public boolean isFreezingPoint(double celsiusValue) {
        return celsiusValue <= 0;
    }

}
