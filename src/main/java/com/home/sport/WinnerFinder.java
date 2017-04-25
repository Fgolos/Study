package com.home.sport;

import org.omg.CORBA.Object;

import java.util.ArrayList;

/**
 * Created by FDR on 21.04.2017.
 */
public class WinnerFinder {
    ArrayList<Sportsmen> sportsmens;

    public WinnerFinder(ArrayList<Sportsmen> sportsmens) {
        this.sportsmens = sportsmens;
    }

    public void showWinner() {
        Sportsmen currentWinner = sportsmens.get(0);
        for (int i = 0; i < sportsmens.size(); i++) {
            if (sportsmens.get(i).bestAttempt() > currentWinner.bestAttempt()) {
                currentWinner = sportsmens.get(i);
            }
        }
        System.out.println(currentWinner);


    }
}
