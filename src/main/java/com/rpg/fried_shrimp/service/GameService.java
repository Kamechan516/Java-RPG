package com.rpg.fried_shrimp.service;

import java.util.List;

import com.rpg.fried_shrimp.model.Battle.BattleResult;
import com.rpg.fried_shrimp.model.Player;

public interface GameService {

    Player createPlayer(String name, String job);

    List<Player> getRanking();

    BattleResult startBattle(int playerId);

    void giveUp(int playerId);
}

