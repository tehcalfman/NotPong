package com.example.oop_assignment1.model;

import java.io.Serializable;

public class Save implements Serializable {
    private Player playerOne;
    private Player playerTwo;
    private Ball ball;

    public Save(Player p1, Player p2, Ball b){
        this.playerOne = p1;
        this.playerTwo = p2;
        this.ball = b;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }
}
