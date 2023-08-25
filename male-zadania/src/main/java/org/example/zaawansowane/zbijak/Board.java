package org.example.zaawansowane.zbijak;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Player> players = new ArrayList<>();

    public void printBoard() {

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (players.get(0).getY() == y && players.get(0).getX() == x) {
                    System.out.print(players.get(0).getName());
                } else {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
    }


    public void createPlayer() {
        Player player1 = new Player(" K ", 1, 1);
        players.add(player1);
    }


    public static void main(String[] args) {
        Board board = new Board();
        board.createPlayer();
        board.printBoard();
    }


}
