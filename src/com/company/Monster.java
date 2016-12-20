package com.company;

import java.util.ArrayList;

/**
 * Created by Дмитрий on 20.12.2016.
 */
public class Monster extends Person{

    private static ArrayList<Monster> monsters = new ArrayList<Monster>();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int x, y;

    public Monster(int xm, int ym) {
        setX(xm);
        setY(ym);
    }


    public static ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public static void setMonsters(ArrayList<Monster> monsters) {
        Monster.monsters = monsters;
    }
}
