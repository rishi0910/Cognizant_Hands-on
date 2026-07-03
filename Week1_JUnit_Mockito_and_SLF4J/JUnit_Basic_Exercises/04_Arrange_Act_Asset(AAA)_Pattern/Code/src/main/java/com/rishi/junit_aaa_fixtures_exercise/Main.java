package com.rishi.junit_aaa_fixtures_exercise;

public class Main {
    public static void main(String[] args) {
        SmartAc ac = new SmartAc(24);
        System.out.println("AC Controller Turned On.");
        ac.coolDown(4);
        System.out.println("New Target Temperature: " + ac.getCurrentTemperature() + "°C");
    }
}