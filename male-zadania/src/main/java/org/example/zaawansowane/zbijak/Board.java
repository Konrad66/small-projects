package org.example.zaawansowane.zbijak;

public class Board {

    public void createBoard() {
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Board board = new Board();
        board.createBoard();
    }

}
