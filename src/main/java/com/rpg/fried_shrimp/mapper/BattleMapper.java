package com.rpg.fried_shrimp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rpg.fried_shrimp.dto.SetBattle;
import com.rpg.fried_shrimp.model.Battle;

@Mapper
public interface BattleMapper {

    Battle insert(SetBattle setBattle);
    int getPoint(int enemyId);

    List<Battle> findByPlayerId(int playerId);

    // 他にも必要なメソッドがあれば追加
}

