package com.openclassrooms.cardgame.controller;

import com.openclassrooms.cardgame.model.Deck;
import com.openclassrooms.cardgame.model.Player;
import com.openclassrooms.cardgame.model.PlayingCard;
import com.openclassrooms.cardgame.view.View;

import java.util.ArrayList;
import java.util.List;


public class GameController {
    // état de jeu
    enum GameState{
        AddingPlayers, CardsDealt, WinnerRevealed
    }
    Deck deck;
    List<Player> players;
    View view;
    Player winner;

    GameState gameState;

    public GameController(Deck deck, View view) {
        this.deck = deck;
        this.view = view;
        this.players = new ArrayList<>();
        this.gameState = GameState.AddingPlayers;
        view.setController(this);
    }
    public void run(){
        while (gameState ==  GameState.AddingPlayers){
            view.promptForThePlayerName();
        }
        switch (gameState){
            case CardsDealt:
                view.promptForFlip();
            case WinnerRevealed:
                view.promptForNewGame();
                break;
        }
    }
    public void addPlayer(String playerName){
        if (gameState == GameState.AddingPlayers){
            players.add(new Player(playerName));
            view.showPlayerName(players.size(),playerName);
        }
    }
    public void startGame(){
        if (gameState != GameState.CardsDealt){
            deck.shuffle();
            int playerIndex = 1;
            for (Player player : players){
                player.addCardToHand(deck.removeTopCard());
                view.showFaceDownCardForPlayer(playerIndex++,player.getName());
            }
            gameState = GameState.CardsDealt;
        }
        this.run();
    }
    public void flipCards(){
        int playerIndex = 1;
        for (Player player : players){
            PlayingCard pc = player.getCard(0);
            pc.flip();
            view.showFaceDownCardForPlayer(playerIndex++,player.getName(),pc.getRank().toString(),pc.getSuit().toString());
        }
        evaluateWinner();
        displayWinner();
        rebuildDeck();
        gameState = GameState.WinnerRevealed;
        this.run();
    }
    public void evaluateWinner(){
        Player bestPlayer = null;
        int bestRank = -1;
        int bestSuit = -1;
        for (Player player : players){
            boolean newBestPlayer = false;
            if(bestPlayer == null){
                newBestPlayer = true;
            }else {
                PlayingCard pc = player.getCard(0);
                int thisRank = pc.getRank().value();
                int thisSuit = pc.getSuit().value();
                if (thisRank >= bestRank){
                    if(thisRank > bestRank){
                        newBestPlayer = true;
                    }else {
                        if(pc.getSuit().value() >bestSuit ){
                            newBestPlayer = true;
                        }
                    }
                }
            }
            if(newBestPlayer){
                bestPlayer = player;
                PlayingCard pc = player.getCard(0);
                bestRank = pc.getRank().value();
                bestSuit = pc.getSuit().value();
            }
        }
        winner = bestPlayer;
    }
    public void displayWinner(){
        view.showWinner(winner.getName());
    }
    public void rebuildDeck(){
        for (Player player : players){
            deck.returnCardToDeck(player.removeCard());
        }
    }
}
