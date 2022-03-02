package com.openclassrooms.cardgame.controller;

import com.openclassrooms.cardgame.games.LowCardGameEvaluator;
import com.openclassrooms.cardgame.model.*;
import com.openclassrooms.cardgame.view.GameViewable;

import java.util.ArrayList;
import java.util.List;

/**
 * •	Créer le jeu.
 * •	Entrer les noms des joueurs.
 * •	Mélanger les cartes.
 * •	Distribuer une carte à chaque joueur.
 * •	Retourner les cartes.
 * •	Déterminer le gagnant.
 * •	Afficher le gagnant.
 * •	Recommencer le jeu.
 *
 */

public class GameController {
    // état de jeu
    enum GameState{
        AddingPlayers, CardsDealt, WinnerRevealed
    }
    Deck deck;
    List<IPlayer> players;
    GameViewable view; //la vue
    IPlayer winner;
    GameState gameState;
    LowCardGameEvaluator gameEvaluator;

    //Le contrôleur instancie les objets essentiels au démarrage du jeu. Il s'agit du jeu de cartes et d'une liste vide de joueurs.
    // Il doit également avoir connaissance de la vue.
    public GameController(Deck deck, GameViewable view, LowCardGameEvaluator gameEvaluator) {
        this.deck = deck;
        this.view = view;
        this.players = new ArrayList<>();
        this.gameState = GameState.AddingPlayers;
        view.setController(this); //La vue doit être créée ailleurs et transmise au contrôleur au lieu d'être créée par le contrôleur lui-même.
        this.gameEvaluator = gameEvaluator;
    }
    public void run(){
        while (gameState == GameState.AddingPlayers){
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
    //Après chaque saisie d'un nom par l'utilisateur, le contrôleur ajoute le nom à la liste des joueurs.
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
            for (IPlayer player : players){
                ////Le contrôleur mélange les cartes et prend la première carte pour la donner à un joueur.
                player.addCardToHand(deck.removeTopCard());
                //Il demande ensuite à la vue de présenter l'état du jeu.
                view.showFaceDownCardForPlayer(playerIndex++,player.getName());
            }
            gameState = GameState.CardsDealt;
        }

        this.run();
    }
    public void flipCards(){
        int playerIndex = 1;
        for (IPlayer player : players){
            PlayingCard pc = player.getCard(0); //chaque joueur détient une seule carte
            //Le contrôleur retourne la carte de chaque joueur, puis calcule le gagnant.
            pc.flip();
            //Il demande à la vue de présenter l'état du jeu, qui comprend à présent le nom du gagnant !
            view.showCardForPlayer(playerIndex++,player.getName(),pc.getRank().toString(),pc.getSuit().toString());
        }
        evaluateWinner();
        displayWinner();
        rebuildDeck();
        gameState = GameState.WinnerRevealed;
        //Rejouer
        this.run();
    }
    public void evaluateWinner(){
     winner = new WinningPlayer(gameEvaluator.evaluateWinner(players));
    }
    public void displayWinner(){
        view.showWinner(winner.getName());
    }
    ////Les mains des joueurs sont ramassées et replacées dans le paquet de cartes.
    public void rebuildDeck(){
        for (IPlayer player : players){
            deck.returnCardToDeck(player.removeCard());
        }
    }
    public void exitGame(){
        System.exit(0);
    }
    public void nextAction(String nextChoice) {
        if("+q".equals(nextChoice)){
            exitGame();
        }else {
            startGame();
        }
    }

}
