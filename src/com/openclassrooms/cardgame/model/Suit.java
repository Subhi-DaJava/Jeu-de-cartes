package com.openclassrooms.cardgame.model;

public enum Suit {

    NONE(0),DIAMONDS(1),HEARTS(2),SPADES(3),CLUBS(4); // mettre ";"
    int suit;
    //Constructor
    Suit(int value){
        suit = value;
    }
    public int value(){
        return suit;
    }
}
