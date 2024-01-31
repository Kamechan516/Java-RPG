package com.rpg.fried_shrimp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpg.fried_shrimp.mapper.JobMapper;
import com.rpg.fried_shrimp.mapper.PlayerMapper;
import com.rpg.fried_shrimp.model.Job;
import com.rpg.fried_shrimp.model.Player;
import com.rpg.fried_shrimp.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private JobMapper jobMapper;

    public Player selectPlayer(int id) {
        return playerMapper.selectPlayer(id);
    }

    public Job selectJobHp(int jobId) {
        return jobMapper.selectJob(jobId);
    }

    public Player getPlayerById(int id) {
        return playerMapper.getPlayerById(id);
    }


    public Player createPlayer(String playerName, int jobId) {
        Player newPlayer = new Player();
        newPlayer.setPlayerName(playerName);
        newPlayer.setJobId(jobId);

        int rowsAffected = playerMapper.insertPlayer(newPlayer);

        if (rowsAffected > 0) {
            return newPlayer;
        } else {
            throw new RuntimeException("Player creation failed");
        }
    }

    public List<Job> getAllJobs() {
        return jobMapper.getAllJob();
    }

    public int createPlayer(Player player) {
        return playerMapper.insertPlayer(player);
    }

    @Override
    public List<Player> getTopRanking() {
        // TODO: トップランキングを取得する処理を実装
        return null;
    }
}
