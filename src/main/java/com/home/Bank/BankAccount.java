package com.home.bank;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by FDR on 16.03.2017.
 */
public class BankAccount extends ArrayList<Integer> {
    int id;
    int balanse;

    public BankAccount(int id) {
        this.id = id;
        this.balanse = 0;

    }

    static HashMap<Integer, Integer> createNAccount(int quantityOfAcc) {

        //   ArrayList<Integer> bankAccounts = new ArrayList<>();
        HashMap<Integer, Integer> bankAccHashMap = new HashMap<>();
        for (int i = 0; i < quantityOfAcc; i++) {
            BankAccount bankAccount = new BankAccount(i);
            System.out.println(bankAccount);
            bankAccHashMap.put(i, bankAccount.balanse);

        }
        return bankAccHashMap;
    }

    public void addMoneyforAccount(double money) {
        this.balanse = (int) (balanse + money);

    }

    public void takeAwayMoney(double money) {
        this.balanse = (int) (balanse - money);
    }

    public double getCurrentBalance() {
        return balanse;
    }

    public Integer getId() {
        return id;
    }

    public void zeroBalanse() {
        this.balanse = 0;
    }

    public void transferMoney(BankAccount id, double money) {
        this.takeAwayMoney(money);
        id.addMoneyforAccount(money);
    }


    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", balanse=" + balanse +
                '}';
    }
}
