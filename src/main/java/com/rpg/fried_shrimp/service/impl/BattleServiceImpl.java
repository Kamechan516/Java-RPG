package com.rpg.fried_shrimp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpg.fried_shrimp.mapper.BattleMapper;
import com.rpg.fried_shrimp.mapper.JobMapper;
import com.rpg.fried_shrimp.model.Battle;
import com.rpg.fried_shrimp.model.Battle.BattleResult;
import com.rpg.fried_shrimp.model.Player;
import com.rpg.fried_shrimp.service.BattleService;

@Service
public class BattleServiceImpl implements BattleService {

    @Autowired
    private BattleMapper battleMapper;
    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private EnemyServiceImpl enemyService;

    @Override
    public Battle getBattleById(int id) {
        return battleMapper.getBattleById(id);
    }

    @Override
    public void saveBattle(Battle battle) {
        // バトル情報を保存するロジックを実装
        battleMapper.saveBattle(battle);
    }

    @Override
    public Battle setBattle(int battleId) {
        return battleMapper.getBattleById(battleId);
    }

    @Override
    public BattleResult startBattle(Player player, int enemyId) {
        // バトル開始時の処理を実装
        // 例: プレイヤーと敵の初期HPを設定し、バトル結果を返す
        Battle battle = new Battle();
        battle.setPlayerId(player.getPlayerId());
        battle.setEnemyId(enemyId);
        battle.setPlayerHp((jobMapper.getJobHp(player.getJobId())));
        battle.setEnemyHp(enemyService.getInitialEnemyHp(enemyId));

        // バトル結果を判定
        BattleResult result = calculateBattleResult(battle.getPlayerHp(), battle.getEnemyHp());
        battle.setBattleResult(result);

        // バトル情報を保存
        saveBattle(battle);

        return result;
    }

    public int insertBattle(Battle battle) {
        // バトル情報をデータベースに挿入
        return battleMapper.insertBattle(battle);
    }

    public void updateBattleHp(Battle battle) {
        // バトルのHP情報を更新
        battleMapper.updateBattleHp(battle);
    }

    public void updateBattle(Battle battle) {
        // バトル情報を更新
        battleMapper.updateBattle(battle);
    }

     // バトル結果を判定するメソッド
     private BattleResult calculateBattleResult(int playerHp, int enemyHp) {
        if (playerHp <= 0) {
            return BattleResult.LOSE;
        } else if (enemyHp <= 0) {
            return BattleResult.WIN;
        }
        return null;
    }
}
