package com.rpg.fried_shrimp.controller.impl;

import java.sql.Timestamp;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rpg.fried_shrimp.mapper.JobMapper;
import com.rpg.fried_shrimp.model.Battle;
import com.rpg.fried_shrimp.model.Enemy;
import com.rpg.fried_shrimp.model.Job;
import com.rpg.fried_shrimp.model.Player;
import com.rpg.fried_shrimp.service.impl.BattleServiceImpl;
import com.rpg.fried_shrimp.service.impl.EnemyServiceImpl;
import com.rpg.fried_shrimp.service.impl.PlayerServiceImpl;

@Controller
public class BattleControllerImpl {

    @Autowired
    BattleServiceImpl battleService;
    @Autowired
    PlayerServiceImpl playerService;
    @Autowired
    EnemyServiceImpl enemyService;
    @Autowired
    JobMapper jobMapper;

    @GetMapping("/battle/{playerId}")
    public String battleStart(@PathVariable int playerId, Model model) {
        Player player = playerService.selectPlayer(playerId);
        Job job = jobMapper.selectJob(player.getJobId());

        // Enemy情報の取得
        // バトルの初期化
        int enemyId = new Random().nextInt(3) + 1; // またはランダムに決定
        Enemy enemy = enemyService.selectEnemy(enemyId);



        // バトルの初期化
        int battleId = initializeBattle(player, job, enemy);
        Battle battle = battleService.setBattle(battleId);
        
       
        
        model.addAttribute("battle", battle);
        model.addAttribute("player", player);
        model.addAttribute("job", job);
        model.addAttribute("enemy", enemy);


        return "battle";
    }


    private int initializeBattle(Player player, Job job, Enemy enemy) {
        Battle battle = new Battle();
        battle.setPlayerId(player.getPlayerId());
    
        // プレイヤーの初期HPを設定
        battle.setPlayerHp(job.getJobHp());
    
        // 敵情報がnullでないことを確認
        if (enemy != null) {
            battle.setEnemyId(enemy.getEnemyId());
            // 敵の初期HPを設定
            battle.setEnemyHp(enemy.getEnemyHp());
        } else {
            // エラーハンドリングやデフォルトの敵情報の設定などを行う
            // 例: battle.setEnemyId(defaultEnemyId);
            //     battle.setEnemyHp(defaultEnemyHp);
        }
    
        battle.setTurn(0);
        battle.setCreateDate(new Timestamp(System.currentTimeMillis()));
        battle.setBattleResult(null);
    
        // 戻り値はinsertしたバトルのIDではない
        battleService.insertBattle(battle);
    
        return battle.getBattleId();
    }
    
    

    @PostMapping("/update")
    public void updateBattle(@RequestParam int battleId) {
        Battle battle = battleService.getBattleById(battleId);
    
        Player player = playerService.selectPlayer(battle.getPlayerId());
        int updatedPlayerHp = player.performAction(battle.getPlayerHp());
        battle.setPlayerHp(updatedPlayerHp);
    
        Enemy enemy = enemyService.selectEnemy(battle.getEnemyId());
        int updatedEnemyHp = enemy.performAction(battle.getEnemyHp());
        battle.setEnemyHp(updatedEnemyHp);
    
        battle.setTurn(battle.getTurn() + 1);
    
        battleService.updateBattle(battle);
    }
    
    // バトル結果を判定するメソッド（例）
    // private Battle.BattleResult calculateBattleResult(int playerHp, int enemyHp) {
    //     if (playerHp <= 0 && enemyHp <= 0) {
    //         return Battle.BattleResult.DRAW;
    //     } else if (playerHp <= 0) {
    //         return Battle.BattleResult.DEFEAT;
    //     } else if (enemyHp <= 0) {
    //         return Battle.BattleResult.VICTORY;
    //     } else {
    //         return Battle.BattleResult.IN_PROGRESS;
    //     }
    // }
    

	
	public String startBattle(Model model) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'startBattle'");
	}

	
	public String battleResult(Battle battle, Model model) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'battleResult'");
	}


	public String retryBattle(int enemyId, Model model) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'retryBattle'");
	}

	
	public String nextBattle() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'nextBattle'");
	}

	
	public String giveUp() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'giveUp'");
	}

    // ...（その他のメソッド）
}