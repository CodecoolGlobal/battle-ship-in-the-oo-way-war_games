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
        String[] setup = {"\nEnter ship x coordinate (row): ", "\nEnter ship y coordinate (column): ", "\nPosition vertical or horizontal: ", "\nShip type: Carrier (occupies 5 squares), Battleship (4), Cruiser (3), Submarine (2), Destroyer (1): "};
        
        for (int i = 0; i < NUMBEROFSHIPS; i++) {

            ArrayList<String> userInput = new ArrayList<String>();

            for (int j = 0; j < setup.length; j++) {
                System.out.print(setup[j]);
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
            view.displayGameScreen(ocean.getMap(), ocean.getMap());      
        }

    }    
            
}
    


