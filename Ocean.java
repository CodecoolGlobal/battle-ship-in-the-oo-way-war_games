import java.util.ArrayList;

public class Ocean {
    private ArrayList<ArrayList<Square>> map;
    final private int WIDTH = 10;
    final private int HEIGHT = 10;

    public Ocean(){
        this.map = new ArrayList<ArrayList<Square>>();
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
        int[] xy = getNumericCoords(coords);
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

    public int[] getNumericCoords(String coords) {
        int[] xy = new int[2];
        for (int i=0; i < HEIGHT; i++) {
            for (int j=0; j <WIDTH; j++) {
                if (this.map.get(i).get(j).getCoords().equals(coords)) {
                    xy[0] = i;
                    xy[1] = j;
                }
            }
        }
        return xy;
    }

    public boolean isShipSunk(int x, int y) {
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
                return true;
            } 
            else return false;
        }
        return false;
    }

    public ArrayList<ArrayList<Square>> getMap(){
        return this.map;
    }

    public String getPositionFromMessage(String message) {
        if (message.toUpperCase().equals("Y")) {
            return "horizontal";
        } else {
            return "vertical";
        }

    }
}
