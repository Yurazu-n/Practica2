package org.example.control;

public class Main {
    public static void main(String[] args) {
        WeatherControl weatherControl = new WeatherControl();
        weatherControl.execute(args[0]);
    }
}
