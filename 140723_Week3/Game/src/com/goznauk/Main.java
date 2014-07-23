package com.goznauk;

import com.oracle.javafx.jmx.json.JSONDocument;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Character c = new Character();
        c.useSkill();
        c.levelUp();

        c.useSkill();
        c.useSkill();
        c.levelUp();

        c.useSkill();
        c.levelUp();
    }
}
