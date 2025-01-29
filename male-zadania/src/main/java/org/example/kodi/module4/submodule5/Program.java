package org.example.kodi.module4.submodule5;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        List<Clock> clockList = new LinkedList<>();
        Random random = new Random();
        Clock clock1 = new Clock();
        Clock clock2 = new Clock();
        Clock clock3 = new Clock();

        clockList.add(clock1);
        clockList.add(clock2);
        clockList.add(clock3);

        for (Clock clock : clockList) {
            int randomMinutes = random.nextInt(500);
            clock.changeTime(randomMinutes);
            System.out.println(clock);
        }


//        Napisz program, który wypisze wszystkie liczby podzielne przez 4 bez reszty z zakresu od 0 do 100 (obustronnie włącznie). Tym razem będzie jednak nieco trudniej, gdyż w tym podejściu nie możesz użyć instrukcji warunkowej. Jeśli w poprzednim zadaniu dodatkowym już dokonałeś takiej ambitnej implementacji, to masz wolne!

        for (int i = 0; i <= 100; i += 4) {
            System.out.println(i);
        }


    }
}

class Clock {
    private int minute;
    private int hour;

    void changeTime(int minutes) {
        this.minute += minutes;
        while (this.minute >= 60) {
            this.minute -= 60;
            hour++;
            if (hour >= 24) {
                hour = 0;
            }
        }
    }

    @Override
    public String toString() {
        return hour + "hour:" + minute + "minutes";
    }
}