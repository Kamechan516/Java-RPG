package com.rpg.fried_shrimp.service;

import java.util.List;

import com.rpg.fried_shrimp.model.Player;
import com.rpg.fried_shrimp.model.PlayerSkill;

public interface PlayerSkillService {
	PlayerSkill getSkillById(int id);

	List<PlayerSkill> getAllSkills(int jobId);

	List<PlayerSkill> getPlayerSkills(Player player);

}
