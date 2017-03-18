package com.home.taxi;

import java.util.Random;

/**
 * Created by FDR on 17.03.2017.
 */
public class Gpscoord {
    int x;
    int y;

    public Gpscoord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Gpscoord createRandomLocation() {
        Random random = new Random();
        Gpscoord gpscoord = new Gpscoord(
                random.nextInt(10 - 1) + 1,
                random.nextInt(10 - 1) + 1);
        return gpscoord;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Gpscoord{" + "x=" + x + ", y=" + y + '}';
    }
}
