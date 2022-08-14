package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import dataaccess.SensorReadingJSONParser;
import domain.SensorReading;

public class Main {
    public static void main(String[] args) {
        ArrayList<SensorReading> sensorReadings = new ArrayList<SensorReading>();

        try {
            SensorReadingJSONParser.readFile("2742ex2f/resources/readings.json");
            sensorReadings = SensorReadingJSONParser.getSensorReadings();
        } catch (Exception e) {
            System.out.println(e);
        }
        for (SensorReading r : sensorReadings) {
            System.out.println(r.toString());
        }
    }
}
