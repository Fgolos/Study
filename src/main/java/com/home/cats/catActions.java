package com.home.cats;

/**
 * Created by FDR on 19.03.2017.
 */
public class CatActions {
    Cat cat;

//   public CatActions(Cat cat) {
//        this.cat = cat;
//    }

    public void feedCat(Cat cat, double meal) {
        cat.weight = cat.weight + meal;
    }

    public Cat fight(Cat cat1, Cat cat2) {
        if (cat1.streight > cat2.streight)
            return cat1;
        else return cat2;
    }

    public Cat sex(Cat cat1, Cat cat2) {
        Cat newCat = Cat.createCatWithRandomStats("newCat");
        return newCat;
    }
}
