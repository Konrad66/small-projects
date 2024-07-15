package org.example.advanced.blackjack;

public class Card {

  private  int color;
   private int rank;

    //todo jak wykorzystac ENUM w przypadku tej klasy

    public Card(int color, int rank) {
        this.color = color;
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder displayCard = new StringBuilder();

        switch (rank) {
            case 11:
                displayCard.append("jack");
                break;
            case 12:
                displayCard.append("queen");
                break;
            case 13:
                displayCard.append("king");
                break;
            case 14:
                displayCard.append("ace");
                break;
            case 15:
                displayCard.append("joker");
                break;
            default:
                displayCard.append(rank);
                break;
        }

        displayCard.append(" of ");

        switch (color) {
            case 0:
                displayCard.append("trefl");
                break;
            case 1:
                displayCard.append("karo");
                break;
            case 2:
                displayCard.append("kier");
                break;
            case 3:
                displayCard.append("pik");
                break;
        }
        return displayCard.toString();
    }
}