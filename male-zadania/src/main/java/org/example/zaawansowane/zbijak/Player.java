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
        boolean correctMove;
        do {
            correctMove = true;
            Scanner reader = new Scanner(System.in);
            System.out.println("Chose your move: W, A, S, D");
            switch (reader.next()) {
                case "W":
                    if (y > 0) {
                        System.out.println("Go up");
                        y--;
                    } else {
                        System.out.println("Choose other direction");
                        correctMove = false;
                    }
                    break;
                case "S":
                    if (y < Board.HEIGHT - 1) {
                        System.out.println("Go down");
                        y++;
                    } else {
                        System.out.println("Choose other direction");
                        correctMove = false;
                    }
                    break;
                case "A":
                    if (x > 0) {
                        System.out.println("Go to the left");
                        x--;
                    } else {
                        System.out.println("Choose other direction");
                        correctMove = false;
                    }
                    break;
                case "D":
                    if (x > Board.WIDTH - 1) {
                        System.out.println("Go to the right");
                        x++;
                    } else {
                        System.out.println("Choose other direction");
                        correctMove = false;
                    }
                    break;
                default:
                    System.out.println("Insert one of those move: W, A, S, D");
            }
        } while (!correctMove);
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
