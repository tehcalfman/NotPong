package com.example.oop_assignment1.model;

//Define a player
public class Player {
    private String name;
    private int points;

    private Racket racket;

    //define a constructor
    public Player(String name, Racket r){
        this.name = name;
        this.racket = r;
    }

    //define setters
    public void setName(String name){
        this.name = name;
    }
    public void setPoints(int p){this.points = p;}
    public void setRacket(Racket r){
        this.racket = r;
    }
    //define getters
    public String getName() {return this.name;}
    public int getPoints(){return this.points;}
    public Racket getRacket(){
        return this.racket;
    }
}
