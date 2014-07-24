package com.goznauk;

import com.goznauk.gamelevels.Lv1GameLevel;
import com.goznauk.gamelevels.GameLevel;
import com.goznauk.gamelevels.Lv2GameLevel;
import com.goznauk.gamelevels.Lv3GameLevel;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by goznauk on 2014. 7. 23..
 */
public class Player {
    private int level;
    private GameLevel gameLevel;
    private List<GameLevel> levels = new ArrayList<GameLevel>();

    public Player() {
        // The Character Should be level 1 at first
        level = 1;
        levels.add(Lv1GameLevel.getInstance());
        levels.add(Lv2GameLevel.getInstance());
        levels.add(Lv3GameLevel.getInstance());


        gameLevel = levels.get(0);
    }

    public void upgradeLevel() {
        // ERROR CHECKING 'IF' - NOT FOR LOGIC!!
        if(level == 3) {
            System.out.println("Level Max! Cannot increase level");
            return;
        }

        level++;
        gameLevel = levels.get(level-1);
    }

    public void attack() {
        System.out.println("============== Level " + level + " Ended ==============");
        gameLevel.play();
        System.out.println("============= Level " + level + " Started =============");
    }

    public GameLevel getGameLevel() {
        return gameLevel;
    }
}
