package com.example.oop_assignment1;

import com.example.oop_assignment1.model.Ball;
import com.example.oop_assignment1.model.Game;
import com.example.oop_assignment1.model.Player;
import com.example.oop_assignment1.model.Racket;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class NotPongCanvas extends Canvas{
    public NotPongCanvas(double width, double height){
        super(width,height);
    }
    public void drawGame(Game game){
        resetSize(game);
        GraphicsContext gc = this.getGraphicsContext2D();
        drawBackground(gc);
        drawBall(gc,game.getBall());
        drawRacket(gc,game.getPlayerOne().getRacket());
        drawRacket(gc,game.getPlayerTwo().getRacket());
        drawName(gc,game.getPlayerOne(),400,40);
        drawName(gc,game.getPlayerTwo(),700,40);
        drawScore(gc,game.getPlayerOne(),360,40);
        drawScore(gc,game.getPlayerTwo(),800,40);
    }

    private void drawBall(GraphicsContext gc, Ball ball){
        gc.setFill(Color.WHITE);
        gc.fillOval(ball.getX(), ball.getY(),ball.getRadius(),ball.getRadius());
    }

    private void drawRacket(GraphicsContext gc, Racket racket){
        //System.out.println("DRAW Racket "+ racket.getX()+","+racket.getY()+","+racket.getThickness()+"x"+racket.getHeight());
        gc.setFill(Color.WHITE);
        gc.fillRect(racket.getX(), racket.getY(), racket.getThickness(), racket.getHeight());
    }

    private void drawName(GraphicsContext gc, Player player, int x, int y){
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font("impact",40));
        gc.fillText(player.getName(),x,y);
    }

    private void drawScore(GraphicsContext gc, Player player, int x, int y){
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font("impact",40));
        gc.fillText(Integer.toString(player.getPoints()),x,y);
    }

    private void resetSize(Game game){
        this.setWidth(game.getDimensionX());
        this.setHeight(game.getDimensionY());
    }

    private void drawBackground(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.clearRect(0, 0, this.getWidth(), this.getHeight());
        gc.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
}