package com.example.oop_assignment1;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MenuCanvas extends Canvas {

    public MenuCanvas(){
        super(1200,700);

        GraphicsContext gc = this.getGraphicsContext2D();
        drawName(gc);
        drawPlayerOneControls(gc);
        drawPlayerTwoControls(gc);
        drawPauseControls(gc);
    }

    public void drawName(GraphicsContext gc){
        gc.setFill(Color.RED);
        gc.setFont(Font.font("broadway",120));
        gc.fillText("NOT PONG | . |", 150, 350);
    }

    public void drawPlayerOneControls(GraphicsContext gc){
        gc.setFill(Color.GREY);
        gc.setFont(Font.font("arial black", 25));
        gc.fillText("Player One: A - UP Z - DOWN", 400, 400);
    }

    public void drawPlayerTwoControls(GraphicsContext gc){
        gc.setFill(Color.GREY);
        gc.setFont(Font.font("arial black", 25));
        gc.fillText("Player Two: K - UP M - DOWN", 395, 450);
    }

    public void drawPauseControls(GraphicsContext gc){
        gc.setFill(Color.GREY);
        gc.setFont(Font.font("arial black", 25));
        gc.fillText("Pause - P", 500, 500);
    }
}
