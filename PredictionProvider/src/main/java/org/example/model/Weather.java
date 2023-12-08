package org.example.model;


import java.time.Instant;

public class Weather {
    private double temp;
    private int humidity;
    private double windSpeed;
    private int clouds;
    private double precipitationProb;
    private String ts, ss, predictionTime;
    private Location location;

    public Weather(double temp, int humidity, double windSpeed, int clouds,
                   double precipitationProb, String ts, String ss, String predictionTime, Location location) {
        this.temp = temp;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.clouds = clouds;
        this.precipitationProb = precipitationProb;
        this.ts = ts;
        this.ss = ss;
        this.predictionTime = predictionTime;
        this.location = location;
    }

    public double getTemp() {
        return temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public int getClouds() {
        return clouds;
    }

    public double getPrecipitationProb() {
        return precipitationProb;
    }

    public String getTs() {return ts;}

    public String getSs() {return ss;}

    public String getPredictionTime() {return predictionTime;}

    public Location getLocation() {return location;}
}