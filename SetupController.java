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

            view.printMessage("\nEnter " + key + " coordinates (" + shipsDict.get(key) + "): ");                  
            coords = Util.validateUserInput(coordsPattern, coords, "\nEnter valid coordinates: ");

            if (counter < 4) {
                view.printMessage("\nIs horizontal? [Y/N]: ");
                position = Util.validateUserInput(positionPattern, position, "\nType Y or N: ");            
                position = Util.getPositionFromInput(position);
                ships.add(new Ship(key, position));

            } else {
                ships.add(new Ship(key, "horizontal"));
            }        
            ocean.addShip(ships.get(counter), coords);
            counter++;
        }

    view.clearDisplay();
    view.displayBoard(ocean.getMap());

    }
    
}