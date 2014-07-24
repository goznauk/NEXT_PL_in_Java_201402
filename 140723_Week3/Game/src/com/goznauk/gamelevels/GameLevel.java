package com.goznauk.gamelevels;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by goznauk on 2014. 7. 23..
 */
public abstract class GameLevel {
    public enum KEY { IMPOSSIBLE, SIMPLE, TURN, FLYING };
    protected int level;
    protected List<String> effect = new ArrayList<String>();

    protected GameLevel(int level) {
        this.level = level;

        Properties properties = new Properties();
        try {
            properties.loadFromXML(new FileInputStream("skillset.xml"));
            for(int i = 0; i<properties.size(); i++) {
                effect.add((String)properties.get("Effect" + i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final void play() {
        System.out.print("[level" + level + "] Simple Attack : ");
        simpleAttack();
        System.out.println();
        System.out.print("[level" + level + "]  Turn  Attack : ");
        turnAttack();
        System.out.println();
        System.out.print("[level" + level + "] Flying Attack : ");
        flyingAttack();
        System.out.println();
    }

    public String getEffect(KEY key) {
        return effect.get(key.ordinal());
    }

    protected abstract void simpleAttack();

    protected abstract void turnAttack();

    protected abstract void flyingAttack();

    public int getLevel() {
        return level;
    }
}
