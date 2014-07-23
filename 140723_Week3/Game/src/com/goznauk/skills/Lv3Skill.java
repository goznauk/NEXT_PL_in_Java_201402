package com.goznauk.skills;

/**
 * Created by goznauk on 2014. 7. 23..
 */
public class Lv3Skill extends Skill {
    public Lv3Skill() {
        super(3);
    }

    @Override
    public void use() {
        System.out.println("Power OverWhelming");
        // Do sth that makes Shield
    }
}
