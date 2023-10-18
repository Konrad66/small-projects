package org.example.advanced.dodgeball;

import java.util.ArrayList;
import java.util.List;

public class Board {

    final private List<Player> players = new ArrayList<>();
    final static int WIDTH = 10;
    final static int HEIGHT = 10;

    public void start() {
        createPlayers();
        System.out.println(composeBoardView());
        for (Player player : players) {
            System.out.println("It's turn of player: " + player.getName());
            player.move();
            beat(player);
            System.out.println(composeBoardView());
        }
    }

    public void beat(Player player) {
        //TODO //zaimplementować zbijanie
        for (Player other : players) {
            if (player.getX() == other.getX() && player.getY() == other.getY()) {
                System.out.println("zbicie");
            }
        }
    }

    public String composeBoardView() {
        String board = "";
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                boolean isPlayer = false;
                for (Player player : players) {
                    if (player.getY() == y && player.getX() == x) {
                        board = board + player.getName();
                        isPlayer = true;
                    }
                }
                if (!isPlayer) {
                    board += " * ";
                }
            }
            board = board + "\n";
        }
        return board;
    }

    public void createPlayers() {
        HumanPlayer player1 = new HumanPlayer(" K ", 0, 0);
        players.add(player1);

        Player player2 = new ComputerPlayer(" W ", 0, 9);
        players.add(player2);

        Player player3 = new ComputerPlayer(" D ", 9, 9);
        players.add(player3);

        Player player4 = new ComputerPlayer(" P ", 2, 0);
        players.add(player4);
    }


    public int numberOfPlayers() {
        return players.size();
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.start();
    }
}

//TODO
//dzidziczenie i abstract poczytać + dodatkowo zadanie z dziedziczenia


/*
*   if (player instanceof HumanPlayer) {
                System.out.println("instanceof");
            }
            if (player.getClass() == HumanPlayer.class) {
                System.out.println("same class");
            }
*
*
* */