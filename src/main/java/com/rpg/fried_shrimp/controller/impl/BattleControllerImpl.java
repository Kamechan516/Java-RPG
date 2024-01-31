package com.rpg.fried_shrimp.controller.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rpg.fried_shrimp.mapper.JobMapper;
import com.rpg.fried_shrimp.model.Battle;
import com.rpg.fried_shrimp.model.Enemy;
import com.rpg.fried_shrimp.model.Job;
import com.rpg.fried_shrimp.model.Player;
import com.rpg.fried_shrimp.model.PlayerSkill;
import com.rpg.fried_shrimp.model.Battle.BattleResult;
import com.rpg.fried_shrimp.service.impl.BattleServiceImpl;
import com.rpg.fried_shrimp.service.impl.EnemyServiceImpl;
import com.rpg.fried_shrimp.service.impl.PlayerServiceImpl;
import com.rpg.fried_shrimp.service.impl.PlayerSkillServiceImpl;

@Controller
public class BattleControllerImpl {

    @Autowired
    private PlayerServiceImpl playerService;
    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private BattleServiceImpl battleService;
    @Autowired
    private EnemyServiceImpl enemyService;
    @Autowired
    private PlayerSkillServiceImpl PlayerskillService;

    // @GetMapping("/battle/start/{playerId}")
    // public String battleStart(@PathVariable int playerId, Model model) {
    //     Player player = playerService.selectPlayer(playerId);
    //     Job job = jobMapper.selectJob(player.getJobId());

    //     // プレイヤーの技を取得
    //     List<PlayerSkill> playerSkills = PlayerskillService.getPlayerSkills(player);

    //     model.addAttribute("player", player);
    //     model.addAttribute("job", job);
    //     model.addAttribute("playerSkills", playerSkills);

    //     return "battle"; // バトル前の技選択画面に遷移
    // }

    @PostMapping("/battle/{playerId}")
    public String startBattle( @PathVariable int playerId,
    @RequestParam(name = "playerId", required = false) List<Integer> selectedSkillIds, Model model) {
        Player player = playerService.selectPlayer(playerId);
        Job job = jobMapper.selectJob(player.getJobId());

        // 選択された技を取得
        List<PlayerSkill> selectedSkills = PlayerskillService.getSelectedSkills(selectedSkillIds);

        // Enemy情報の取得
        int enemyId = new Random().nextInt(3) + 1; // またはランダムに決定
        Enemy enemy = enemyService.selectEnemy(enemyId);

        // バトルの初期化
        int battleId = initializeBattle(player, job, enemy);
        Battle battle = battleService.setBattle(battleId);

        model.addAttribute("selectedSkills", selectedSkills);
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

    @PostMapping("/battle/update")
    public String updateBattle(@RequestParam int battleId, Model model) {
        Battle battle = battleService.getBattleById(battleId);

        Player player = playerService.selectPlayer(battle.getPlayerId());
        int updatedPlayerHp = player.performAction(battle.getPlayerHp());
        battle.setPlayerHp(updatedPlayerHp);

        Enemy enemy = enemyService.selectEnemy(battle.getEnemyId());
        int updatedEnemyHp = enemy.performAction(battle.getEnemyHp());
        battle.setEnemyHp(updatedEnemyHp);

        battle.setTurn(battle.getTurn() + 1);

        // バトル結果を判定
        Battle.BattleResult result = calculateBattleResult(battle.getPlayerHp(), battle.getEnemyHp());
        battle.setBattleResult(result);

        // バトル結果に応じた処理
        if (result == Battle.BattleResult.WIN) {
            // バトルに勝利した場合の処理
            if (player.getVictories() == 4) {
                // プレイヤーが4回勝利した場合はゲームクリア
                return "redirect:/game/clear/" + player.getPlayerId();
            }
            // まだゲームクリアしていない場合は次のバトルへ進む
            return "redirect:/battle/next/" + player.getPlayerId();
        } else if (result == Battle.BattleResult.LOSE) {
            // バトルに敗北した場合の処理
            return "redirect:/battle/retry/" + battle.getEnemyId() + "/" + player.getPlayerId();
        } else {
            // バトルが続行中の場合はバトル画面を表示
            battleService.updateBattle(battle);
            model.addAttribute("battle", battle);
            model.addAttribute("player", player);
            model.addAttribute("enemy", enemy);
            return "battle";
        }
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
