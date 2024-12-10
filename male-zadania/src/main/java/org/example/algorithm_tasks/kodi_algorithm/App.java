package org.example.algorithm_tasks.kodi_algorithm;

public class App {

    public static void main(String[] args) {
        QuickExchange quickExchange = new QuickExchange();

        int hashCodeExample = quickExchange.hashCode();
        System.out.println("Our example of using hasCode(): " + hashCodeExample);

        int a = 5;
        int b = 7;

        System.out.println("Our numbers before exchange: a -> " + a + ", b -> " + b);
        System.out.println("Start exchange ....");
        quickExchange.quickExchange(a, b);
    }
}