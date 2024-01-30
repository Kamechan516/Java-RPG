package com.rpg.fried_shrimp.model;

import lombok.Data;

@Data
public class Player {

	private int playerId;
	
	private String playerName;
	
	private int jobId;

    public int performAction(int playerHp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'performAction'");
    }

}
