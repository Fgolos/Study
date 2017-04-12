package com.home.supermarket;

/**
 * Created by FDR on 20.03.2017.
 */
public class Product {
    int id;
    int coast;
    String nameOfProduct;

    public Product(int id, int coast, String nameOfProduct) {
        this.id = id;
        this.coast = coast;
        this.nameOfProduct = nameOfProduct;
    }

    public void newProductWithRandomCoast() {
        new Product(1, (int) (1 + (Math.random() * 2)), "banana");
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", coast=" + coast + ", nameOfProduct='" + nameOfProduct + '\'' + '}';
    }
}
