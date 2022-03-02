package com.openclassrooms.cardgame.model;

import java.util.ArrayList;

public class TestDeck extends Deck{
    public TestDeck(){
        cards = new ArrayList<>();
        for (int i=0; i < 20; i++){
            cards.add(new PlayingCard(Rank.AS, Suit.CLUBS));
            System.out.println("["+cards.get(0).getRank().toString()+"]"+"["+cards.get(0).getSuit().toString()+"]");
        }
        System.out.println("le nombre de cartes est = 20");
    }
}
