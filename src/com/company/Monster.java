package com.company;

import java.util.ArrayList;

/**
 * Created by Дмитрий on 20.12.2016.
 */
public class Monster extends Person{

    private static ArrayList<Monster> monsters = new ArrayList<Monster>();

    public static ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public static void setMonsters(ArrayList<Monster> monsters) {
        Monster.monsters = monsters;
    }
}
