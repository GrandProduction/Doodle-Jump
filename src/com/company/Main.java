package com.company;

import javax.swing.*;

public class Main {
    public static Writer writer = new Writer();
    private static Game game = new Game();

    private static void startGame() {
        Display.drawFrame();
        StartPlatform startPlatform = new StartPlatform();
        game.start();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        startGame();
    }
}
