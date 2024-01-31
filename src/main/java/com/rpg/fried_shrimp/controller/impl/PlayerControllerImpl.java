package com.rpg.fried_shrimp.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rpg.fried_shrimp.controller.PlayerController;
import com.rpg.fried_shrimp.model.Player;
import com.rpg.fried_shrimp.service.impl.PlayerServiceImpl;

@Controller
public class PlayerControllerImpl implements PlayerController {

	   @Autowired
	    private PlayerServiceImpl playerService;

	   @PostMapping(value = "/createPlayer", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	   public String createPlayer(@RequestParam String playerName, @RequestParam int jobId) {
	       // プレイヤーを作成するためのロジック
	       Player player = playerService.createPlayer(playerName, jobId);
		   int playerId = player.getPlayerId();
	       return "redirect:/battle/" + playerId; // 成功ページにリダイレクト
	   }
	    


	@Override
	public String getAllPlayers(Model model) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String skillManagement(Model model) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String getSkills(List<Long> selectedSkillIds) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

    // 他のメソッドも同様に@Autowiredを使用してplayerServiceを注入する
}
