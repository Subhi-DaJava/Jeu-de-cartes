package com.openclassrooms.cardgame.model;

public class DeckFactory {
    public enum DeckType{
        Normal,
        Small,
        Test
    }
    public static Deck makeDeck(DeckType type){
        switch (type){
            case Test:   return new TestDeck();
            case Small:  return new SmallDeck();
            case Normal: return new NormalDeck();
        }
        return new NormalDeck();
    }
}
