package com.goznauk.gamelevels;

/**
 * Created by goznauk on 2014. 7. 23..
 */
public class Lv3GameLevel extends GameLevel {
    private static Lv3GameLevel instance = new Lv3GameLevel();

    private Lv3GameLevel() {
        super(3);
    }

    public static GameLevel getInstance() {
        return instance;
    }

    @Override
    protected void simpleAttack() {
        System.out.print(getEffect(KEY.SIMPLE));
        System.out.print(getEffect(KEY.SIMPLE));
        System.out.print(getEffect(KEY.SIMPLE));
    }

    @Override
    protected void turnAttack() {
        System.out.print(getEffect(KEY.TURN));
        System.out.print(getEffect(KEY.TURN));
    }

    @Override
    protected void flyingAttack() {
        System.out.print(getEffect(KEY.FLYING));
    }
}
