package com.home.snake;

import java.util.ArrayList;

/**
 * Created by FDR on 09.07.2017.
 */
public class SnakeGame {

    public static void main(String[] args) {
        ArrayList<ArrayList> coordY = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ArrayList<Character> coord = new ArrayList<>();
            coordY.add(coord);
        }
        for (int i = 0; i < coordY.size(); i++) {

            for (int j = 0; j < coordY.size(); j++) {
                coordY.get(i).add(" ");
            }
        }
        randomCoordFood(coordY);
        randomCoordHunter(coordY);

        for (int i = 0; i < 10; i++) {
            System.out.println(coordY.get(i));
        }
        System.out.println(findCoord(coordY, "F") + "Food coord");
        System.out.println(findCoord(coordY, "H") + "Hunter coord");
    }

    public static void randomCoordFood(ArrayList<ArrayList> coord) {
        int a = 0;
        int b = 10;
        int coordYpoint = a + (int) (Math.random() * b);
        int coordXpoint = a + (int) (Math.random() * b);

        coord.get(coordYpoint).set(coordXpoint, "F");


    }

    public static void randomCoordHunter(ArrayList<ArrayList> coord) {
        int a = 0;
        int b = 10;
        int coordYpoint = a + (int) (Math.random() * b);
        int coordXpoint = a + (int) (Math.random() * b);

        coord.get(coordYpoint).set(coordXpoint, "H");


    }

    public static ArrayList findCoord(ArrayList<ArrayList> coord, String obgect) {
        Integer y = 0;
        Integer x = 0;
        ArrayList coordX = new ArrayList();
        for (int i = 0; i < coord.size(); i++) {
            
            boolean f = coord.get(i).contains(obgect);
            if (f == true) {
                y = i;
                coordX = coord.get(i);
            }
            for (int j = 0; j < coordX.size(); j++) {
                boolean f1 = coordX.get(j).equals(obgect);
                if (f1 == true) {
                    x = j;
                }
            }
        }
        ArrayList<Integer> point = new ArrayList<>();
        point.add(y);
        point.add(x);
        return point;
    }

}






