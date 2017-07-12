package com.home.snake;

public class HunterStrategy {

    public  Point findNextVerticalHunterPoint(Point hunter, Point food) {
        Point newHunterPosition = new Point(0, 0);
        if (hunter.getY() >= food.getY()) {
            Point newHunterPosition2 = new Point(hunter.getX(), hunter.getY() - 1);
            newHunterPosition = newHunterPosition2;

        } else if (hunter.getY() <= food.getY()) {
            Point newHunterPosition2 = new Point(hunter.getX(), hunter.getY() + 1);
            newHunterPosition = newHunterPosition2;
        }
        return newHunterPosition;
    }public  Point findNextHorizontalHunterPoint(Point hunter, Point food){
        Point newHunterPosition = new Point(0, 0);
        if (hunter.getY() >= food.getY()) {
            Point newHunterPosition2 = new Point(hunter.getX() - 1, hunter.getY());
            newHunterPosition = newHunterPosition2;

        } else if (hunter.getY() <= food.getY()) {
            Point newHunterPosition2 = new Point(hunter.getX()+ 1, hunter.getY() );
            newHunterPosition = newHunterPosition2;
        }
        return newHunterPosition;
    }
}
