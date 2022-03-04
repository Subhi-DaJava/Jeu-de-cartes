package com.openclassrooms.cardgame;

import com.openclassrooms.cardgame.controller.GameController;
import com.openclassrooms.cardgame.games.LowCardGameEvaluator;
import com.openclassrooms.cardgame.model.DeckFactory;
import com.openclassrooms.cardgame.view.CommandLineView;
import com.openclassrooms.cardgame.view.GameSwingPassiveView;
import com.openclassrooms.cardgame.view.GameSwingView;
import com.openclassrooms.cardgame.view.GameViewables;

public class Games {
    public static void main(String[] args) {
        //instancie GameViewable, gérer une liste de views(vues)
        GameViewables views = new GameViewables();
        //instancie GameSwingView sera la vue permettant l'affichage et l'interaction
        GameSwingView gsv = new GameSwingView();
        gsv.createAndShowGUI();
        //ajout de la vue à la list views
        views.addViewable(gsv);

        //instancie plusieurs GameSwingPassiveView
        for (int i = 0; i < 2; i++){
            //instanciation de vue
            GameSwingPassiveView passiveView = new GameSwingPassiveView();
            //Création de frame
            passiveView.createAndShowGUI();
            //ajoute passiveView à la liste de views de GameViewables
            views.addViewable(passiveView);
            //sleep to move Swing frame on window
            try{
                Thread.sleep(2500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //GameController gameController = new GameController(new Deck(),new View(), new HighCardGameEvaluator());
        GameController gameController = new GameController(DeckFactory.makeDeck(DeckFactory.DeckType.Normal), views, new LowCardGameEvaluator());
        gameController.run();
    }

}
