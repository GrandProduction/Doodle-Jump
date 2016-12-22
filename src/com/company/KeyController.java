package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter {

    private static boolean right = false;
    private static boolean left = false;

    private static boolean lookR = false;


    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                right = true;
                setLookR(true);
                break;
            case KeyEvent.VK_LEFT:
                left = true;
                setLookR(false);
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_LEFT:
                left = false;
                break;
        }
    }

    public static boolean isLeft() {
        return left;
    }
    public static void setLeft(boolean left) {
        KeyController.left = left;
    }
    public static boolean isRight() {
        return right;
    }
    public static void setRight(boolean right) {
        KeyController.right = right;
    }
    public static boolean isLookR() {
        return lookR;
    }
    public static void setLookR(boolean lookR) {
        KeyController.lookR = lookR;
    }
}