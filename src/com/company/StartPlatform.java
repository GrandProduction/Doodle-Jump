package com.company;

import java.util.ArrayList;

/**
 * Created by Дмитрий on 18.12.2016.
 */
public class StartPlatform {
    private static final int quantity = 15;

    private static ArrayList<GreenPlatform>greenPlatformsArray = new ArrayList<GreenPlatform>();

    public GreenPlatform StartPlatform(GreenPlatform greenPlatform){
        for (int i = 0; i < quantity; i++){
            GreenPlatform greenPlatform1 = new GreenPlatform();
            greenPlatformsArray.add(greenPlatform1.getGreenPlatformObject(542,625));
        }
        greenPlatform.setGreenPlatformArrayList(greenPlatformsArray);
        return greenPlatform;
    }

}
