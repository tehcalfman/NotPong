package com.example.oop_assignment1.model;


public class Racket extends Position implements Resizable {
    private double height;
    private double thickness;

    public Racket(int h, int t){
        this.height = h;
        this.thickness = t;
    }

    public void moveUp(){
        this.y = this.y - 5;
    }

    public void moveDown(){
        this.y = this.y + 5;
    }

    //define setters
    public void setHeight(int h){
        this.height = h;
    }

    public void setThickness(int t){
        this.thickness = t;
    }

    //define getters
    public double getHeight(){
        return this.height;
    }

    public double getThickness(){
        return this.thickness;
    }

    @Override
    public void resizeX(double factor) {
        this.x = this.x*factor;
        this.thickness = this.thickness * factor;
    }

    @Override
    public void resizeY(double factor) {
        this.y = this.y*factor;
        this.height = this.height*factor;
    }
}
