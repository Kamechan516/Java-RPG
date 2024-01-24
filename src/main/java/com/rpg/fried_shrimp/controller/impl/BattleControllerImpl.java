package com.rpg.fried_shrimp.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rpg.fried_shrimp.controller.BattleController;
import com.rpg.fried_shrimp.dto.SetBattle;
import com.rpg.fried_shrimp.model.Battle;
import com.rpg.fried_shrimp.service.impl.BattleServiceImpl;

@RequestMapping(value = "/battle")
public class BattleControllerImpl implements BattleController {

	@Autowired
	BattleServiceImpl battleService;

	@GetMapping(value = "start")
	public String battle(@ModelAttribute SetBattle setbattle, Model model) {
		Battle battle = battleService.setBattle(setbattle);

		int generatedBattleId = battle.getBattleId();

		// 取得したBattleIdを使用して動的なURLを生成する
		String dynamicUrl = "" + generatedBattleId;
		
		model.addAttribute("battle", battle);
		// リダイレクト
		return "redirect:" + dynamicUrl;
	}

	@GetMapping(value = "{battleId}")
	public String showBattle(@PathVariable int battleId, Model model) {
		// BattleIdを使って必要なデータを取得する処理を実装
		Battle battle = battleService.getBattleById(battleId);

		// モデルに必要なデータを追加
		model.addAttribute("battle", battle);

		// battle.htmlを表示する
		return "battle";
	}

	@Override
	public String battleResult(Battle battle, Model model) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String retryBattle(Long enemyId, Model model) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String nextBattle() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String giveUp() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String startBattle(Model model) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
