package com.rpg.fried_shrimp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpg.fried_shrimp.mapper.PlayerMapper;
import com.rpg.fried_shrimp.model.Player;
import com.rpg.fried_shrimp.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerMapper playerMapper;

	@Override
	public Player getPlayerById(int id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Player getPlayerByName(String name) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<Player> getTopRanking() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	// ここにコンストラクタを追加
	public PlayerServiceImpl() {
		// コンストラクタの初期化処理
	}

	public Player createPlayer(String playerName, int jobId) {
		// Playerオブジェクトを作成
		Player newPlayer = new Player();
		newPlayer.setPlayerName(playerName);
		newPlayer.setJobId(jobId);

		// PlayerMapperを使用してinsertする処理
		int rowsAffected = playerMapper.insertPlayer(newPlayer);

		// insertが成功した場合、新しいPlayerオブジェクトを返す
		// 失敗した場合は適切なエラーハンドリングを行う
		if (rowsAffected > 0) {
			return newPlayer;
		} else {
			// もしくは例外をスローするなどのエラーハンドリングを行う
			throw new RuntimeException("Player creation failed");
		}
	}

	public int insertPlayer(String playerName, int jobId) {
		// プレイヤーを挿入し、挿入後のプレイヤーIDを取得
		Player newPlayer = createPlayer(playerName, jobId);
		return newPlayer.getPlayerId();
	}

}
