package com.example.oop_assignment1.controller;

import com.example.oop_assignment1.NotPongCanvas;
import com.example.oop_assignment1.model.Ball;
import com.example.oop_assignment1.model.Game;


public class BallManager implements Runnable{
    private Game game;
    private NotPongCanvas canvas;

    public BallManager(Game g, NotPongCanvas c){
        this.game = g;
        this.canvas = c;
    }

    @Override
    public void run() {
        Ball ball = game.getBall();
        int counter=0;
        while(true){
            counter++;
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ball.move();
            if (ball.getX()<10) {
                game.getPlayerTwo().setPoints(game.getPlayerTwo().getPoints() + 1);
                ball.setX(600);
                ball.setY(360);
                if(game.getPlayerTwo().getPoints() == game.getWinScore()){
                    ball.setSpeed(0);
                }
            }
            if (ball.getX()>game.getDimensionX()-ball.getRadius()) {
                game.getPlayerOne().setPoints(game.getPlayerOne().getPoints() + 1);
                ball.setX(600);
                ball.setY(360);
                if(game.getPlayerOne().getPoints() == game.getWinScore()){
                    ball.setSpeed(0);
                }
            }
                // CODE to CHECK BOUNCING WITH RACKET
            if (ball.getX() >= game.getPlayerTwo().getRacket().getX() - game.getPlayerTwo().getRacket().getThickness() && ball.getY() >= game.getPlayerTwo().getRacket().getY() && ball.getY() <= game.getPlayerTwo().getRacket().getY() + game.getPlayerTwo().getRacket().getHeight()){
                int currentSpeed = ball.getSpeed();
                ball.setSpeed(currentSpeed, 0);
            }

            if (ball.getX() <= game.getPlayerOne().getRacket().getX() + game.getPlayerOne().getRacket().getThickness() && ball.getY() >= game.getPlayerOne().getRacket().getY() && ball.getY() <= game.getPlayerOne().getRacket().getY() + game.getPlayerOne().getRacket().getHeight()){
                int currentSpeed = ball.getSpeed();
                ball.setSpeed(currentSpeed, 0);
            }

            if (ball.getY()<10){
                int currentSpeed = ball.getSpeed();
                ball.setSpeed(currentSpeed, 1);
            }
            if (ball.getY()> game.getDimensionY()- ball.getRadius()){
                int currentSpeed = ball.getSpeed();
                ball.setSpeed(currentSpeed, 1);
            }
            canvas.drawGame(game);
        }
    }
}
