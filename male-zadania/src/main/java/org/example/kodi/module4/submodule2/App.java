package org.example.kodi.module4.submodule2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {

    public static void main(String[] args) {

        Order orderStorage = new Order();

        orderStorage.addOrder(1);
        orderStorage.addOrder(2);
        orderStorage.addOrder(3);
        orderStorage.addOrder(4);

        boolean orderExist = orderStorage.orderExist(4);
        System.out.println("Przed dodaniem takiego samego zamowienia, kolekcja ma rozmiar " + orderStorage);
        orderStorage.addOrder(1);
        orderStorage.addOrder(5);
        orderStorage.removeOrder(3);

        orderStorage.printOrders();
    }


}

class Order {

    private Set<Integer> ordersList;

    public Order() {
        this.ordersList = new HashSet<>();
    }

    void addOrder(int orderNumber) {
        ordersList.add(orderNumber);
    }

    void removeOrder(int orderNumber) {
        ordersList.remove(orderNumber);
    }

    boolean orderExist(int orderNumber) {
        return ordersList.contains(orderNumber);
    }

    void printOrders(){
        for (Integer order : ordersList) {
            System.out.println(order);
        }
    }
}