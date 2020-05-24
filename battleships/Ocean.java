package battleships;

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

    public void addShip(Ship ship, int vertical, int horizontal){
        if (ship.getdirection().equals("up")){
            for (int i = 0; i<ship.getlength(); i++){
                this.map.get(vertical - i).get(horizontal).setShip(ship);
            }
        }
    }

    public ArrayList<ArrayList<Square>> getMap(){
        return this.map;
    }
}