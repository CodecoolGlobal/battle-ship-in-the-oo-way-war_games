package Battleships;

public class Ship {
    int x;
    int y;
    int length;
    String direction;

    public Ship(int length, String direction){
        this.length = length;
        this.direction = direction;
    }
}