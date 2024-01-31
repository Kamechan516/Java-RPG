package com.rpg.fried_shrimp.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.rpg.fried_shrimp.model.Enemy;

@Mapper
public interface EnemyMapper {

        
        public Enemy selectEnemy(int enemyId);

}
