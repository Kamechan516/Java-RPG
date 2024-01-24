package com.rpg.fried_shrimp.model;

import lombok.Data;

@Data
public class Enemy{

	private int enemyId;
	private String enemyName;
	private int enemyHp;
	private EnemyType enemyType;

	public enum EnemyType {

		type1, type2, type3

	}
}
