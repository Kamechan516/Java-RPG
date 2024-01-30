package com.rpg.fried_shrimp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpg.fried_shrimp.mapper.BattleMapper;
import com.rpg.fried_shrimp.model.Battle;
import com.rpg.fried_shrimp.model.Battle.BattleResult;
import com.rpg.fried_shrimp.model.Player;
import com.rpg.fried_shrimp.service.BattleService;

@Service
public class BattleServiceImpl implements BattleService {

    @Autowired
    private BattleMapper battleMapper;

    @Override
    public Battle getBattleById(int id) {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    public void saveBattle(Battle battle) {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public Battle setBattle(int battleId) {
        Battle battle = battleMapper.getBattleById(battleId);
        return battle;
    }

    @Override
    public BattleResult startBattle(Player player, int enemyId) {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    public int insertBattle(Battle battle) {
        // TODO Auto-generated method stub
        int battleId = battleMapper.insertBattle(battle);
        return battleId;
    }

    public void updateBattleHp(Battle battle) {
        battleMapper.updateBattleHp(battle);
    }

    // バトル情報を更新するエンドポイント
    public void updateBattle(Battle battle) {
        battleMapper.updateBattle(battle);
    }
}
