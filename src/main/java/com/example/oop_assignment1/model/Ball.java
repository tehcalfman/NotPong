package com.example.oop_assignment1.model;

public class Ball extends Position implements Resizable{
    private double radius;
    private int speed;
    private int speedX;
    private int speedY;
    private int speedUpInterval;

    public Ball(int s,int r){
        this.speed = s;
        this.radius = r;
        this.speedX = this.speed;
        this.speedY = this.speed;
    }

    public void move(){
        this.x += speedX;
        this.y += speedY;
    }

    //define setter
    public void setSpeed(int s){
        this.speed = s;
    }

    public void setSpeed(int s, int axis){
        this.speed = s * - 1;
        if (axis == 0){
            this.speedX = this.speed;
        }
        else if(axis == 1){
            this.speedY = this.speed;
        }
    }
    public void setSpeedUpInterval(int su){this.speedUpInterval = su;}

    //define getter
    public int getSpeed(){return this.speed;}
    public int getSpeedUpInterval(){return this.speedUpInterval;}

    @Override
    public void resizeX(double factor) {
        this.x = this.x*factor;
        this.radius = this.radius * factor;
    }

    @Override
    public void resizeY(double factor) {
        this.y = this.y*factor;
        this.radius = this.radius * factor;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }
}
