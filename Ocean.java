import java.util.ArrayList;

public class Ocean {
    private ArrayList<ArrayList<Square>> map;
    final private int WIDTH = 10;
    final private int HEIGHT = 10;

    public Ocean(){
        this.map = new ArrayList<>();
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        for (int i=0; i<HEIGHT; i++){
            map.add(new ArrayList<Square>());
        }

        for (int i=0; i < WIDTH; i++){
            for (int j=0; j< letters.length; j++) {
                map.get(i).add(new Square(letters[j] + (i + 1)));
            }
        }
    }

    public void addShip(Ship ship, String coords) {

        int[] xy = getSquareLocation(coords);
        int x = xy[0];
        int y = xy[1];

        ship.setCoordX(x);
        ship.setCoordY(y);

        if (ship.getPosition().equals("vertical")) {
            for (int i = 0; i<ship.getLength(); i++) {
                this.map.get(x + i).get(y).setShip(ship);
            }
        }
        else {
            for (int i = 0; i<ship.getLength(); i++){
                this.map.get(x).get(y + i).setShip(ship);
            }
        }
    }

    public int[] getSquareLocation(String coords) {
        int[] squareLocation = new int[2];
        for (int i=0; i < HEIGHT; i++) {
            for (int j=0; j <WIDTH; j++) {
                if (this.map.get(i).get(j).getCoords().equals(coords.toUpperCase())) {
                    squareLocation[0] = i;
                    squareLocation[1] = j;                    
                    return squareLocation;
                }
            }
        }
        return null;
    }

    public boolean checkIfWithinBounds(Ship ship, String coords) {
        int[] squareLocation = getSquareLocation(coords);
        int x = squareLocation[0];
        int y = squareLocation[1];

        if ((ship.getPosition().equals("vertical") && x + ship.getLength() > HEIGHT) || 
            (ship.getPosition().equals("horizontal") && y + ship.getLength() > WIDTH)) {
            System.out.println("\nYou cannot set ship outside the board");
            return false;
        }
        return true;
    }

    public void isShipSunk(String coords) {

        int[] squareLocation = getSquareLocation(coords);
        int x = squareLocation[0];
        int y = squareLocation[1];

        Square square = this.map.get(x).get(y);
        Ship ship = square.getShip();

        if (ship != null){
            int x_ship= ship.getCoordX();
            int y_ship= ship.getCoordY();

            int count = 0;
            if (square.getIsHit() && ship.getPosition().equals("vertical")) {                
                for (int i = 0; i < ship.getLength(); i++) {                
                    if (this.map.get(x_ship + i).get(y_ship).getIsHit());
                        count++;
                }
            }
            else if (square.getIsHit() && ship.getPosition().equals("horizontal")) {
                for (int i = 0; i < ship.getLength(); i++) {                
                    if (this.map.get(x_ship).get(y_ship + i).getIsHit());
                        count++;
                }
            }
            if (ship.getLength() == count) {
                ship.setIsSunk();
            } 
        }
    }

    public ArrayList<ArrayList<Square>> getMap(){
        return this.map;
    }
}
