package com.rpg.fried_shrimp.model;

import lombok.Data;

@Data
public class PlayerSkill {

	private int plSkillId;
	private String plSkillName;
	private Pl_SkillType plSkillType;
	private int plSkillEffect;
	private int jobId;

	public enum Pl_SkillType {
		attack, heal
	}
}
