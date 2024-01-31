package com.rpg.fried_shrimp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.rpg.fried_shrimp.model.Battle;

// import com.example.demo.model.Battle;
// import com.example.demo.model.Player;
// import com.example.demo.service.BattleService;
// import com.example.demo.service.PlayerService;

//@Controller
//@RequestMapping("/battle")
public interface BattleController {

     //final BattleService battleService;
     //final PlayerService playerService;
    
    // バトルスタート
    //@GetMapping("/battle")
    public String startBattle(Model model);
    
    // 結果表示
    //@PostMapping("/battle/result")
    public String battleResult(Battle battle, Model model) ;
    
    
    // 再挑戦用
    //@GetMapping("/battle/retry/{enemyId}")
    public String retryBattle(@PathVariable int enemyId, Model model);
    
    // 次のバトルへ
    //@PostMapping("/battle/next")
    public String nextBattle();

    // あきらめる
    //@PostMapping("/battle/give_up")
    public String giveUp();
    
    // その他バトル関連のエンドポイントを実装
}
