import java.util.ArrayList;

public class Ocean {
    private ArrayList<ArrayList<Square>> map;
    final private int WIDTH = 10;
    final private int HEIGHT = 10;

    public Ocean(){
        this.map = new ArrayList<ArrayList<Square>>();
        for (int i=0; i<HEIGHT; i++){
            map.add(new ArrayList<Square>());
        }

        for (ArrayList<Square> line : map) {
            for (int i=0; i<WIDTH; i++){
                line.add(new Square());
            }
        }
    }

    public void addShip(Ship ship, int x, int y){
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

    public boolean isShipSunk(int x, int y) {
        Square square = this.map.get(x).get(y);
        Ship ship = square.getShip();

        if (ship != null){
            int x_ship= ship.getCoordX();
            int y_ship= ship.getCoordY();

            if (square.getIsHit() && ship.getPosition().equals("vertical")) {
                int  count = 0;
                for (int i = 0; i < ship.getLength(); i++) {                
                    if (this.map.get(x_ship + i).get(y_ship).getIsHit());
                        count += 1;
                }
                if (ship.getLength() == count) {
                    return true;
                }                  
            }
            else if (square.getIsHit() && ship.getPosition().equals("horizontal")) {
                int  count = 0;
                for (int i = 0; i < ship.getLength(); i++) {                
                    if (this.map.get(x_ship).get(y_ship + i).getIsHit());
                        count += 1;
                }
                if (ship.getLength() == count) {
                    return true;
                }                  
            }
        }
        return false;
    }

    public ArrayList<ArrayList<Square>> getMap(){
        return this.map;
    }
}