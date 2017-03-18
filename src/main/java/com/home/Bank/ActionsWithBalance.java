package com.home.bank;

import java.util.ArrayList;

/**
 * Created by FDR on 16.03.2017.
 */
public class ActionsWithBalance {
    int id;
    int balance;
    int number;

    public ActionsWithBalance(int id, int balance, int number) {
        this.id = id;
        this.balance = balance;
        this.number = number;
    }

    public ArrayList<Integer> action() {
        action().set(id, balance + number);
        return action();
    }
}
