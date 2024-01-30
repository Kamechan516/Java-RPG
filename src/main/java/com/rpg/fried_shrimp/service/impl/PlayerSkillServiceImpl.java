package com.rpg.fried_shrimp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpg.fried_shrimp.mapper.SkillMapper;
import com.rpg.fried_shrimp.model.PlayerSkill;
import com.rpg.fried_shrimp.service.PlayerSkillService;

@Service
public class PlayerSkillServiceImpl implements PlayerSkillService {

	@Autowired
	SkillMapper skillMapper;

	@Override
	public PlayerSkill getSkillById(int id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<PlayerSkill> getAllSkills() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void createSkill(PlayerSkill playerSkill) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public List<PlayerSkill> getPlayerSkills(int playerId) {
		
		List<PlayerSkill> playerSkill = skillMapper.findPlayerSkills(playerId);

		return playerSkill;
	}

}
