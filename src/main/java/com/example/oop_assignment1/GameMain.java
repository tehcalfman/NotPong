package com.example.oop_assignment1;

//Title:Not Pong
//Name: Niall
//Student ID: R00199396

import com.example.oop_assignment1.controller.BallManager;
import com.example.oop_assignment1.controller.GameController;
import com.example.oop_assignment1.controller.KeyboardListener;
import com.example.oop_assignment1.controller.MenuListener;
import com.example.oop_assignment1.model.Ball;
import com.example.oop_assignment1.model.Game;
import com.example.oop_assignment1.model.Player;
import com.example.oop_assignment1.model.Racket;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class GameMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //define game
        Game notPong = new Game();

        //define the Controller
        GameController gameController = new GameController();
        gameController.setGame(notPong);

        gameController.getGame().setDimensionX(1200);
        gameController.getGame().setDimensionY(700);
        gameController.getGame().setWinScore(3);

        //define the rackets
        Racket racketPlayerOne = new Racket(225,40);
        Racket racketPlayerTwo = new Racket(225,40);

        //define players
        Player playerOne = new Player("One",racketPlayerOne);
        Player playerTwo = new Player("Two",racketPlayerTwo);

        gameController.getGame().setPlayerOne(playerOne);
        gameController.getGame().setPlayerTwo(playerTwo);

        racketPlayerOne.setX(200);
        racketPlayerOne.setY(275);

        racketPlayerTwo.setX(1000);
        racketPlayerTwo.setY(275);

        //define the ball
        Ball ping = new Ball(1,40);
        ping.setX(600);
        ping.setY(360);

        gameController.getGame().setBall(ping);

        //set Title of the window
        stage.setTitle("Not Pong");

        //Game Layout
        //create a layout of the objects using a border pane
        BorderPane gameSet = new BorderPane();

        //create the game canvas
        NotPongCanvas gameCanvas = new NotPongCanvas(1200,700);
        gameSet.setCenter(gameCanvas);

        KeyboardListener keyboardListener = new KeyboardListener(gameController.getGame(), gameCanvas);
        gameCanvas.setOnKeyPressed(keyboardListener);
        gameCanvas.setOnKeyTyped(keyboardListener);
        gameCanvas.setFocusTraversable(true);

        BallManager ballManager = new BallManager(gameController.getGame(), gameCanvas);
        Thread thread = new Thread(ballManager);
        thread.start();
        Thread.yield();

        //Create the Scenes
        //generate the game's scene
        Scene gameScene = new Scene(gameSet, 1200, 700);

        //Menu Layout
        //create a layout with a vbox centered on the screen
        BorderPane menuBox = new BorderPane();

        MenuCanvas mencan = new MenuCanvas();
        MenuListener menuListener = new MenuListener(gameController.getGame());
        PongMenu gameMenu = new PongMenu(menuListener, stage, gameScene);
        menuBox.setTop(gameMenu.getMenuBar());
        menuBox.setCenter(mencan);

        //generate the menu scene
        Scene menuScene = new Scene(menuBox, 1200, 700);

        stage.widthProperty().addListener(observable -> {
            double factor= stage.getWidth()/gameController.getGame().getDimensionX();
            System.out.println("Width changed " + stage.getWidth()+" "+factor);
            gameController.getGame().setDimensionX(stage.getWidth());
            gameController.getGame().resizeX(factor);
            gameCanvas.drawGame(gameController.getGame());
        });
        stage.heightProperty().addListener(observable -> {
            double factor= stage.getHeight()/gameController.getGame().getDimensionY();
            System.out.println("Height changed " + stage.getHeight()+" "+factor);
            gameController.getGame().setDimensionY(stage.getHeight());
            gameController.getGame().resizeY(factor);
            gameCanvas.drawGame(gameController.getGame());
        });

        gameCanvas.drawGame(gameController.getGame());

        stage.setScene(menuScene); //put the scene on the stage
        stage.show();//show the stage
    }

    public static void main(String[] args) {
        launch();
    }
}