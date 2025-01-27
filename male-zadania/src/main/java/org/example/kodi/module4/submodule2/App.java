package org.example.kodi.module4.submodule2;

import java.util.*;

public class App {

    public static void main(String[] args) {

        Order orderStorage = new Order();

        orderStorage.addOrder(1);
        orderStorage.addOrder(2);
        orderStorage.addOrder(3);
        orderStorage.addOrder(4);

        System.out.println("Przed dodaniem takiego samego zamowienia, kolekcja ma rozmiar " + orderStorage.getSize());

        printOperationResult(orderStorage.orderExist(4), 4);
        printOperationResult(orderStorage.addOrder(5), 5);
        printOperationResult(orderStorage.addOrder(1), 1);
        orderStorage.removeOrder(3);
        orderStorage.printOrders();
        System.out.println("Kolekcja ma rozmiar " + orderStorage.getSize());
    }

    private static void printOperationResult(boolean result, int orderNumber) {
        if (result) {
            System.out.println("Wykonano operacje pomyślnie dla zamówienia " + orderNumber);
        } else {
            System.out.println("Nie można wykonac operacji dla zamówienia " + orderNumber);
        }
    }
}

class Order {

    private Set<Integer> ordersSet;

    public Order() {
        this.ordersSet = new HashSet<>();
    }

    boolean addOrder(int orderNumber) {
        return ordersSet.add(orderNumber);
    }

    boolean removeOrder(int orderNumber) {
        return ordersSet.remove(orderNumber);
    }

    boolean orderExist(int orderNumber) {
        return ordersSet.contains(orderNumber);
    }

    void printOrders() {
        for (Integer order : ordersSet) {
            System.out.print(order);
        }
    }

    int getSize() {
        return ordersSet.size();
    }

    @Override
    public String toString() {
        return "Order{" +
                "ordersList=" + ordersSet +
                '}';
    }
}