package org.example.zaawansowane.zbijak;

import java.util.Scanner;

public class Player {

    private String name;
    private int x;
    private int y;


    public Player(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public void readMove() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Chose your move: W, A, S, D");
        switch (reader.next()) {
            case "W":
                System.out.println("Go up");
                y++;
                break;
            case "S":
                System.out.println("Go down");
                y--;
                break;
            case "A":
                System.out.println("Go to the left");
                x--;
                break;
            case "D":
                System.out.println("Go to the right");
                x++;
                break;
            default:
                System.out.println("Insert one of those move: W, A, S, D");
        }
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
