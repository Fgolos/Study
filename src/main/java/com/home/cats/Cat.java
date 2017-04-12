package com.home.cats;

import java.util.Random;

/**
 * Created by FDR on 19.03.2017.
 */
public class Cat {
    String name;
    int age;
    int streight;
    double weight;

    public Cat(String name, int age, int streight, double weight) {
        this.name = name;
        this.age = 1;
        this.streight = streight;
        this.weight = weight;
    }

    static Cat createCatWithRandomStats(String name) {
        int streight = (int) (1 + (Math.random() * 5));
        double weight = 1 + Math.random() * 2;
        Cat cat = new Cat(name, 1, streight, weight);
        return cat;
    }

//    public void feedCat(int meal) {
//        this.weight = weight + meal;
//    }

    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + ", age=" + age + ", streight=" + streight + ", weight=" + weight + '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStreight() {
        return streight;
    }

    public double getWeight() {
        return weight;
    }


}
