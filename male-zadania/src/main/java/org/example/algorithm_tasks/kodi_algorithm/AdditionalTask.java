package org.example.algorithm_tasks.kodi_algorithm;

public class AdditionalTask {

    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        System.out.println("nasze a: " + a + " nasze b: " + b);
        int sum = a + b;
        a = sum - a;
        b = sum - b;
        System.out.println("nasze nowe a: " + a + " nasze nowe b: " + b);
    }
}
