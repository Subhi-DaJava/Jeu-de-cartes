package com.openclassrooms.cardgame;

import com.openclassrooms.cardgame.controller.GameController;
import com.openclassrooms.cardgame.games.LowCardGameEvaluator;
import com.openclassrooms.cardgame.model.Deck;
import com.openclassrooms.cardgame.view.CommandLineView;

public class Games {
    public static void main(String[] args) {

        //GameController gameController = new GameController(new Deck(),new View(), new HighCardGameEvaluator());
        GameController gameController = new GameController(new Deck(),new CommandLineView(), new LowCardGameEvaluator());
        gameController.run();
    }

}
