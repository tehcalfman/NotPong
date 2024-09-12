package com.example.oop_assignment1;

import com.example.oop_assignment1.controller.MenuListener;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class PongMenu{
    private Stage stage;
    private Scene scene;
    private final Menu menu = new Menu("Menu");
    private final Menu settings = new Menu("Settings");
    private final MenuItem play = new MenuItem("Play");
    private final MenuItem exit = new MenuItem("Exit");

    private final MenuItem changeWinScore = new MenuItem("Winning Score");

    private final MenuItem changePlayerOne = new MenuItem("Player 1 Name");

    private final MenuItem changePlayerTwo = new MenuItem("Player 2 Name");
    private final MenuItem changeBallSpeed = new MenuItem("Change Ball Speed");
    private final MenuItem changeBounceInterval = new MenuItem("Speed Up Interval");
    private final MenuItem changeRacketHeight = new MenuItem("Change Racket Height");
    private final MenuItem changeRacketWidth = new MenuItem("Change Racket Width");

    private final MenuItem load = new MenuItem("Load Game");

    private final MenuBar menBar = new MenuBar();

    private MenuListener menuListener;
    public PongMenu(MenuListener menuListener, Stage st, Scene sc){
        this.menuListener = menuListener;
        this.stage = st;
        this.scene = sc;
        menu.getItems().addAll(play,load,exit);

        settings.getItems().addAll(changePlayerOne,changePlayerTwo,changeWinScore,changeBallSpeed,changeBounceInterval,changeRacketHeight,changeRacketWidth);

        menBar.getMenus().addAll(menu,settings);

        handleClicking();
    }

    private void handleClicking(){
        play.setOnAction(e->{menuListener.changeToGame(stage,scene);});
        exit.setOnAction(e->menuListener.setExit());
        changeWinScore.setOnAction(e->{menuListener.setScoreLimit();});
        changePlayerOne.setOnAction(e->{menuListener.setPlayerOneName();});
        changePlayerTwo.setOnAction(e->{menuListener.setPlayerTwoName();});
        changeBallSpeed.setOnAction(e->{menuListener.setBallSpeed();});
        changeBounceInterval.setOnAction(e->menuListener.setSpeedInterval());
        changeRacketHeight.setOnAction(e->menuListener.setRacketHeight());
        changeRacketWidth.setOnAction(e->menuListener.setRacketThickness());
        load.setOnAction(e->menuListener.load());
    }

    public MenuBar getMenuBar(){
        return this.menBar;
    }
    public void setMenuListener(MenuListener ml){
        this.menuListener = menuListener;
    }

    public MenuListener getMenuListener(){
        return this.menuListener;
    }

    public void setStage(Stage st){
        this.stage = st;
    }

    public Stage getStage(){
        return this.stage;
    }

    public void setScene(Scene sc){
        this.scene = sc;
    }

    public Scene getScene(){
        return this.scene;
    }
}
