package com.home.snake;

import java.util.ArrayList;

/**
 * Created by FDR on 09.07.2017.
 */
public class SnakeGame {

    public static void main(String[] args) {
        Field field = new Field(3, 5);
        HunterStrategy hunterStrategy = new HunterStrategy();
        field.print();


        System.out.println(field.food);


    }
}






