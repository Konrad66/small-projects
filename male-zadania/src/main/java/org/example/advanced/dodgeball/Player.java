package org.example.advanced.dodgeball;

import java.util.Random;
import java.util.Scanner;

public abstract class Player {

    private String name;

    private int x;
    private int y;


    public Player(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public void move(){

    }




    public boolean executeMove(String input) {
        switch (input) {
            case "W":
                if (y > 0) {
                    y--;
                    return true;
                }
                break;
            case "S":
                if (y < Board.HEIGHT - 1) {
                    y++;
                    return true;
                }
                break;
            case "A":
                if (x > 0) {
                    x--;
                    return true;
                }
                break;
            case "D":
                if (x < Board.WIDTH - 1) {
                    x++;
                    return true;
                }
                break;
            default:
                System.out.println("Insert one of those move: W, A, S, D");
        }
        return false;
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