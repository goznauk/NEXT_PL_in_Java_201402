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
    public void play() {
        System.out.print("[level" + level + "] Simple Attack : ");
        simpleAttack();
        simpleAttack();
        simpleAttack();
        System.out.println();
        System.out.print("[level" + level + "] Turn   Attack : ");
        turnAttack();
        turnAttack();
        System.out.println();
        System.out.print("[level" + level + "] Flying Attack : ");
        flyingAttack();
        System.out.println();
    }

    @Override
    protected void simpleAttack() {
        System.out.print(getEffect(KEY.SIMPLE));
    }

    @Override
    protected void turnAttack() {
        System.out.print(getEffect(KEY.TURN));
    }

    @Override
    protected void flyingAttack() {
        System.out.print(getEffect(KEY.FLYING));
    }
}
