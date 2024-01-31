package com.rpg.fried_shrimp.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.rpg.fried_shrimp.model.Player;
import com.rpg.fried_shrimp.model.PlayerSkill;

@Mapper
public interface PlayerSkillMapper {
	
		List<PlayerSkill> findPlayerSkills(Player player);

		List<PlayerSkill> getAllSkills(int jobId);

	    PlayerSkill getSkillById(int id);

		List<PlayerSkill> getSelectedSkills(List<Integer> selectedSkillIds);
	

}
