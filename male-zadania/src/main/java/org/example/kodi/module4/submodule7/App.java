package org.example.kodi.module4.submodule7;

public class App {
    public static void main(String[] args) {
        Euclides euclides = new Euclides();
        int a = 500;
        int b = 2455;

        int result = euclides.NWD(a, b);
        int result2 = euclides.NWD2(a, b);
        System.out.println(result);
        System.out.println(result2);
    }
}

class Euclides {

    int NWD(int a, int b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    int NWD2(int a, int b) {
        while (b != 0) {
            int nwd = a % b;
            a = b;
            b = nwd;
        }
        return a;
    }
}