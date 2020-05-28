import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    private static Scanner scan = new Scanner(System.in);
    final private static int NUMBEROFSHIPS = 5;

    public static void main(String[] args) {
        List<Ship> ships = new ArrayList<Ship>();
        View view = new View();
        view.clearDisplay();
        
        Ocean ocean = new Ocean();
        String[] setup = {"\nEnter ship x coordinate (row): ", "\nEnter ship y coordinate (column): ", "\nPosition vertical or horizontal: ", "\nShip type: Carrier/CA (occupies 5 squares), Battleship/B (4), Cruiser/CR (3), Submarine/S (2), Destroyer/D (1): "};
        
        for (int i = 0; i < NUMBEROFSHIPS; i++) {
            view.clearDisplay();
            view.displayBoard(ocean.getMap());
            ArrayList<String> userInput = new ArrayList<String>();

            for (int j = 0; j < setup.length; j++) {
                view.printMessage(setup[j]);
                String input = scan.nextLine();
                userInput.add(input);            
            }

            String x_coord = userInput.get(0);
            int x = Integer.parseInt(x_coord);
            String y_coord = userInput.get(1);
            int y = Integer.parseInt(y_coord);
            String position = userInput.get(2);
            String shipName = userInput.get(3);

            ships.add(new Ship(shipName, x, y, position));
            ocean.addShip(ships.get(i), x, y);
        }

    }    
            
}
    


