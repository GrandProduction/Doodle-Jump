package com.company;

import java.util.ArrayList;

/**
 * Created by Дмитрий on 21.12.2016.
 */
public class GreyPlatform extends BluePlatform{
    private static ArrayList<GreyPlatform> greyPlatformArrayList = new ArrayList<GreyPlatform>();
    private static String name = "p-grey.png";
    private static GreyPlatform greyPlatform;
    private int time = 0;
    private static int stepMovePlatform = 2;

    public static GreyPlatform getGreyPlatformObject(int xRandom, int yRandom){
        GreyPlatform greyPlatform = new GreyPlatform();

        greyPlatform.getRandomPlatformX(xRandom);
        greyPlatform.getRandomPlatformY(yRandom);
        greyPlatform.setName(name);

        return greyPlatform;
    }

    public void movePlatformUD(){
        time++;
            if(time < 20){
                setY(getY() + stepMovePlatform);
                setMovePlatformP(true);
            }else {
                setY(getY() - stepMovePlatform);
                setMovePlatformP(false);
                time++;
                if (time > 40)
                    time = 0;
            }

    }

    public static ArrayList<GreyPlatform> getGreyPlatformArrayList() {
        return greyPlatformArrayList;
    }
    public static void setGreyPlatformArrayList(ArrayList<GreyPlatform> greyPlatformArrayList) {
        GreyPlatform.greyPlatformArrayList = greyPlatformArrayList;
    }
}
