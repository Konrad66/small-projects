package org.example.zaawansowane.zbijak;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {

    private List<Player> players = new ArrayList<>();

    public void printBoard() {

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                boolean isPlayer = false;
                for (Player player : players) {
                    if (player.getY() == y && player.getX() == x) {
                        System.out.print(player.getName());
                        isPlayer = true;
                    }
                }
                if (!isPlayer) {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
    }

    public void createPlayer() {
        Player player1 = new Player(" K ", 0, 0);
        players.add(player1);

        Player player2 = new Player(" W ", 0, 9);
        players.add(player2);

        Player player3 = new Player(" D ", 9, 9);
        players.add(player3);

        Player player4 = new Player(" P ", 9, 0);
        players.add(player4);
    }

    public void readMove() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Chose your move: W, A, S, D");
        switch (reader.next()) {
            case "W":
                System.out.println("Go up");
                break;
            case "S":
                System.out.println("Go down");
                break;
            case "A":
                System.out.println("Go to the left");
                break;
            case "D":
                System.out.println("Go to the right");
                break;
            default:
                System.out.println("Insert one of those move: W, A, S, D");
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.createPlayer();
        board.printBoard();
        board.readMove();
    }
}