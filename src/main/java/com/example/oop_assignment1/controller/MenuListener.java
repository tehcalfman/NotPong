package com.example.oop_assignment1.controller;

import com.example.oop_assignment1.model.Game;
import com.example.oop_assignment1.model.Save;
import javafx.application.Platform;
import javafx.scene.control.TextInputDialog;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Optional;

public class MenuListener {
    private Game game;
    private File file;
    private String fileName;

    public MenuListener(Game game){
        this.game = game;
    }

    //actions to take when buttons are pressed
    //exit
    public void setExit(){
        System.out.println("EXIT");
        Platform.exit();
    }

    //set the Win Score
    public void setScoreLimit(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Winning Score");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(string -> {game.setWinScore(Integer.parseInt(result.get()));
        });
    }

    //PLayer one name
    public void setPlayerOneName(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Player One Name");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(string -> {game.getPlayerOne().setName(result.get());
        });
    }

    public void setPlayerTwoName(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Player Two Name");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(string -> {game.getPlayerTwo().setName(result.get());
            System.out.println(game.getPlayerTwo().getName());
        });
    }

    public void setBallSpeed(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Ball Speed");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(string -> {game.getBall().setSpeed(Integer.parseInt(result.get()));
        });
    }

    public void setSpeedInterval(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Speed Up Interval");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(string -> {game.getBall().setSpeedUpInterval(Integer.parseInt(result.get()));
        });
    }

    public void setRacketHeight(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Racket Height");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(string -> {
            game.getPlayerOne().getRacket().setHeight(Integer.parseInt(result.get()));
            game.getPlayerTwo().getRacket().setHeight(Integer.parseInt(result.get()));
        });
    }

    public void setRacketThickness(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Racket Thickness");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(string -> {
            game.getPlayerOne().getRacket().setThickness(Integer.parseInt(result.get()));
            game.getPlayerTwo().getRacket().setThickness(Integer.parseInt(result.get()));
        });
    }

    public void load(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("File Input");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(string -> {
            try{
                FileInputStream file = new FileInputStream(String.valueOf(result));
                ObjectInputStream in = new ObjectInputStream(file);

                Save loader = (Save)in.readObject();

                in.close();
                file.close();

                System.out.println("\nFile Loaded\n");

                game.setPlayerOne(loader.getPlayerOne());
                game.setPlayerTwo(loader.getPlayerTwo());
                game.setBall(loader.getBall());
                game.getBall().setX(loader.getBall().getX());
                game.getBall().setY(loader.getBall().getY());
                game.getPlayerOne().getRacket().setY(loader.getPlayerOne().getRacket().getY());
                game.getPlayerTwo().getRacket().setY(loader.getPlayerTwo().getRacket().getY());
            }
            catch(IOException ex){
                System.out.println("IOException is caught");
            }
            catch(ClassNotFoundException ex){
                System.out.println("ClassNotFoundException is caught");
            }
        });
    }

    //Change to play screen
    public void changeToGame(Stage stage, Scene scene){
        stage.setScene(scene);
    }

    //getters and setters
    public Game getGame(){
        return this.game;
    }

    public void setGame(Game g){
        this.game = g;
    }
}
