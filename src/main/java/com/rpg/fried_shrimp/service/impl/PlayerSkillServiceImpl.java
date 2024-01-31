package com.rpg.fried_shrimp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpg.fried_shrimp.mapper.PlayerSkillMapper;
import com.rpg.fried_shrimp.model.Player;
import com.rpg.fried_shrimp.model.PlayerSkill;
import com.rpg.fried_shrimp.service.PlayerSkillService;

@Service
public class PlayerSkillServiceImpl implements PlayerSkillService {

    @Autowired
    PlayerSkillMapper playerSkillMapper;

    @Override
    public PlayerSkill getSkillById(int id) {
        return playerSkillMapper.getSkillById(id);
    }

    
    public List<PlayerSkill> getAllSkills(int jobId) {
        return playerSkillMapper.getAllSkills(jobId);
    }


    @Override
    public List<PlayerSkill> getPlayerSkills(Player player) {
        return playerSkillMapper.findPlayerSkills(player);
    }

    public List<PlayerSkill> getSelectedSkills(List<Integer> selectedSkillIds) {
        return playerSkillMapper.getSelectedSkills(selectedSkillIds);
        
    }
}
