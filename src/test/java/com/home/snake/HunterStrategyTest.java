package com.home.snake;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by FDR on 10.07.2017.
 */
public class HunterStrategyTest {
    @Test
    public void hunterGoUpFirst() throws Exception {
        Point hunter = new Point(3, 4);
        Point food = new Point(1, 2);
        Point newHunterPosition = HunterStrategy.findNextHunterPoint(hunter, food);
        assertEquals(newHunterPosition.getX(), hunter.getX());
        assertEquals(newHunterPosition.getY(), 2);
    }

    @Test
    public void hunterGoDown() throws Exception {
        Point food = new Point(3, 4);
        Point hunter = new Point(1, 2);
        Point newHunterPosition = HunterStrategy.findNextHunterPoint(hunter, food);
        assertEquals(newHunterPosition.getX(), hunter.getX());
        assertEquals(newHunterPosition.getY(), 2);
    }

    @Test
    public void hunterMoveXOnlyIfYSame() throws Exception {
        Point hunter = new Point(0, 0);
        Point food = new Point(2, 0);
        Point newHunterPosition = HunterStrategy.findNextHunterPoint(hunter, food);
        assertEquals(newHunterPosition.getX(), 1);
        assertEquals(newHunterPosition.getY(), hunter.getY());
    }

    @Test
    public void hunterCanGoLeftIfYSame() throws Exception {
        Point food = new Point(0, 0);
        Point hunter = new Point(2, 0);
        Point newHunterPosition = HunterStrategy.findNextHunterPoint(hunter, food);
        assertEquals(newHunterPosition.getX(), 1);
        assertEquals(newHunterPosition.getY(), hunter.getY());
    }
}