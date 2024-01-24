package com.rpg.fried_shrimp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rpg.fried_shrimp.dto.RankPoints;
import com.rpg.fried_shrimp.model.Player;

@Mapper
public interface RankingMapper {

	List<Player> findTopRanking();

	void insertRankPoints(RankPoints rankPoints);

}
