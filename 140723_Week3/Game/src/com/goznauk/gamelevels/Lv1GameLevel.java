package com.goznauk.gamelevels;

/**
 * Created by goznauk on 2014. 7. 23..
 */
public class Lv1GameLevel extends GameLevel {
    private static Lv1GameLevel instance = new Lv1GameLevel();

    private Lv1GameLevel() {
        super(1);
    }

    public static GameLevel getInstance() {
        return instance;
    }


    @Override
    public void play() {
        System.out.print("[level" + level + "] Simple Attack : ");
        simpleAttack();
        System.out.println();
        System.out.print("[level" + level + "] Turn   Attack : ");
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
        System.out.print(getEffect(KEY.IMPOSSIBLE));
    }

    @Override
    protected void flyingAttack() {
        System.out.print(getEffect(KEY.IMPOSSIBLE));
    }
}
