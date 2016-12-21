package com.company;

import java.util.ArrayList;

/**
 * Created by Дмитрий on 19.12.2016.
 */
public class GreenPlatform extends Platform {
    private static ArrayList<GreenPlatform> greenPlatformArrayList = new ArrayList<GreenPlatform>();
    private static String name = "p-green.png";
    private static GreenPlatform greenPlatform;

    public static GreenPlatform getGreenPlatformObject(int xRandom, int yRandom){
        GreenPlatform greenPlatform = new GreenPlatform();

        greenPlatform.getRandomPlatformX(xRandom);
        greenPlatform.getRandomPlatformY(yRandom);
        greenPlatform.setName(name);

        return greenPlatform;
    }

    public static void setGreenPlatformArrayList(ArrayList<GreenPlatform> greenPlatformArrayList) {
        GreenPlatform.greenPlatformArrayList = greenPlatformArrayList;
    }
    public static ArrayList<GreenPlatform> getGreenPlatformArrayList() {
        return greenPlatformArrayList;
    }
}