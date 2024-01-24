package com.rpg.fried_shrimp.service;

import java.util.List;

import com.rpg.fried_shrimp.model.PlayerSkill;

public interface SkillService {
	PlayerSkill getSkillById(int id);

	List<PlayerSkill> getAllSkills();

	void createSkill(PlayerSkill playerSkill);

	List<PlayerSkill> getPlayerSkills(int playerId);

}
