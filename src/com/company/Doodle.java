package com.company;

public class Doodle extends Person{

    private static int lastY;

    private static boolean doodleDown = true;

    private static int positionX = 250;
    private static int positionY = 400;

    public Doodle(){
        setYD(positionY);
        setX(positionX);
    }

    public static int getLastY() {
        return lastY;
    }

    public void setYD(int y) {
        lastY = getY();
        setY(y);
    }

    public static int getPositionY() {
        return positionY;
    }

    public static void setPositionY(int positionY) {
        Doodle.positionY = positionY;
    }
    public static void setPositionX(int positionX) {
        Doodle.positionX = positionX;
    }

    public boolean isDoodleDown() {
        if (getLastY()<= getY()) {
            doodleDown = true;
        }
        else doodleDown = false;
        return doodleDown;
    }

    public static void setDoodleDown(boolean doodleDown) {
        Doodle.doodleDown = doodleDown;
    }


}
