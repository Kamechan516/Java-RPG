package com.rpg.fried_shrimp.controller.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rpg.fried_shrimp.mapper.PlayerMapper;
import com.rpg.fried_shrimp.model.Job;
import com.rpg.fried_shrimp.model.Player;
import com.rpg.fried_shrimp.service.impl.PlayerServiceImpl;
import com.rpg.fried_shrimp.service.impl.PlayerSkillServiceImpl;

@Controller
public class GameControllerImpl {

	@Autowired
	private PlayerServiceImpl playerService;
	@Autowired
	private PlayerSkillServiceImpl playerSkillService;
	@Autowired
	private PlayerMapper playerMapper;

	@GetMapping("/")
	public String index(Model model) {
		// Jobテーブルから取得
		List<Job> jobs = playerService.getAllJobs();
		// thymeleafに追加
		model.addAttribute("jobs", jobs);
		return "index";
	}

	@PostMapping("/")
	public String indexPost(Model model) {
		// Jobテーブルから取得
		List<Job> jobs = playerService.getAllJobs();
		// thymeleafに追加
		model.addAttribute("jobs", jobs);
		return "index";
	}

	@PostMapping("/createPlayer")
	public String createPlayer(@ModelAttribute Player player, Model model) {
		// プレイヤーの作成処理

		// プレイヤーIDを取得
		int playerId = playerService.createPlayer(player);

		// プレイヤーIDを使用してバトル画面にリダイレクト
		return "redirect:/battle/start/" + playerId;
	}

	@GetMapping("/battle/start/{playerId}")
	public String startBattle(@PathVariable int playerId, Model model) {
		// バトル開始前の処理（技の選択など）

		// プレイヤー情報を取得
		Player player = playerService.selectPlayer(playerId);

		// 技の一覧をThymeleafに追加
		model.addAttribute("player", player);
		model.addAttribute("skills", playerSkillService.getAllSkills(player.getJobId()));

		return "/skillSelect";
	}

	  @PostMapping("/update_skills/{playerId}")
    public String updateSkills(@PathVariable int playerId, @RequestParam("selectedSkills") List<Integer> selectedSkillIds) {
        // ロジック: 選択されたスキル情報を使用してPlayerテーブルを更新
          Map<String, Object> params = new HashMap<>();
        params.put("playerId", playerId);

        for (int i = 0; i < Math.min(selectedSkillIds.size(), 4); i++) {
            params.put("skill" + (i + 1), selectedSkillIds.get(i));
        }

        playerMapper.updateSkills(params);
        // リダイレクトなどの適切な応答を返す
        return "skillSelect"; // 適切な画面にリダイレクト
    }

	// 以下、他のメソッドや機能の実装（showRanking、gameClear、giveUpGame、battleなど）が続きます。

}
