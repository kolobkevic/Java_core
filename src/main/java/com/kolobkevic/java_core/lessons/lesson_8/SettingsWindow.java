package com.kolobkevic.java_core.lessons.lesson_8;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 300;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String FIELD_SIZE_PREFIX = "Field size: ";
    private static final String WIN_LENGTH_PREFIX = "Win length: ";

    private GameWindow gameWindow;
    private JRadioButton playerVsAi;
    private JRadioButton playerVsPlayer;
    private JSlider sliderWinLength;
    private JSlider sliderFieldSize;

    public SettingsWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(gameWindow);
        setResizable(false);
        setTitle("Settings");
        setLayout(new GridLayout(10, 1));
        addGameMode();
        addFieldSize();
        JButton btnStart=new JButton("Start new game");
        btnStart.addActionListener(e -> submitSettings(gameWindow));
        add(btnStart);
    }

    private void addFieldSize() {
        JLabel labelFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel labelWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderWinLength = new JSlider(MIN_WIN_LENGTH, MAX_FIELD_SIZE, MIN_WIN_LENGTH);
        sliderFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = sliderFieldSize.getValue();
                labelFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                sliderWinLength.setMaximum(currentValue);
            }
        });
        sliderWinLength.addChangeListener(e -> labelWinLength.setText(WIN_LENGTH_PREFIX + sliderWinLength.getValue()));
        add(new JLabel("Choose field size"));
        add(labelFieldSize);
        add(sliderFieldSize);
        add(new JLabel("Choose win length"));
        add(labelWinLength);
        add(sliderWinLength);
    }

    private void addGameMode() {
        add(new JLabel("Choose game mode: "));
        playerVsAi = new JRadioButton("Player vs AI", true);
        playerVsPlayer = new JRadioButton("Player vs Player");
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(playerVsAi);
        gameMode.add(playerVsPlayer);
        add(playerVsAi);
        add(playerVsPlayer);
    }

    private void submitSettings(GameWindow gameWindow){
        int gameMode;
        if (playerVsAi.isSelected()){
            gameMode=GameMap.MODE_VS_AI;
        }
        else {
            gameMode=GameMap.MODE_VS_PLAYER;
        }
        int fieldSize=sliderFieldSize.getValue();
        int winLength=sliderWinLength.getValue();
        gameWindow.startGame(gameMode, fieldSize, winLength);
        setVisible(false);
    }
}
