package Battleships;

import java.util.ArrayList;


public class Square {

    private boolean isHit;
    private Ship ship;

    public Square() {
        this.isHit = false;
    }

    public boolean getIsHit(){
        return isHit;
    }

    public Ship getShip(){
        return ship;
    }

    public void markHit() {
        this.isHit = true;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public boolean hasShip(){
        if(this.ship != null){
            return true;
        }else return false;
    }

    @Override
    public String toString() {
        return hasShip() ? "X" : " "; 
    }
}