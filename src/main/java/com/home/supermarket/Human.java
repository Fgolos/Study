package com.home.supermarket;

/**
 * Created by FDR on 20.03.2017.
 */
public class Human {
    String name;
    int money;
    int countOfProduct;

    public Human(String name, int money, int countOfProduct) {
        this.name = name;
        this.money = money;
        this.countOfProduct = countOfProduct;
    }

    public void buy(Supermarket supermarket, int quantity, int money) {
        this.countOfProduct = this.countOfProduct + quantity;
        supermarket.countOfProduct = supermarket.countOfProduct - quantity;
        this.money = this.money - money;
        supermarket.money = supermarket.money + money;

    }

    @Override
    public String toString() {
        return "Human{" + "name='" + name + '\'' + ", money=" + money + ", countOfProduct=" + countOfProduct + '}';
    }
}
