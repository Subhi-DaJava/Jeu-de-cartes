package com.openclassrooms.cardgame.games;

import com.openclassrooms.cardgame.model.Player;

import java.util.List;

public interface GameEvaluator {
    Player evaluateWinner(List<Player> players);
}
