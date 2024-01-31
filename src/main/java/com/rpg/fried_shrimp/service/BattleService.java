package com.rpg.fried_shrimp.service;



import com.rpg.fried_shrimp.model.Battle;
import com.rpg.fried_shrimp.model.Battle.BattleResult;
import com.rpg.fried_shrimp.model.Player;

public interface BattleService {
    Battle getBattleById(int id);
    void saveBattle(Battle battle);
    Battle setBattle(int battleId);
    
    
    BattleResult startBattle(Player player, int enemyId);
}
