package com.company;

import java.util.ArrayList;

/**
 * Created by Дмитрий on 19.12.2016.
 */
public class BluePlatform extends Platform{
    private static ArrayList<BluePlatform> bluePlatformArrayList = new ArrayList<BluePlatform>();
    private static String name = "p-blue.png";
    private boolean movePlatformP = false;
    private int stepMovePlatform;

    public static BluePlatform getBluePlatformObject(int xRandom, int yRandom){
        BluePlatform bluePlatform = new BluePlatform();

        bluePlatform.getRandomPlatformX(xRandom);
        bluePlatform.getRandomPlatformY(yRandom);
        bluePlatform.setName(name);

        return bluePlatform;
    }

    public void movePlatformRL(int lvl){

        if(lvl == 0)
            stepMovePlatform = 2;
        else if (lvl == 1)
            stepMovePlatform = 3;
        else stepMovePlatform = 4;
        if(!getMovePlatformP()){
            if((getX() - stepMovePlatform) < 0){
                setX(getX() + stepMovePlatform);
                setMovePlatformP(true);
            }else setX(getX() - stepMovePlatform);
        }
        else if(getMovePlatformP()){
            if ((getX() + stepMovePlatform) > 544){
                setX(getX() - stepMovePlatform);
                setMovePlatformP(false);
            }
            else setX(getX() + stepMovePlatform);
        }
    }

    public ArrayList<BluePlatform> getBluePlatformArrayList() {
        return bluePlatformArrayList;
    }
    public void setBluePlatformArrayList(ArrayList<BluePlatform> bluePlatformArrayList) {
        this.bluePlatformArrayList = bluePlatformArrayList;
    }
    public boolean getMovePlatformP(){
        return movePlatformP;
    }
    public void setMovePlatformP(boolean movePlatformP) {
        this.movePlatformP = movePlatformP;
    }
}
