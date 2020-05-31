import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class SetupController {

    public static void run() {

        List<Ship> ships = new ArrayList<>();
        View view = new View();
        view.clearDisplay();
        
        Ocean ocean = new Ocean();

        Map<String, String> shipsDict = Util.createShipsDict();

        int counter = 0;
        String coords = "";
        String position = "";
        String coordsPattern = "[a-jA-J][1-9][0]*";
        String positionPattern = "(?i)[yn]";

        for (String key: shipsDict.keySet()) {

            view.clearDisplay();
            view.displayBoard(ocean.getMap());

                boolean validInput = false;

                while (!validInput) {
                    view.printMessage("\nEnter " + key + " coordinates (" + shipsDict.get(key) + "): ");          
                    coords = Util.validateUserInput(coordsPattern, coords, "\nEnter valid coordinates: ");

                    if (counter < 4) {
                        view.printMessage("\nIs horizontal? [Y/N]: ");
                        position = Util.validateUserInput(positionPattern, position, "\nType Y or N: ");            
                        position = Util.getPositionFromInput(position);
                        Ship ship = new Ship(key, position);

                        if (ocean.checkIfWithinBounds(ship, coords) && ocean.checkIfSpaceFreeForShip(ship, coords)) {
                            ships.add(ship);
                            validInput = true;
                        } else {
                            System.out.println("\nShips cannot be placed outside the board, overlap or touch");
                        }
                    } else {
                        Ship ship = new Ship(key, "horizontal");
                        if (!ocean.checkIfSpaceFreeForShip(ship, coords)) {
                            System.out.println("\nShips cannot overlap or touch");
                        } else {
                            ships.add(ship);
                            validInput = true;
                        }
                            
                    }
                }        

            ocean.addShip(ships.get(counter), coords);
            counter++;
        }

        view.clearDisplay();
        view.displayBoard(ocean.getMap());

    }
}