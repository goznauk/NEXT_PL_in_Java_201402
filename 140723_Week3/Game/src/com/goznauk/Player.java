package com.goznauk;

import com.goznauk.gamelevels.Lv1GameLevel;
import com.goznauk.gamelevels.GameLevel;

import java.lang.reflect.Method;


/**
 * Created by goznauk on 2014. 7. 23..
 */
public class Player {
    private int level;
    private GameLevel gameLevel;

    public Player() {
        // The Character Should be level 1 at first
        level = 1;
        gameLevel = Lv1GameLevel.getInstance();
    }

    public void upgradeLevel() {
        // ERROR CHECKING 'IF' - NOT FOR LOGIC!!
        if(level == 3) {
            System.out.println("Level Max! Cannot increase level");
            return;
        }

        level++;

        String className = gameLevel.getClass().getPackage().toString() + "." + "Lv" + level + "GameLevel";
        className = className.replaceFirst("package ", "");

        try {
            Class c = Class.forName(className);
            Method method = c.getMethod("getInstance", new Class[0]);
            gameLevel = (GameLevel)method.invoke(c, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
