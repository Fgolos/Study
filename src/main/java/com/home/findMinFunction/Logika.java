package com.home.findMinFunction;

/**
 * Created by FDR on 19.07.2017.
 */
public class Logika {
    public static void main(String[] args) {
        Logika logika = new Logika();
        LineSegment lineSegment = new LineSegment(-17.0, 5.0);
        double min = 0;
        double raznica = 0;
        for (int i = 0; i < 1000; i++) {
            LineSegment newLineSegment = logika.createNewLineSegment(logika.findFirstPoint(lineSegment), logika.findSecondPoint(lineSegment), lineSegment);
            lineSegment.a = newLineSegment.a;
            lineSegment.b = newLineSegment.b;
            min = (lineSegment.a + lineSegment.b) / 2;
            System.out.println(lineSegment);
            raznica = Math.abs(lineSegment.a - lineSegment.b);
            System.out.println(raznica);

        }
        System.out.println(min);

    }

    public Point findFirstPoint(LineSegment lineSegment) {
        Point point = new Point(0.0, 0.0);
        point.x = lineSegment.b - ((lineSegment.b - lineSegment.a) / 1.618);
        point.y = point.x * point.x;
        return point;
    }

    public Point findSecondPoint(LineSegment lineSegment) {
        Point point = new Point(0.0, 0.0);
        point.x = lineSegment.a + ((lineSegment.b - lineSegment.a) / 1.618);
        point.y = point.x * point.x;
        return point;
    }

    public LineSegment createNewLineSegment(Point x1y1, Point x2y2, LineSegment lineSegment) {
        LineSegment newlineSegment = new LineSegment(0.0, 0.0);
        if (x1y1.y >= x2y2.y) {
            newlineSegment.a = x1y1.x;
            newlineSegment.b = lineSegment.b;
        } else newlineSegment.a = lineSegment.a;
        newlineSegment.b = x2y2.x;
        return newlineSegment;
    }

    public double min(LineSegment lineSegment) {
        LineSegment lineSegment1 = new LineSegment(0.0, 0.0);
        double abs = Math.abs(lineSegment.b - lineSegment.a);
        double min = 0.0;
        while (abs < 0.00001) {
            LineSegment newLineSegment = createNewLineSegment(findFirstPoint(lineSegment), findSecondPoint(lineSegment), lineSegment1);
            lineSegment1.a = newLineSegment.a;
            lineSegment1.b = newLineSegment.b;
            min = (lineSegment1.a + lineSegment1.b) / 2;
        }
        return min;
    }
}

