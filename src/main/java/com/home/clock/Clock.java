package com.home.clock;

/**
 * Created by FDR on 24.04.2017.
 */
public class Clock {
    int sec = 0;
    int min = 0;
    int hour = 0;

    public String showTime() {

        String format = String.format("Время: %02d:%02d:%02d", hour, min, sec);
        return format;
    }
public void addSeconds(int seconds) {

        int addTimeHour = seconds / 3600;
        hour = (addTimeHour + hour);
        int timeHourOstatok = seconds % 3600;
        int addTimeMin = timeHourOstatok / 60;
        addMin(addTimeMin);
        int timeMinOstatok = timeHourOstatok % 60;
        sec = (timeMinOstatok + sec);
    }

    public void addMin(int minute) {
        int addTimeHour = minute / 60;
        addHour(addTimeHour);
        int timeHourOstatok = minute % 60;
        min = timeHourOstatok + min;
    }

    public void addHour(int addHour) {
        hour = addHour + hour;
    }

    @Override
    public String toString() {
        return "Clock{" + "sec=" + sec + ", min=" + min + ", hour=" + hour + '}';
    }
}
