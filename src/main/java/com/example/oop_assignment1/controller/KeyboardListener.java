package com.example.oop_assignment1.controller;

import com.example.oop_assignment1.NotPongCanvas;
import com.example.oop_assignment1.model.Player;
import com.example.oop_assignment1.model.Save;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import com.example.oop_assignment1.model.Game;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class KeyboardListener implements EventHandler<KeyEvent> {
    private final Game game;
    private final NotPongCanvas canvas;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private Alert pauseAlert = new Alert(Alert.AlertType.INFORMATION);

    private int pause;

    public KeyboardListener(Game g, NotPongCanvas can){
        this.game = g;
        this.canvas = can;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        System.out.println(keyEvent);
        KeyCode key = keyEvent.getCode();
        if (KeyCode.A.equals(key)){
            if(game.getPlayerOne().getRacket().getY() > 0) {
                game.getPlayerOne().getRacket().moveUp();
            }
        }
        if (KeyCode.Z.equals(key)){
            if(game.getPlayerOne().getRacket().getY() < game.getDimensionY() - game.getPlayerOne().getRacket().getHeight()) {
                game.getPlayerOne().getRacket().moveDown();
            }
        }
        if (KeyCode.K.equals(key)){
            if(game.getPlayerTwo().getRacket().getY() > 0) {
                game.getPlayerTwo().getRacket().moveUp();
            }
        }
        if (KeyCode.M.equals(key)){
            if(game.getPlayerTwo().getRacket().getY() < game.getDimensionY() - game.getPlayerTwo().getRacket().getHeight()) {
                game.getPlayerTwo().getRacket().moveDown();
            }
        }
        if (KeyCode.P.equals(key)){
            pause += 1;
            while(pause % 2 == 0){
                double playerOnePauseY = game.getPlayerOne().getRacket().getY();
                double playerTwoPauseY = game.getPlayerTwo().getRacket().getY();
                double ballPauseX = game.getBall().getX();
                double ballPauseY = game.getBall().getY();

                pauseAlert.setContentText("Game Paused");
                pauseAlert.show();

                game.getPlayerOne().getRacket().setY(playerOnePauseY);
                game.getPlayerTwo().getRacket().setY(playerTwoPauseY);
                game.getBall().setY(ballPauseY);
                game.getBall().setX(ballPauseX);
            }
            pause = 1;
        }
        if (KeyCode.T.equals(key)){
            Save save = new Save(game.getPlayerOne(),game.getPlayerTwo(),game.getBall());
            String filename = "pongSave.ser";
            try{
                FileOutputStream file = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(file);

                out.writeObject(save);
                out.close();
                file.close();
            }
            catch(IOException ex){
                System.out.println("IOException is caught");
            }
            alert.setContentText("Save Made");
            alert.show();
        }
        canvas.drawGame(game);
    }
}
