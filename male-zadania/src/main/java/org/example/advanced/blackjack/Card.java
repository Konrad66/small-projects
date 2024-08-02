package org.example.advanced.blackjack;

public class Card {

    private Color color;
    private Rank rank;
    private boolean hidden = true;

    public Card(Color color, Rank rank) {
        this.color = color;
        this.rank = rank;
    }

    public Color getColor() {
        return color;
    }

    public Rank getRank() {
        return rank;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public String toString() {
        return rank + " of " + color;
    }
}