import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Util {

    private static Scanner scan = new Scanner(System.in);

    public static Map<String, String> createShipsDict() {
        Map<String, String> shipsDict = new LinkedHashMap<>();
        String[] shipTypes = {"Carrier", "Battleship", "Cruiser", "Submarine", "Destroyer"};
        String[] description = {"occupies 5 squares", "occupies 4 squares", "occupies 3 squares", "occupies 3 squares", "occupies 2 squares"};

        for (int i = 0; i < shipTypes.length; i++) {
            shipsDict.put(shipTypes[i], description[i]);
        }
        return shipsDict;
    }

    public static String getPositionFromInput(String input) {
        if (input.toUpperCase().equals("Y")) {
            return "horizontal";
        } else {
            return "vertical";
        }
    }

    public static String validateUserInput(String pattern, String input, String message) {
        input = scan.nextLine();  

        while (!input.matches(pattern)) {
            System.out.print(message);
            input = scan.nextLine();  
        } 
        return input;
    }

    public static void pressEnterToContinue(String message)  { 
        System.out.print(message);
        try {
            System.in.read();
        }
        catch(Exception e) {               
        }  
 }
}