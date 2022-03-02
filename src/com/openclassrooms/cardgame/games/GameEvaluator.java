package com.openclassrooms.cardgame.games;

import com.openclassrooms.cardgame.model.IPlayer;

import java.util.List;

public interface GameEvaluator {
    IPlayer evaluateWinner(List<IPlayer> players);
}
