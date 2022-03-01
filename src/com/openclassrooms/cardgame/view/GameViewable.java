package com.openclassrooms.cardgame.view;

import com.openclassrooms.cardgame.controller.GameController;

public interface GameViewable {
    void setController(GameController gc);
    void promptForThePlayerName();
    void promptForFlip();
    void promptForNewGame();
    void showWinner(String playerName);
    void showPlayerName(int playerIndex, String playerName);
    void showFaceDownCardForPlayer(int playerIndex, String playerName);
    void showCardForPlayer(int i, String playerName, String rank, String suit);

}

