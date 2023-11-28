package org.example.basics.exe23;

public class Exercise1 {

    public static void main(String[] args) {

        for(int i = 0; i <= 5000; i++){
            System.out.print(i + " ");
        }

        String[] names = {"Konrad", "Wiktoria", "Przemek", "Beata", "Mateusz"};

        System.out.println();
        for (String name : names){
            System.out.println(name);
        }

        for (int i = 0; i <= 20; i++){
            System.out.print(Math.pow(2, i) + " ");
        }
    }
}
