package com.company;

/**
 * Created by Дмитрий on 20.12.2016.
 */
public abstract class Person {

    private static int lastY;
    private static int x;
    private static int y;

    public static int getLastY() {
        return lastY;
    }

    public static void setLastY(int lastY) {
        Person.lastY = lastY;
    }

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

    public void setYD(int y) {
        lastY = this.y;
        this.y = y;
    }


}
