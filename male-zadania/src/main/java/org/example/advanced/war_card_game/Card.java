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
        return "Card{" +
                "color=" + color +
                ", figures=" + figures +
                '}';
    }
}
