import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        List<Ship> ships = new ArrayList<Ship>();
        View view = new View();

        
        Ocean ocean = new Ocean();
        String[] setup = new String[] {"Enter ship x coordinate (row): ", "Enter ship y coordinate (column): ", "vertical/horizontal: ", "Ship type:(Carrier (occupies 5 squares), Battleship (4), Cruiser (3), Submarine (3), and Destroyer (2)): "};
        ArrayList<String> userInput = new ArrayList<String>();
        for (int i = 0; i < setup.length; i++) {
            @SuppressWarnings("resource")
            Scanner scan = new Scanner(System.in);
            System.out.print(setup[i]);
            String input = scan.nextLine();
            userInput.add(input);
        }

        String x = userInput.get(0);
        int x_coord = Integer.parseInt(x);
        String y = userInput.get(1);
        int y_coord = Integer.parseInt(y);
        String location = userInput.get(2);
        String shipName = userInput.get(3);

        ships.add(new Ship(shipName, location));
        ocean.addShip(ships.get(0), x_coord, y_coord);
        view.displayGameScreen(ocean.getMap(), ocean.getMap());
    }
}