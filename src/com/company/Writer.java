package com.company;

import javax.swing.*;
import java.awt.*;

public class Writer extends JComponent {
    private Doodle doodle = Game.doodleObj();
    private Score score = Game.getScore();
    private KeyController keyController = new KeyController();
    private GreenPlatform greenPlatform;
    private GreyPlatform greyPlatform;
    private BluePlatform bluePlatform =Game.getBlue();
    private static String namePackage = "/Images/";

    public void paint (Graphics g) {
        g.drawImage(new ImageIcon(Writer.class.getResource(namePackage + "grid.png")).getImage(), 0, 0, null);
        if (keyController.isLookR())
            g.drawImage(new ImageIcon(Writer.class.getResource(namePackage + "doodleR.png")).getImage(), doodle.getX(), doodle.getY(), null);
        else
            g.drawImage(new ImageIcon(Writer.class.getResource(namePackage + "doodleL.png")).getImage(), doodle.getX(), doodle.getY(), null);
        for (int i = 0; i < greenPlatform.getGreenPlatformArrayList().size(); ++i)
            g.drawImage(new ImageIcon(Writer.class.getResource(namePackage + greenPlatform.getGreenPlatformArrayList().get(i).getName())).getImage()
                    , greenPlatform.getGreenPlatformArrayList().get(i).getX() //x
                    , greenPlatform.getGreenPlatformArrayList().get(i).getY() //y
                    , this);
        for (int i = 0; i < bluePlatform.getBluePlatformArrayList().size(); ++i)
            g.drawImage(new ImageIcon(Writer.class.getResource(namePackage + bluePlatform.getBluePlatformArrayList().get(i).getName())).getImage()
                    , bluePlatform.getBluePlatformArrayList().get(i).getX() //x
                    , bluePlatform.getBluePlatformArrayList().get(i).getY() //y
                    , this);
        for (int i = 0; i < greyPlatform.getGreyPlatformArrayList().size(); i++){
            g.drawImage(new ImageIcon(Writer.class.getResource(namePackage + greyPlatform.getGreyPlatformArrayList().get(i).getName())).getImage()
                    , greyPlatform.getGreyPlatformArrayList().get(i).getX()
                    , greyPlatform.getGreyPlatformArrayList().get(i).getY()
                    ,this);
        }
        for (int i = 0; i < Monster.getMonsters().size(); i++)
            g.drawImage(new ImageIcon(Writer.class.getResource(namePackage + "bat.png")).getImage()
                    , Monster.getMonsters().get(i).getX()
                    , Monster.getMonsters().get(i).getY()
                    , this);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score.getScore(), 10, 40);
    }
}
