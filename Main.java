package Battleships;

import java.util.ArrayList;

public class Main {
    static Ocean ocean;
    static ArrayList<Ship> ships;
    static View view;

    public static void main(String[] args) {
        ships = new ArrayList<Ship>();
        view = new View();

        ocean = new Ocean();
        ships.add(new Ship(3, "up"));
        ocean.addShip(ships.get(0), 5, 5);
        view.displayBoard(ocean.getMap());
    }
}