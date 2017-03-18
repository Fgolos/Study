package com.home.taxi;

import java.util.ArrayList;

/**
 * Created by FDR on 17.03.2017.
 */
public class TaxiPool {
    ArrayList<TaxiAccount> allAccounts = new ArrayList<>();


    public TaxiPool(ArrayList<TaxiAccount> allAccounts) {
        this.allAccounts = allAccounts;
    }

    static TaxiPool createNewTaxiPool(int n) {
        ArrayList<TaxiAccount> taxiAccountArrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            TaxiAccount newTaxiAccauntWithRandomCoordinates = TaxiAccount.createNewTaxiAccauntWithRandomCoordinates(i);
            taxiAccountArrayList.add(newTaxiAccauntWithRandomCoordinates);
        }
        return new TaxiPool(taxiAccountArrayList);
    }

    public ArrayList<TaxiAccount> getAllTaxiAccount() {
        return allAccounts;
    }

    public double distance(Passanger name, TaxiAccount id) {
        int xPasanger = name.getGps().getX();
        int yPasanger = name.getGps().getY();
        int xTaxi = id.getGps().getX();
        int yTaxi = id.getGps().getY();
        double res = Math.sqrt(Math.pow((xTaxi - xPasanger), 2) + (Math.pow((yTaxi - yPasanger), 2)));
        return res;
    }

    public TaxiAccount minDistanse(Passanger passanger) {
        TaxiAccount closestTaxi = allAccounts.get(0);
        for (int i = 0; i < allAccounts.size(); i++) {
            TaxiAccount currentTaxi = allAccounts.get(i);
            double currentDistance = distance(passanger, currentTaxi);
            double closestDistance = distance(passanger, closestTaxi);
            if (currentDistance < closestDistance) {
                closestTaxi = currentTaxi;
            }
        }
        return closestTaxi;
    }
}
