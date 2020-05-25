import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Ship> ships = new ArrayList<Ship>();
        View view = new View();

        
        Ocean ocean = new Ocean();
        String[] setup = new String[] {"Enter ship x coordinate (row): ", "Enter ship y coordinate (column): ", "vertical/horizontal: ", "length: "};
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
        String length = userInput.get(3);
        int lengthInt = Integer.parseInt(length);

        
        ships.add(new Ship(lengthInt, location));
        ocean.addShip(ships.get(0), x_coord, y_coord);
        view.displayBoard(ocean.getMap());
    }
}