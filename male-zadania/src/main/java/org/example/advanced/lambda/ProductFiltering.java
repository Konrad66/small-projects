package org.example.advanced.lambda;

import java.util.ArrayList;
import java.util.List;

public class ProductFiltering {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();




    }
}


class Product {

    String name;
    int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
