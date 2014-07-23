package com.goznauk.skills;

/**
 * Created by goznauk on 2014. 7. 23..
 */
public class Lv1Skill extends Skill {
    public Lv1Skill() {
        super(1);
    }

    @Override
    public void use() {
        System.out.println("Pzzzz...");
        // Do sth that attacks other
    }
}
