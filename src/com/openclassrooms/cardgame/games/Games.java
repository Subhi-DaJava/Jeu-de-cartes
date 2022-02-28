package com.openclassrooms.cardgame.games;

import com.openclassrooms.cardgame.controller.GameController;
import com.openclassrooms.cardgame.model.Deck;
import com.openclassrooms.cardgame.view.View;

public class Games {
    public static void main(String[] args) {

        GameController gameController = new GameController(new Deck(),new View());
        gameController.run();
    }

}
