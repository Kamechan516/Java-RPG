package com.rpg.fried_shrimp.dto;

import java.io.Serializable;

public class SetBattle implements Serializable {

	int battleId;
	int playerId;
	int enemyId;
	int turn;
	int playerHp;
	int enemyHp;

}