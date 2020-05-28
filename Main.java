import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {

    private static Scanner scan = new Scanner(System.in);
    // final private static int NUMBEROFSHIPS = 5;

    public static void main(String[] args) {
        List<Ship> ships = new ArrayList<Ship>();
        View view = new View();
        view.clearDisplay();
        
        Ocean ocean = new Ocean();

        Map<String, String> shipsDict = Util.createShipsDict();

        int counter = 0;
        for (String key: shipsDict.keySet()) {

            view.clearDisplay();
            view.displayBoard(ocean.getMap());

            view.printMessage("\nEnter " + key + " coordinates - " + shipsDict.get(key) + ": ");
            String coords = scan.nextLine();
            view.printMessage("Is horizontal [Y/N]: ");            
            String position = scan.nextLine();
            position = ocean.getPositionFromMessage(position);
            ships.add(new Ship(key, position));
            ocean.addShip(ships.get(counter), coords);
            counter++;

        }

    }

}    
        
    


