package com.example.oop_assignment1.controller;

import com.example.oop_assignment1.model.Game;

public class GameController {
    private Game game;

    public GameController(){

    }

    public Game getGame(){
        return this.game;
    }

    public void setGame(Game g){
        this.game = g;
    }


}
