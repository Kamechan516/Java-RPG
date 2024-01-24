package com.rpg.fried_shrimp.model;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class Battle {

    
    private int battleId;
    private int playerId;
    private int enemyId;
    private int playerHp;
    private int enemyHp;
    private int turn;
    private Timestamp createDate;
    private BattleResult battleResult;

    public enum BattleResult{
    	WIN,LOSE
    }
  
}
