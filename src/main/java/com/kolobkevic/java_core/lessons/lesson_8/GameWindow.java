package com.kolobkevic.java_core.lessons.lesson_8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 640;
    private GameMap gameMap;

    public GameWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("TicTacToe");
        setResizable(false);
        JButton btnStart = new JButton("START");
        JButton btnExit = new JButton("EXIT");
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(1, 2));
        btnPanel.add(btnStart);
        btnPanel.add(btnExit);
        add(btnPanel, BorderLayout.SOUTH);
        gameMap = new GameMap();
        SettingsWindow settingsWindow = new SettingsWindow(this);
        add(gameMap, BorderLayout.CENTER);
        setVisible(true);
        btnStart.addActionListener(e -> settingsWindow.setVisible(true));
        btnExit.addActionListener(e -> System.exit(0));


    }

    public void startGame(int gameMode, int fieldSize, int winLength) {
        gameMap.startNewGame(gameMode, fieldSize, winLength);
        System.out.printf("Mode: %d, Size: %d length: %d\n", gameMode, fieldSize, winLength);
    }
}
