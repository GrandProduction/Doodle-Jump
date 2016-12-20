package com.company;

import java.util.ArrayList;

/**
 * Created by Дмитрий on 18.12.2016.
 */
public class StartPlatform {
    private static final int quantity = 15;

    private static ArrayList<Platform> platforms;

    public StartPlatform() {

        platforms = new ArrayList<Platform>();
        for (int i = 0; i < quantity; i++){
            Platform plat1 = randomPlatform();
            platforms.add(plat1);
        }
    }

    private Platform randomPlatform(){
        int yp = (int) (Math.random() * 625);
        int xp = (int) (Math.random() * 542);

        Platform plat1 = new GreenPlatform(xp, yp, "p-green.png");
        return plat1;
    }


    public static ArrayList<Platform> getPlatforms() {
        return platforms;
    }

    public static void setPlatforms(ArrayList<Platform> platforms) {
        StartPlatform.platforms = platforms;
    }
}
