import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class SetupController {

    public static List<Ocean> run() {

        List<Ship> ships = new ArrayList<>();
        List<Ocean> oceans = new ArrayList<>();
        String[] players = {"Player 1", "Player 2"};
        View view = new View();

        Map<String, String> shipsDict = Util.createShipsDict();

        int counter = 0;
        String coords = "";
        String position = "";
        String coordsPattern = "[a-jA-J][1-9][0]*";
        String positionPattern = "(?i)[yn]";

        for (int i = 0; i < 2; i++) {
            Ocean ocean = new Ocean();
            for (String key: shipsDict.keySet()) {
                
    
                view.clearDisplay();
                view.displayBoard(ocean.getMap());
    
                boolean validInput = false;
    
                while (!validInput) {
                    view.printMessage("\n" + players[i] + ": enter " + key + " coordinates (" + shipsDict.get(key) + "): ");
                    coords = Util.validateUserInput(coordsPattern, coords, "\nEnter valid coordinates: ");
    
                    view.printMessage("Is horizontal? [Y/N]: ");
                    position = Util.validateUserInput(positionPattern, position, "Type Y or N: ");            
                    position = Util.getPositionFromInput(position);
                    Ship ship = new Ship(key, position);
    
                    if (ocean.checkIfWithinBounds(ship, coords) && ocean.checkIfSpaceFreeForShip(ship, coords)) {
                        ships.add(ship);
                        validInput = true;
                    } else {
                        System.out.println("Ships cannot be placed outside the board, they cannot overlap or touch");
                    }
                }
    
                ocean.addShip(ships.get(counter), coords);
                
                view.clearDisplay();
                view.displayBoard(ocean.getMap());
                counter++;
            }
            oceans.add(ocean);
            Util.pressAnyKeyToContinue();
        }

        return oceans;
    }
}