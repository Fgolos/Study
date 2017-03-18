package com.home.taxi;

import java.util.ArrayList;

/**
 * Created by FDR on 17.03.2017.
 */
public class TaxiAccount {
    int id;
    int balance;
    Gpscoord gps;
    ArrayList<Passanger> history;

    public TaxiAccount(int id, Gpscoord gps, ArrayList<Passanger> history) {
        this.id = id;
        this.balance = 0;
        this.gps = gps;
        this.history = history;

    }

    public static TaxiAccount createNewTaxiAccauntWithRandomCoordinates(int id) {
        ArrayList<Passanger> passangers = new ArrayList<>();
        Gpscoord randomLocation = Gpscoord.createRandomLocation();
        TaxiAccount taxiAccount = new TaxiAccount(id, randomLocation, passangers);
        return taxiAccount;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public Gpscoord getGps() {
        return gps;
    }

    public ArrayList<Passanger> getHistory() {
        return history;
    }

    public void servePassanger(Passanger name, int coast) {
        this.balance = balance + coast;
        this.gps = name.gps;
        this.history.add(name);

    }

    @Override
    public String toString() {
        return "TaxiAccount{" + "id=" + id + ", balance=" + balance + ", gps=" + gps + ", history=" + history + '}';
    }
}
