package com.goznauk.gamelevels;

/**
 * Created by goznauk on 2014. 7. 23..
 */
public class Lv2GameLevel extends GameLevel {
    private static Lv2GameLevel instance = new Lv2GameLevel();

    private Lv2GameLevel() {
        super(2);
    }

    public static GameLevel getInstance() {
        return instance;
    }

    @Override
    protected void simpleAttack() {
        System.out.print(getEffect(KEY.SIMPLE));
        System.out.print(getEffect(KEY.SIMPLE));
    }

    @Override
    protected void turnAttack() {
        System.out.print(getEffect(KEY.TURN));
    }

    @Override
    protected void flyingAttack() {
        System.out.print(getEffect(KEY.IMPOSSIBLE));
    }
}
