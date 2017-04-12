package com.home.supermarket;

/**
 * Created by FDR on 20.03.2017.
 */
public class Supermarket {
    int money;
    int countOfProduct;
    public Supermarket(int money, int countOfProduct) {
        this.money = money;
        this.countOfProduct = countOfProduct;
    }

    @Override
    public String toString() {
        return "Supermarket{" + "money=" + money + ", countOfProduct=" + countOfProduct + '}';
    }
}
