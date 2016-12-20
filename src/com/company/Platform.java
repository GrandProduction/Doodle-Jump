package com.company;

/**
 * Created by Дмитрий on 18.12.2016.
 */
public abstract class Platform {

    private boolean movePlatformR = false;
    private int stepMovePlatform = 2;

    protected int x, y;
    private int xStart;
    private String name;

    private int yStart;

    public Platform(int xp, int yp){
        x = xp;
        y = yp;
        xStart = x;
        yStart = y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getxStart() {
        return xStart;
    }

    public void setxStart(int xStart) {
        this.xStart = xStart;
    }

    public void setyStart(int yStart) {
        this.yStart = yStart;
    }

    public int getyStart() {
        return yStart;
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

    public void movePlatformRL(int lvl){
        if(lvl == 1)
            stepMovePlatform = 3;
        else if (lvl == 2)
            stepMovePlatform = 4;
        if(!getMovePlatformR()){
            if((getX() - stepMovePlatform) < 0){
                setX(getX() + stepMovePlatform);
                setMovePlatformR(true);
            }else setX(getX() - stepMovePlatform);
        }
        else if(getMovePlatformR()){
            if ((getX() + stepMovePlatform) > 544){
                setX(getX() - stepMovePlatform);
                setMovePlatformR(false);
            }
            else setX(getX() + stepMovePlatform);
        }
    }
    public boolean getMovePlatformR(){
        return movePlatformR;
    }
    public void setMovePlatformR(boolean movePlatformR) {
        this.movePlatformR = movePlatformR;
    }


}
