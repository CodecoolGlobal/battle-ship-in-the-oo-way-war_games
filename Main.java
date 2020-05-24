import java.util.ArrayList;
import java.util.List;

import battleships.Ocean;
import battleships.Ship;
import battleships.View;

public class Main {

    public static void main(String[] args) {
        List<Ship> ships = new ArrayList<Ship>();
        View view = new View();

        Ocean ocean = new Ocean();
        ships.add(new Ship(3, "up"));
        ocean.addShip(ships.get(0), 5, 5);
        view.displayBoard(ocean.getMap());
    }
}