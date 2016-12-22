package com.company;

import java.util.ArrayList;

public class Monster extends Person{

    private static ArrayList<Monster> monsters = new ArrayList<Monster>();

    public static ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public static void setMonsters(ArrayList<Monster> monsters) {
        Monster.monsters = monsters;
    }
}
