package com.home.snake;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Field {
    int maxX;
    int maxY;



    Point food;
    Point hunter;


    public Field(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.food = putElementWithRandomCoordinat();
        this.hunter = putElementWithRandomCoordinat();
    }

    public Point putElementWithRandomCoordinat() {
        int x = maxX;
        int y = maxY;
        int coordYpoint = ThreadLocalRandom.current().nextInt(0, y);
        int coordXpoint = ThreadLocalRandom.current().nextInt(0, x);

        Point point = new Point(coordXpoint, coordYpoint);
        return point;
    }

    public void print() {
        ArrayList<ArrayList> coordY = new ArrayList<>();

        for (int i = 0; i < maxY; i++) {
            ArrayList<Character> coord = new ArrayList<>();
            coordY.add(coord);
        }
        for (int x = 0; x < maxX; x++) {
            for (int i = 0; i < coordY.size(); i++) {
                coordY.get(i).add(" ");
            }
        }

        coordY.get(food.getY()).set(food.getX(), "F");

        for (int i = 0; i < coordY.size(); i++) {
            System.out.println(coordY.get(i));
        }
    }
}
