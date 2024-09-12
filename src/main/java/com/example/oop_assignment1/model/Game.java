package com.example.oop_assignment1.model;

import com.example.oop_assignment1.PongMenu;

public class Game implements Resizable {

    private Player playerOne;
    private Player playerTwo;
    private Ball ball;
    private int winScore;

    private double dimensionX;
    private double dimensionY;

    public Game(){

    }

    //define setters
    public void setWinScore(int winScore) {
        this.winScore = winScore;
    }

    public void setPlayerOne(Player pOne){
        this.playerOne = pOne;
    }

    public void setPlayerTwo(Player pTwo){
        this.playerTwo = pTwo;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    //define getters
    public int getWinScore() {
        return winScore;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Ball getBall() {
        return ball;
    }

    @Override
    public void resizeX(double factor) {
        playerOne.getRacket().resizeX(factor);
        playerTwo.getRacket().resizeX(factor);
        ball.resizeX(factor);
    }

    @Override
    public void resizeY(double factor) {
        playerOne.getRacket().resizeY(factor);
        playerTwo.getRacket().resizeY(factor);
        ball.resizeY(factor);
    }

    public double getDimensionX() {
        return dimensionX;
    }

    public void setDimensionX(double dimensionX) {
        this.dimensionX = dimensionX;
    }

    public double getDimensionY() {
        return dimensionY;
    }

    public void setDimensionY(double dimensionY) {
        this.dimensionY = dimensionY;
    }
}
