package com.rpg.fried_shrimp.model;
import java.sql.Timestamp;
import java.util.List;

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

    public int getPlayerHp() {
        return this.playerHp;
    }

    public int getEnemyHp() {
        return this.enemyHp;
    }

    public int getCurrentTurn() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCurrentTurn'");
    }

    public void setCurrentTurn(int determineInitialTurn) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCurrentTurn'");
    }

    public void setPlayerSkills(List<PlayerSkill> selectedSkills) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPlayerSkills'");
    }
  
}
