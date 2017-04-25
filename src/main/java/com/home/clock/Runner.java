package com.home.clock;

/**
 * Created by FDR on 24.04.2017.
 */
public class Runner {
    public static void main(String[] args) {
        Clock clock = new Clock();
        System.out.println(clock);
        clock.addSeconds(3601);
        System.out.println( clock.showTime());
    }
}
