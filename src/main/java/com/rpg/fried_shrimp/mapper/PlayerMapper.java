package com.rpg.fried_shrimp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rpg.fried_shrimp.model.Player;

//PlayerMapperインターフェースから@Insertを削除
@Mapper
public interface PlayerMapper {

	Player getPlayerById(int id);

	List<Player> getAllPlayers();


	Player insertPlayer(String playerName, int jobId);

	int insertPlayer(Player newPlayer);

	Player selectPlayer(int PlayerId);
}
