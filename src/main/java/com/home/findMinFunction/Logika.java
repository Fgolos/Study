package com.home.findMinFunction;

import sun.awt.SunHints;

/**
 * Created by FDR on 19.07.2017.
 */
public class Logika {
    public static void main(String[] args) {
        Logika logika = new Logika();
        LineSegment lineSegment = new LineSegment(-5.0, 9.0);
        System.out.println(logika.findMin(lineSegment, 0.1));
        System.out.println(logika.gradient(0.01));
        System.out.println(logika.proizvodnaya(-0.00049, 0.00001));
    }

    public double function(double x) {
        double y = (x + 2) * (x + 2);
        return y;
    }

    public Point findFirstPoint(LineSegment lineSegment) {
        Point point = new Point(0.0, 0.0);
        point.x = lineSegment.b - ((lineSegment.b - lineSegment.a) / 1.618);
        point.y = function(point.x);
        return point;
    }

    public Point findSecondPoint(LineSegment lineSegment) {
        Point point = new Point(0.0, 0.0);
        point.x = lineSegment.a + ((lineSegment.b - lineSegment.a) / 1.618);
        point.y = function(point.x);
        return point;
    }

    public LineSegment createNewLineSegment(Point x1y1, Point x2y2, LineSegment lineSegment) {
        LineSegment newlineSegment = new LineSegment(0.0, 0.0);
        if (x1y1.y >= x2y2.y) {
            newlineSegment.a = x1y1.x;
            newlineSegment.b = lineSegment.b;
        } else {
            newlineSegment.a = lineSegment.a;
            newlineSegment.b = x2y2.x;
        }
        return newlineSegment;
    }

    public double proizvodnaya(double x0, double step) {
        double x0PlusDeltaX = function(x0 + step);
        double y0 = function(x0);
        double proizvodnaya = (x0PlusDeltaX - y0) / step;
        return proizvodnaya;
    }

    public Result gradient(double eps) {
        Logika logika = new Logika();
        double x = -5;
        double y = 99999;
        Integer counter = 0;
        while (logika.function(x) > eps) {
            double x1 = x - 0.7 * (logika.proizvodnaya(x, 0.00001));
            x = x1;
            double y1 = logika.function(x1);
            y = y1;
            counter = counter + 1;
        }
        return new Result(counter, x, y);
    }

    public Result findMin(LineSegment lineSegment, double eps) {
        Logika logika = new Logika();
        Result result = new Result(0, 0.0, 0.0);
        LineSegment lineSegment1 = new LineSegment(lineSegment.a, lineSegment.b);
        while (Math.abs(lineSegment1.b - lineSegment1.a) > eps) {
            LineSegment newLineSegment = logika.createNewLineSegment(findFirstPoint(lineSegment1), findSecondPoint(lineSegment1), lineSegment1);
            lineSegment1.a = newLineSegment.a;
            lineSegment1.b = newLineSegment.b;

            result.counter = result.counter + 1;
            // result.min = (newLineSegment.a + newLineSegment.b) / 2;
            result.x = logika.findFirstPoint(lineSegment1).x;
            result.y = logika.findSecondPoint(lineSegment1).y;
        }
        return result;

    }
}

