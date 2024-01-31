package com.rpg.fried_shrimp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rpg.fried_shrimp.dto.SetBattle;
import com.rpg.fried_shrimp.model.Battle;

@Mapper
public interface BattleMapper {

    Battle setBattle(int battleId);

    Battle insert(SetBattle setBattle);

    int getPoint(int enemyId);

    List<Battle> findByPlayerId(int playerId);

    int insertBattle(Battle battle);

    Battle getBattleById(int battleId);

    void updateBattleHp(Battle battle);

    int getCurrentTurn(int battleId);

    void setCurrentTurn(int battleId, int currentTurn);

    void updateBattle(Battle battle);

    void saveBattle(Battle battle);

}

