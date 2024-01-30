package com.rpg.fried_shrimp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpg.fried_shrimp.mapper.EnemyMapper;
import com.rpg.fried_shrimp.model.Enemy;

@Service
public class EnemyServiceImpl {
    
    @Autowired
    private EnemyMapper enemyMapper;

    

    public Enemy selectEnemy(int enemyId) {
        System.out.println("selectEnemy - enemyId: " + enemyId); // ログを追加
    
        Enemy enemy = enemyMapper.selectEnemy(enemyId);
        System.out.println("selectEnemy - result: " + enemy); // ログを追加
    
        return enemy;
    }
    

}
