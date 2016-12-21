package com.company;

import javax.swing.*;

public class Game implements Runnable {

    private static KeyController keyController = new KeyController();
    private static Doodle doodle = new Doodle();
    private static Score score;
    private static GreyPlatform greyPlatform = new GreyPlatform();
    private static StartPlatform startPlatform = new StartPlatform();
    private static GreenPlatform greenPlatform;
    private static BluePlatform bluePlatform = new BluePlatform();
    private static Thread gameThread;
    private static Monster monster = new Monster();

    private static int lvl = 0;
    private static int fallStep = 5;
    private static float delta = 0;
    private static final float speed = 0.11f;
    private static final int step = 15;

    private static boolean GravityTouchPlatform = false;
    private static boolean gameOver = false;

    public Game() {
        Display.drawFrame();
        greenPlatform = startPlatform.StartPlatform(greenPlatform);
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void run() {
        while (!gameOver) {
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
        restart();
    }
    private void update() {
        doodle.setX(Move.movePlayer());
        doodleTouchPlatform();
        checkTouchMonster();
        Move.movePanel();
        level();
        deletePlatform();
        int tempGr = Gravity();
        doodle.setYD(tempGr);
        GravityTouchPlatform = false;
    }
    private void render() {
        Main.writer.repaint();
    }
    private void doodleTouchPlatform() {
        if (doodle.isDoodleDown()) {
            for (int i = 0; i < greenPlatform.getGreenPlatformArrayList().size(); ++i) {
                if (doodle.getX() > greenPlatform.getGreenPlatformArrayList().get(i).getX() - 40 && doodle.getX() < greenPlatform.getGreenPlatformArrayList().get(i).getX() + 40) {
                    if (greenPlatform.getGreenPlatformArrayList().get(i).getY() - 2 < doodle.getY() + 59 && greenPlatform.getGreenPlatformArrayList().get(i).getY() + 18 > doodle.getY() + 59) {
                        repairPositionY();
                        GravityTouchPlatform = true;
                        break;
                    }
                }
            }
            for (int i = 0; i < bluePlatform.getBluePlatformArrayList().size(); ++i) {
                if (doodle.getX() > bluePlatform.getBluePlatformArrayList().get(i).getX() - 40 && doodle.getX() < bluePlatform.getBluePlatformArrayList().get(i).getX() + 40) {
                    if (bluePlatform.getBluePlatformArrayList().get(i).getY() - 2 < doodle.getY() + 59 && bluePlatform.getBluePlatformArrayList().get(i).getY() + 18 > doodle.getY() + 59) {
                        repairPositionY();
                        GravityTouchPlatform = true;
                        break;
                    }
                }
            }
            for (int i = 0; i < greyPlatform.getGreyPlatformArrayList().size(); ++i) {
                if (doodle.getX() > greyPlatform.getGreyPlatformArrayList().get(i).getX() - 40 && doodle.getX() < greyPlatform.getGreyPlatformArrayList().get(i).getX() + 40) {
                    if (greyPlatform.getGreyPlatformArrayList().get(i).getY() - 2 < doodle.getY() + 59 && greyPlatform.getGreyPlatformArrayList().get(i).getY() + 18 > doodle.getY() + 59) {
                        repairPositionY();
                        GravityTouchPlatform = true;
                        break;
                    }
                }
            }
        }
    }
    private void deletePlatform() {
        for (int i = 0; i < greenPlatform.getGreenPlatformArrayList().size(); i++)
            if (greenPlatform.getGreenPlatformArrayList().get(i).getY() > 616)
                greenPlatform.getGreenPlatformArrayList().remove(i);
        for (int i = 0; i < bluePlatform.getBluePlatformArrayList().size(); i++)
            if (bluePlatform.getBluePlatformArrayList().get(i).getY() > 616)
                bluePlatform.getBluePlatformArrayList().remove(i);
        for (int i = 0; i < greyPlatform.getGreyPlatformArrayList().size(); i++)
            if (greyPlatform.getGreyPlatformArrayList().get(i).getY() > 616)
                greyPlatform.getGreyPlatformArrayList().remove(i);
        for (int i = 0; i < monster.getMonsters().size(); i++)
            if (monster.getMonsters().get(i).getY() > 650)
                monster.getMonsters().remove(i);


    }
    private static class Creator {
        static void createNewPlatform(int color) {
            int count = 0;
            for (int i = 0; i < greenPlatform.getGreenPlatformArrayList().size(); i++)
                if (greenPlatform.getGreenPlatformArrayList().get(i).getY() < 70)
                    count++;
            for (int i = 0; i < bluePlatform.getBluePlatformArrayList().size(); i++)
                if (bluePlatform.getBluePlatformArrayList().get(i).getY() < 70)
                    count++;
            for (int i = 0; i < greyPlatform.getGreyPlatformArrayList().size(); i++)
                if (greyPlatform.getGreyPlatformArrayList().get(i).getY() < 70)
                    count++;
            if (count < 2) {
                if (color == 0) {
                    GreenPlatform greenPlatform1 = greenPlatform.getGreenPlatformObject(542, -20);
                    greenPlatform.getGreenPlatformArrayList().add(greenPlatform1);
                } else if (color == 1) {
                    BluePlatform bluePlatform1 = bluePlatform.getBluePlatformObject(542, -20);
                    bluePlatform.getBluePlatformArrayList().add(bluePlatform1);
                }else  if (color == 2){
                    GreyPlatform greyPlatform1 = greyPlatform.getGreyPlatformObject(542,-20);
                    greyPlatform.getGreyPlatformArrayList().add(greyPlatform1);
                }
            }
        }

        static void createMonster() {
            int x = randomPosition(480);
            Monster monster1 = new Monster();
            monster1.setY(-200);
            monster1.setX(x);
            monster.getMonsters().add(monster1);
        }

        private static int randomPosition(int a) {
            return (int) (Math.random() * a);
        }
    }
    private static class Move {
        static void movePanel() {
            for (int i = 0; i < greenPlatform.getGreenPlatformArrayList().size(); i++) {
                greenPlatform.getGreenPlatformArrayList().get(i).setY(greenPlatform.getGreenPlatformArrayList().get(i).getY() + fallStep);
            }
            for (int i = 0; i < bluePlatform.getBluePlatformArrayList().size(); i++) {
                bluePlatform.getBluePlatformArrayList().get(i).setY(bluePlatform.getBluePlatformArrayList().get(i).getY() + fallStep);
                bluePlatform.getBluePlatformArrayList().get(i).movePlatformRL(lvl);
            }
            for (int i = 0; i < greyPlatform.getGreyPlatformArrayList().size(); i++){
                greyPlatform.getGreyPlatformArrayList().get(i).setY(greyPlatform.getGreyPlatformArrayList().get(i).getY() + fallStep);
                greyPlatform.getGreyPlatformArrayList().get(i).movePlatformUD();
            }
            for (int i = 0; i < monster.getMonsters().size(); i++)
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
    private void checkTouchMonster() {
        for (int i = 0; i < monster.getMonsters().size(); i++)
            if (doodle.getY() < monster.getMonsters().get(i).getY() + 62 && doodle.getY() + 55 > monster.getMonsters().get(i).getY())
                if (monster.getMonsters().get(i).getX() + 100 > doodle.getX() && monster.getMonsters().get(i).getX() < doodle.getX() + 40)
                    gameOver = true;
    }
    private void level() {
        if (score.getScore() < 5000)
            lvl = 0;
        else if (score.getScore() >= 5000 && score.getScore() < 10000)
            lvl = 1;
        else if (score.getScore() >= 10000 && score.getScore() < 15000)
            lvl = 2;
        else if (score.getScore() >= 15000)
            lvl = 3;

        int randomChanceCreateMonster = (int) (Math.random() * 1000);
        int randomTemp = (int) (Math.random() * 10);

        if (lvl == 0) {
            if (randomTemp < 9)
                Creator.createNewPlatform(0);
            else
                Creator.createNewPlatform(1);
        } else if (lvl == 1) {
            if (randomTemp < 5)
                Creator.createNewPlatform(0);
            else
                Creator.createNewPlatform(1);
            if (randomChanceCreateMonster < 5)
                Creator.createMonster();
        } else if (lvl == 2) {
            if (randomTemp < 2)
                Creator.createNewPlatform(0);
            else
                Creator.createNewPlatform(1);
            if (randomChanceCreateMonster < 10)
                Creator.createMonster();
        }else if (lvl == 3){
            if (randomTemp < 9)
                Creator.createNewPlatform(1);
            else
                Creator.createNewPlatform(2);
            if (randomChanceCreateMonster < 15)
                Creator.createMonster();
        }
    }
    private void repairPositionY() {
        int position = doodle.getY();
        doodle.setPositionY(position);
    }
    private int Gravity() {
        int temp;
        if (GravityTouchPlatform)
            delta = speed;
        if (delta <= 3.4) {
            temp = (int) (doodle.getPositionY() + (Math.sin(delta) * (-150)));
        } else
            temp = (int) (doodle.getY() + delta * 5);
        delta += speed;
        return temp;
    }
    public static Doodle doodleObj() {
        return doodle;
    }
    private static void score() {
        score = new Score(fallStep);
    }
    public static Score getScore() {
        return score;
    }
    private static void checkGameOver() {
        if (doodle.getY() > 600) {
            GameOver();
            gameOver = true;
        }
    }
    private static void recordInFile() {
        String score = "" + Score.getScore();
        RecordInFile recordInFile = new RecordInFile(score);
    }
    private static void GameOver() {
        if (gameOver) {
            JOptionPane.showMessageDialog(null, "Вы набрали " + (score.getScore() - fallStep) + " очков");
            recordInFile();
        }
    }
    public static BluePlatform getBlue(){
        return bluePlatform;
    }
    private static void restart() {
        for(int i = 0; i < greenPlatform.getGreenPlatformArrayList().size(); i++)
            greenPlatform.getGreenPlatformArrayList().remove(i);
        for(int i = 0; i < bluePlatform.getBluePlatformArrayList().size(); i++)
            bluePlatform.getBluePlatformArrayList().remove(i);
        for(int i = 0; i < greyPlatform.getGreyPlatformArrayList().size(); i++)
            greyPlatform.getGreyPlatformArrayList().remove(i);
        for(int i = 0; i < monster.getMonsters().size(); i++)
            monster.getMonsters().remove(i);
        score.setScore(0);
        doodle.setPositionX(250);
        doodle.setPositionY(400);
        doodle.setX(250);
        doodle.setY(400);
        doodle.setDoodleDown(true);
        GravityTouchPlatform = false;
        gameOver = false;
        delta = 0;
        Game game = new Game();
    }
}
