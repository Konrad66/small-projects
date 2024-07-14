package org.example.advanced.war_card_game;

public class Card {

    int color;
    int figures;

    public Card(int color, int figures) {
        this.color = color;
        this.figures = figures;
    }

    public int getFigures() {
        return figures;
    }

    public void setFigures(int figures) {
        this.figures = figures;
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

        switch (figures) {
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
                displayCard.append(false);
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