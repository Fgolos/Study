package com.home.taxi;

/**
 * Created by FDR on 17.03.2017.
 */
public class Runner {
    public static void main(String[] args) {
        TaxiPool newTaxiPool = TaxiPool.createNewTaxiPool(10);
        Passanger hataButa = Passanger.createNewPassangerWithRandomGpsLocation("hataButa");
        for (int i = 0; i < newTaxiPool.allAccounts.size(); i++) {
            TaxiAccount taxiAccount = newTaxiPool.allAccounts.get(i);
            double distance = newTaxiPool.distance(hataButa, taxiAccount);
            System.out.println(taxiAccount + "  " + distance);


        }
        System.out.println("====================================================");

        System.out.println(newTaxiPool.minDistanse(hataButa));


    }
}
