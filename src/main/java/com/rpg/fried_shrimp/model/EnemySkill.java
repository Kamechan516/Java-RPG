package com.rpg.fried_shrimp.model;

import lombok.Data;

@Data
public class EnemySkill {

	private int emSkillId;
	private String emSkillName;
	private emSkillType emSkillType;
	private int emSkillEffect;
	private int enemyId;

	public enum emSkillType {
		attack, heal
	}
	
}
