package com.rpg.fried_shrimp.dto;

import java.io.Serializable;

import com.rpg.fried_shrimp.model.Battle.BattleResult;

public class BattleAchie implements Serializable{
	
	int battleId;
	int playerId;
	int enemyId;
	int turns;
	BattleResult battleResult;
	
	
	


}
