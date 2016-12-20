package com.company;

/**
 * Created by Дмитрий on 18.12.2016.
 */
public class Doodle extends Person{

    private  static KeyController keyController = new KeyController();
    private static float delta = 0;
    private static final float speed = 0.1f;
    private int step = 15;

    private static boolean doodleDown = true;
    private static boolean doodleStop = false;

    private static int possionX = 250;
    private static int possionY = 400;

    public Doodle(){
        setYD(possionY);
        setX(possionX);
    }


    public static int getPossionY() {
        return possionY;
    }

    public static void setPossionY(int possionY) {
        Doodle.possionY = possionY;
    }

    public boolean isDoodleDown() {
        if (getLastY()<= getY()) {
            doodleDown = true;
        }
        else doodleDown = false;
        return doodleDown;
    }

    public void setDoodleDown(boolean doodleDown) {
        Doodle.doodleDown = doodleDown;
    }

    public static void setDoodleStop(boolean doodleStop) {
        Doodle.doodleStop = doodleStop;
    }

    public static boolean isDoodleStop() {
        return doodleStop;
    }

}
