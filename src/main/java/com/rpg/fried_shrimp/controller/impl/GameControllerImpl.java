package com.rpg.fried_shrimp.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rpg.fried_shrimp.controller.GameController;
import com.rpg.fried_shrimp.mapper.JobMapper;
import com.rpg.fried_shrimp.mapper.PlayerMapper;
import com.rpg.fried_shrimp.model.Job;
import com.rpg.fried_shrimp.model.Player;
import com.rpg.fried_shrimp.service.impl.PlayerServiceImpl;
import com.rpg.fried_shrimp.service.impl.SkillServiceImpl;

@Controller
public class GameControllerImpl implements GameController {

	@Autowired
	private JobMapper jobMapper;

	@Autowired
	private PlayerMapper playerMapper;

	@Autowired
	private SkillServiceImpl skillService;

	@Autowired
	private PlayerServiceImpl playerService;

	@GetMapping("/")
	public String index(Model model) {
		// Jobテーブルから取得
		List<Job> jobs = jobMapper.getAllJob();
		// thymeleafに追加
		model.addAttribute("jobs", jobs);
		return "index";
	}

	@PostMapping("/create/player")
	public String createPlayer(@ModelAttribute Player player) {
		// プレイヤーを挿入し、挿入後のプレイヤーIDを取得
		int playerId = playerService.insertPlayer(player.getPlayerName(), player.getJobId());

		// リダイレクト
		return "redirect:/waiting/" + playerId;
	}

	@GetMapping("waiting/{playerId}")
	public String waiting(@PathVariable int playerId, Model model) {
		Player player = playerService.getPlayerById(playerId);
		model.addAttribute("player", player);
		return "waiting";
	}

	@Override
	public String showRanking(Model model) {
		// TODO 自動生成されたメソッド・スタブ

		return "/ranking";
	}

	@Override
	public String gameClear(Model model) {
		// TODO 自動生成されたメソッド・スタブ
		return "clear";
	}

	@Override
	@GetMapping("/give-up")
	public String giveUpGame() {
		// ゲームを放棄する処理
		return "redirect:/";
	}

	@Override
	public String battle(Model model) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
