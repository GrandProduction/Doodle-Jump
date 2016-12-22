package com.company;

import javax.swing.*;

public class Display {
    private static JFrame frame = new JFrame();

    private static final int width = 600;
    private static final int height = 600;
    private static String nameGame = "Doodle-Jump";

    public static void drawFrame() {
        frame.setTitle(nameGame);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon(Display.class.getResource("/Images/grid.png")).getImage());
        frame.add(Main.writer);
        frame.addKeyListener(new KeyController());
        frame.setVisible(true);
    }
}
