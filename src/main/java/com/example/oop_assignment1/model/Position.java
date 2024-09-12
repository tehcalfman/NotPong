package com.example.oop_assignment1.model;

public class Position {
    protected double x;
    protected double y;

    public Position(){

    }

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(double x){
        this.x = x;
    }

    public double getX(){
        return this.x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

}
