package com.home.findMinFunction;

public class LineSegment {

    public Double a;
    public Double b;

    public LineSegment(final Double a, final Double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "LineSegment{" + "a=" + a + ", b=" + b + '}';
    }
}
