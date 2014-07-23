package com.goznauk;

import com.goznauk.skills.Lv1Skill;
import com.goznauk.skills.Skill;


/**
 * Created by goznauk on 2014. 7. 23..
 */
public class Character {
    private int level;
    private Skill skill;

    public Character() {
        // The Character Should be level 1 at first
        level = 1;
        skill = new Lv1Skill();
    }

    public void levelUp() {
        if(level == 3) {
            System.out.println("Level Max! Cannot increase level");
            return;
        }

        level++;
        System.out.println("Level Up! : " + level);

        String ClassName = skill.getClass().getPackage().toString() + "." + "Lv" + level + "Skill";
        ClassName = ClassName.replaceFirst("package ", "");
        try {
            Class c = Class.forName(ClassName);
            skill = (Skill)c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void useSkill() {
        System.out.println("Character Used : " + skill.getName());
        skill.use();
    }
}
