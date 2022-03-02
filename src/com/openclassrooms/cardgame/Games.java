package com.openclassrooms.cardgame;

import com.openclassrooms.cardgame.controller.GameController;
import com.openclassrooms.cardgame.games.LowCardGameEvaluator;
import com.openclassrooms.cardgame.model.Deck;
import com.openclassrooms.cardgame.view.CommandLineView;
import com.openclassrooms.cardgame.view.GameSwingView;

public class Games {
    public static void main(String[] args) {
        GameSwingView gsv = new GameSwingView();
        gsv.createAndShowGUI();
        //GameController gameController = new GameController(new Deck(),new View(), new HighCardGameEvaluator());
        GameController gameController = new GameController(new Deck(), gsv, new LowCardGameEvaluator());
        gameController.run();
    }

}
