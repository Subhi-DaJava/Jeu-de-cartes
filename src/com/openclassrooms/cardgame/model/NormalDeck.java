package com.openclassrooms.cardgame.model;

import java.util.ArrayList;
import java.util.List;

public class NormalDeck extends Deck{
    public NormalDeck(){
        //enum methode values() transfer all elements in an ArrayList
        cards = new ArrayList<>();
        for(Rank rank : Rank.values()){
            for (Suit suit : Suit.values()){
                System.out.println("Creating card ["+rank+"]["+suit+"]");
                cards.add(new PlayingCard(rank,suit));
            }
        }
        System.out.println("le nombre de carte = "+cards.size());
        shuffle();
    }

}
