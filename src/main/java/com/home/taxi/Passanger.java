package com.home.taxi;

import org.omg.CORBA.Object;

import java.util.ArrayList;

/**
 * Created by FDR on 17.03.2017.
 */
public class Passanger {
    String name;
    Gpscoord gps;

    public Passanger(String name, Gpscoord gps) {
        this.name = name;
        this.gps = gps;
    }

    static Passanger createNewPassangerWithRandomGpsLocation(String name) {
        Gpscoord randomLocation = Gpscoord.createRandomLocation();
        Passanger passanger = new Passanger(name, randomLocation);
        return passanger;
    }

    public String getName() {
        return name;
    }

    public Gpscoord getGps() {
        return gps;
    }

    @Override
    public String toString() {
        return "Passanger{" + "name='" + name + '\'' + ", gps=" + gps + '}';
    }


}
