package com.openclassrooms.cardgame.view;

import com.openclassrooms.cardgame.controller.GameController;

import java.util.ArrayList;
import java.util.List;

public class GameViewables implements GameViewable{

    List<GameViewable> views;

    public GameViewables(){
        views = new ArrayList<>();
    }
    public void addViewable(GameViewable view){
        views.add(view);
    }

    @Override
    public void setController(GameController gc) {
       for(GameViewable view : views){
           view.setController(gc);
       }
    }

    @Override
    public void promptForThePlayerName() {
        for(GameViewable view : views){
            view.promptForThePlayerName();
        }
    }

    @Override
    public void promptForFlip() {
        for(GameViewable view : views){
            view.promptForFlip();
        }
    }

    @Override
    public void promptForNewGame() {
        for(GameViewable view : views){
            view.promptForNewGame();
        }
    }

    @Override
    public void showWinner(String playerName) {
        for(GameViewable view : views){
            view.showWinner(playerName);
        }
    }

    @Override
    public void showPlayerName(int playerIndex, String playerName) {
        for(GameViewable view : views){
            view.showPlayerName(playerIndex,playerName);
        }
    }

    @Override
    public void showFaceDownCardForPlayer(int playerIndex, String playerName) {
        for(GameViewable view : views){
            view.showFaceDownCardForPlayer(playerIndex,playerName);
        }
    }

    @Override
    public void showCardForPlayer(int i, String playerName, String rank, String suit) {
        for(GameViewable view : views){
            view.showCardForPlayer(i,playerName,rank,suit);
        }
    }
}
