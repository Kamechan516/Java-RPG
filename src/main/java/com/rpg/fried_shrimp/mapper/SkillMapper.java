package com.rpg.fried_shrimp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rpg.fried_shrimp.model.PlayerSkill;

@Mapper
public interface SkillMapper {
	
	List<PlayerSkill> findPlayerSkills(int playerId);
	

}
