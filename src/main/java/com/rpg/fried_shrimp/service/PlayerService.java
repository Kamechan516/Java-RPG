package com.rpg.fried_shrimp.service;

import java.util.List;

import com.rpg.fried_shrimp.model.Player;

//@Service
public interface PlayerService {
    Player getPlayerById(int id);
    Player getPlayerByName(String name);
    List<Player> getTopRanking();
    
    //@Autowired
    //private PlayerMapper playerMapper;

    // 他のメソッドやインジェクションを含めて必要ならば追加

}
