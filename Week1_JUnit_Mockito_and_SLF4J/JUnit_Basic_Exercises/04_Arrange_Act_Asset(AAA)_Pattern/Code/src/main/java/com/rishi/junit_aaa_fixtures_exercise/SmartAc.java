package com.rishi.junit_aaa_fixtures_exercise;

public class SmartAc {
    private int currentTemperature;

    public SmartAc(int defaultTemp) {
        this.currentTemperature = defaultTemp;
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public void coolDown(int degrees) {
        currentTemperature -= degrees;
    }
    public void heatUp(int degrees) {
        currentTemperature += degrees;
    }
}