package org.example.algorithm_tasks.kodi_algorithm;

public class QuickExchange {

    void quickExchange(int a, int b) {
        if (a > 0 && b > 0) {
            int newA = b;
            int newB = a;
            a = newA;
            b = newB;
        }
        System.out.println("Our new a is: " + a + ", and our new B is: " + b);
    }
}