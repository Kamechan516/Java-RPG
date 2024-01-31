package com.rpg.fried_shrimp.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller
public interface PlayerController {

	//private final PlayerService playerService;

    @GetMapping("/players")
    public String getAllPlayers(Model model);
    
    // @GetMapping("/player/skill_manage")
    public String skillManagement(Model model);
        // プレイヤーの技一覧や取得可能な技一覧を設定

    // @PostMapping("/game/get_skills")
    public String getSkills(@RequestParam("availableSkills") List<Long> selectedSkillIds);
        // 選択した技を取得する処理を追加

    // 他にも必要なリクエストハンドラがあれば追加
}