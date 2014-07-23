package com.goznauk;

public class Board {

    public static void main(String[] args) {
        Player p = new Player();
        p.attack();
        p.upgradeLevel();
        System.out.println();

        p.attack();
        p.upgradeLevel();
        System.out.println();

        p.attack();
        p.upgradeLevel();
        System.out.println();
    }
}
