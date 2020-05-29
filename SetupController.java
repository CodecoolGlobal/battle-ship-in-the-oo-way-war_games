import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class SetupController {

    private static Scanner scan = new Scanner(System.in);

    public static void run() {

        List<Ship> ships = new ArrayList<Ship>();
        View view = new View();
        view.clearDisplay();
        
        Ocean ocean = new Ocean();

        Map<String, String> shipsDict = Util.createShipsDict();

        int counter = 0;
        for (String key: shipsDict.keySet()) {

            view.clearDisplay();
            view.displayBoard(ocean.getMap());

            view.printMessage("\nEnter " + key + " coordinates (" + shipsDict.get(key) + "): ");
            String coords = scan.nextLine();

            if (counter < 4) {
                view.printMessage("Is horizontal [Y/N]: ");
                String position = scan.nextLine();
                position = ocean.getPositionFromInput(position);
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