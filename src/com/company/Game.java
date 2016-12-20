package com.company;

import javax.swing.*;

/**
 * Created by Дмитрий on 18.12.2016.
 */
public class Game implements Runnable{

    private  static KeyController keyController = new KeyController();
    private static Doodle doodle = new Doodle();
    private static StartPlatform startPlatform = new StartPlatform();
    private static Score score;
    private static BluePlatform bluePlatform;
    private static Thread gameThread;
    private static Monster monster;

    private static int lvl = 0;
    private static int fallStep = 5;
    private static float delta = 0;
    private static final float speed = 0.11f;
    private static final int step = 15;

    private static boolean GravityTouchPlatform = false;
    private static boolean gameOver = false;

    public void start (){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run(){
        while (!gameOver){
            render();
            try {
                Thread.sleep(33);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            score();
            checkGameOver();
            update();
        }
        GameOver();
    }

    private void update(){
        doodle.setX(Move.movePlayer());
        goOnPlatform();
        checkTouchMonster();
        doodle.setYD(Gravity());
        GravityTouchPlatform = false;
    }

    private void render (){
        Move.movePanel();
        deletePlatdorm();
        level();
        Main.writer.repaint();
    }

    private boolean goOnPlatform() {
        if (doodle.isDoodleDown()) {
            for (int i = 0; i < startPlatform.getPlatforms().size(); ++i) {
                if (doodle.getX() > startPlatform.getPlatforms().get(i).getX()-40 && doodle.getX() < startPlatform.getPlatforms().get(i).getX() + 40) {
                    if (startPlatform.getPlatforms().get(i).getY()-2 < doodle.getY()+59 && startPlatform.getPlatforms().get(i).getY()+18 > doodle.getY()+59) {
                        repairePossionY();
                        GravityTouchPlatform = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }



    private void deletePlatdorm(){
        for (int i = 0; i < startPlatform.getPlatforms().size(); i++)
            if(startPlatform.getPlatforms().get(i).getY() > 650)
                startPlatform.getPlatforms().remove(i);
        for (int i = 0; i < monster.getMonsters().size();i++)
            if(monster.getMonsters().get(i).getY() > 650)
                monster.getMonsters().remove(i);
    }

    private static class Creator {
        static void createNewPlatform(int color) {
            int count = 0;
            for (int i = 0; i < startPlatform.getPlatforms().size(); i++)
                if (startPlatform.getPlatforms().get(i).getY() < 50)
                    count++;
            if (count < 2) {
                int xp = randomPositon(542);
                int yp = randomPositon(-20,-15);
                Platform platform;
                if (color == 0)
                    platform = new GreenPlatform(xp, yp, "p-green.png");
                else platform = new BluePlatform(xp, yp, "p-blue.png");
                startPlatform.getPlatforms().add(platform);
            }
        }
        static void createMonster() {
            int x = randomPositon(480);
            Monster monster1 = new Monster(x, -200);
            monster.getMonsters().add(monster1);
        }

        private static int randomPositon(int a){
            return (int) (Math.random() * a);
        }
        private static int randomPositon(int a, int b){
            return (int) (Math.random() * a + b);
        }
    }


    private static class Move{
         static void movePanel(){
            for (int i = 0; i < startPlatform.getPlatforms().size(); i++){
                startPlatform.getPlatforms().get(i).setY(startPlatform.getPlatforms().get(i).getY() + fallStep);
                if(startPlatform.getPlatforms().get(i).getName() == "p-blue.png")
                    startPlatform.getPlatforms().get(i).movePlatformRL(lvl);
            }
            for (int i = 0; i < monster.getMonsters().size();i++)
                monster.getMonsters().get(i).setY(monster.getMonsters().get(i).getY() + fallStep);
        }
         static int movePlayer() {
            int x = doodle.getX();
            if (keyController.isRight())
                x += step;
            if (keyController.isLeft())
                x -= step;
            if (x > 600)
                x = 0;
            if (x < -20)
                x = 600;
            return x;
        }
    }

    private void checkTouchMonster (){
        for (int i = 0; i < monster.getMonsters().size(); i++){
            if (doodle.getY() < monster.getMonsters().get(i).getY()+62  && doodle.getY()+55 > monster.getMonsters().get(i).getY() ) {
                if (monster.getMonsters().get(i).getX()+100 > doodle.getX() && monster.getMonsters().get(i).getX() < doodle.getX()+40) {
                    gameOver = true;
                }
            }
        }
    }

    private void level() {
        if (score.getScore() < 5000)
            lvl = 0;
        else if (score.getScore() >= 5000 && score.getScore() < 10000)
            lvl = 1;
        else if (score.getScore() >= 10000)
            lvl = 2;

        int randomChanceCreateMonster = (int)(Math.random()*1000);
        if (lvl == 0) {
            int randomTemp = (int) (Math.random() * 10);
            if (randomTemp < 9)
                Creator.createNewPlatform(0);
            else
                Creator.createNewPlatform(1);
            if(randomChanceCreateMonster < 5)
                Creator.createMonster();
        } else if (lvl == 1) {
            int randomTemp = (int) (Math.random() * 10);
            if (randomTemp < 5)
                Creator.createNewPlatform(0);
            else
                Creator.createNewPlatform(1);
            if(randomChanceCreateMonster >= 5 && randomChanceCreateMonster < 15)
                Creator.createMonster();
            fallStep = 6;
        } else if (lvl == 2) {
            int randomTemp = (int) (Math.random() * 10);
            if (randomTemp < 2)
                Creator.createNewPlatform(0);
            else
                Creator.createNewPlatform(1);
            if(randomChanceCreateMonster >= 15 && randomChanceCreateMonster < 30)
                Creator.createMonster();
            fallStep = 7;
        }
    }


    private void repairePossionY(){
        int possion = doodle.getY();
        doodle.setPossionY(possion);
    }



    private int Gravity() {
            int temp;
            if (GravityTouchPlatform)
                delta = speed;
            if (delta <= 3.6) {
                temp = (int) (doodle.getPossionY() + (Math.sin(delta) * (-150)));
            } else
                temp = (int) (doodle.getY() + delta * 5);
            delta += speed;
            return temp;
    }


    public static Doodle doodleObj(){
        return doodle;
    }

    private static void score(){
        score = new Score(fallStep);
    }

    public static Score getScore(){
        return score;
    }

    private static void checkGameOver() {
        if (doodle.getY() > 600) {
            GameOver();
            gameOver = true;
        }
    }
    private static void recordInFile(){
        String score = "" + Score.getScore();
        RecordInFile recordInFile = new RecordInFile(score);
    }

    private static void GameOver(){
       if(gameOver){
            JOptionPane.showMessageDialog(null, "Вы набрали " + (score.getScore()-fallStep) + " очков");
            recordInFile();
        }
    }
}
