package com.rpg.fried_shrimp.model;

import lombok.Data;

@Data
public class Player {

	private int playerId;
	
	private String playerName;
	
	private int jobId;

    private int plSkill1;
    private int plSkill2;
    private int plSkill3;
    private int plSkill4;
    private int plSkillRemain1;
    private int plSkillRemain2;
    private int plSkillRemain3;
    private int plSkillRemain4;

    public int performAction(int playerHp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'performAction'");
    }

    public int getVictories() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVictories'");
    }

}
