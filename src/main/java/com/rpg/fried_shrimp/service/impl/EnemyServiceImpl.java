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
        // ログを追加
        System.out.println("selectEnemy - enemyId: " + enemyId);

        // 敵の取得処理を実行
        Enemy enemy = enemyMapper.selectEnemy(enemyId);

        // ログを追加
        System.out.println("selectEnemy - result: " + enemy);

        return enemy;
    }

    public int getInitialEnemyHp(int enemyId) {
        // 敵の初期HPを取得する処理を実装
        // 仮の実装例: とりあえず100として返す
        return 100;
    }
}
