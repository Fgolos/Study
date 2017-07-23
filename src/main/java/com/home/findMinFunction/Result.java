package com.home.findMinFunction;

/**
 * Created by FDR on 23.07.2017.
 */
public class Result {
    Integer counter;
    double min;
    double x;
    double y;
    public Result(Integer counter, double min, double x, double y) {
        this.counter = counter;
        this.min = min;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Result{" + "counter=" + counter + ", min=" + min + ", x=" + x + ", y=" + y + '}';
    }
}
