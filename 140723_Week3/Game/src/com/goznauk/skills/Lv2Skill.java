package com.goznauk.skills;

/**
 * Created by goznauk on 2014. 7. 23..
 */
public class Lv2Skill extends Skill {
    public Lv2Skill() {
        super(2);
    }

    @Override
    public void use() {
        System.out.println("You've got 30 HP");
        // Do sth that heals character
    }
}
