package dataaccess;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import domain.SensorReading;

public class SensorReadingJSONParser {
    private static String json = "{}";

    public static void readFile(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(path)))
        {
            String line = "";
            StringBuilder sbJSON = new StringBuilder(400);
            while ((line = reader.readLine())!=null) {
                sbJSON.append(line + "\n");
            }
            json = sbJSON.toString();
        }
    }

    public static ArrayList<SensorReading> getSensorReadings() {
        ArrayList<SensorReading> sensorReadings = new ArrayList<SensorReading>();
        JSONObject obj = new JSONObject(json);
        JSONArray jsonReadings = obj.getJSONArray("readings");
        if (jsonReadings != null) {
            for (int i = 0; i < jsonReadings.length(); i++) {
                try {
                    JSONObject jsonSensorReading = (JSONObject) jsonReadings.get(i);
                    SensorReading sensorReading = null;
                    int sensorReadingId = jsonSensorReading.getInt("sensorReadingId");
                    int sensorId = jsonSensorReading.getInt("sensorId");
                    String strDateTime = jsonSensorReading.getString("dateTime");
                    LocalDateTime localDateTime = LocalDateTime.parse(strDateTime);
                    float value = jsonSensorReading.getFloat("value");
                    sensorReading = new SensorReading(sensorReadingId, sensorId, localDateTime, value);
                    sensorReadings.add(sensorReading);
                }
                catch (JSONException e) {
                    System.out.println(e);
                }
                catch (DateTimeParseException e) {
                    System.out.println(e);
                }
                catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

        return sensorReadings;
    }
}
