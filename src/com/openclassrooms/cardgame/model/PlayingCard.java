package com.openclassrooms.cardgame.model;

/**
 * une valeur, une couleur et un flag indiquant si la carte est face visible ou cachée.
 */
public class PlayingCard {
    private Rank rank;
    private Suit suit;
    private boolean faceUp;

    public boolean isFaceUp() {
        return faceUp;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public PlayingCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    //retourner les cartes
    public boolean flip(){
        faceUp = !faceUp;
        return faceUp;
    }
}
