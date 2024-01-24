package com.rpg.fried_shrimp.controller;

import org.springframework.ui.Model;

//@Controller
//@RequestMapping("/")
public interface GameController {

	// private final PlayerService playerService;
	// private final GameService gameService;

	

	// @GetMapping("/ranking")
	public String showRanking(Model model);

	// @PostMapping("/game/clear")
	public String gameClear(Model model);

	// ゲームをあきらめた場合の処理を実装
	// プレイヤー情報のリセットなど
	// return "redirect:/top"; トップ画面へリダイレクト
	// @PostMapping("/game/give_up")
	public String giveUpGame();

	// バトルの結果を取得
	// @PostMapping("/game/battle")
	public String battle(Model model);
}
