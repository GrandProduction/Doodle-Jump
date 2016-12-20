package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Дмитрий on 18.12.2016.
 */
public class Writer extends JComponent {
    private Doodle doodle = Game.doodleObj();
    private Score score = Game.getScore();
    private KeyController keyController = new KeyController();
    private GreenPlatform greenPlatform;
    private static String namePackage = "/Images/";

    public void paint (Graphics g){
        g.drawImage(new ImageIcon(Writer.class.getResource(namePackage +"grid.png")).getImage(), 0 , 0, null);

        if(keyController.isLookR())
        g.drawImage(new ImageIcon(Writer.class.getResource(namePackage + "doodleR.png")).getImage(), doodle.getX(), doodle.getY(), null);
        else g.drawImage(new ImageIcon(Writer.class.getResource(namePackage + "doodleL.png")).getImage(), doodle.getX(), doodle.getY(), null);
        for(int i = 0; i <  StartPlatform.getPlatforms().size(); ++i)
            g.drawImage(new ImageIcon(Writer.class.getResource(namePackage + StartPlatform.getPlatforms().get(i).getName())).getImage()
                                                                , StartPlatform.getPlatforms().get(i).getX()
                                                                , StartPlatform.getPlatforms().get(i).getY()
                                                                , this);

        for (int i = 0; i < Monster.getMonsters().size(); i++)
            g.drawImage(new ImageIcon(Writer.class.getResource(namePackage + "bat.png")).getImage()
                                                                , Monster.getMonsters().get(i).getX()
                                                                , Monster.getMonsters().get(i).getY()
                                                                , this);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score.getScore() , 10, 40);
    }
}
