import java.util.LinkedHashMap;


public class Util {

    public static LinkedHashMap<String, String> createShipsDict() {
        LinkedHashMap<String, String> shipsDict = new LinkedHashMap<String, String>();
        String[] shipTypes = {"Carrier", "Battleship", "Cruiser", "Submarine", "Destroyer"};
        String[] description = {"occupies 5 squares", "occupies 4 squares", "occupies 3 squares", "occupies 2 squares", "occupies 1 square"};

        for (int i = 0; i < shipTypes.length; i++) {
            shipsDict.put(shipTypes[i], description[i]);
        }
        return shipsDict;
    }
}