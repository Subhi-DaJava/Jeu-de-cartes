package com.openclassrooms.cardgame.model;

public class WinningPlayer implements IPlayer{
    IPlayer winner;
    public WinningPlayer(IPlayer winner){
        this.winner = winner;
    }
    @Override
    public void addCardToHand(PlayingCard pc) {
        winner.addCardToHand(pc);
    }

    @Override
    public PlayingCard getCard(int index) {
        return winner.getCard(index);
    }

    @Override
    public PlayingCard removeCard() {
        return winner.removeCard();
    }

    @Override
    public String getName() {
        return "**********"+winner.getName()+"**************";
    }
}
