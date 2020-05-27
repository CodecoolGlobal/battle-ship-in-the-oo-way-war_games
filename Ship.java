
public class Ship {

    private int x;
    private int y;
    private int length;
    private String shipName;
    private String direction;
    private boolean isSunk;

    public Ship(String shipName, String direction) {

        if(shipName.equals("Carrier")) this.length = 5;
        else if(shipName.equals("Battleship")) this.length = 4;
        else if(shipName.equals("Cruiser")) this.length = 3;
        else if(shipName.equals("Submarine")) this.length = 2;

        this.x = 0;
        this.y = 0;
        this.shipName = shipName;
        this.direction = direction;
        this.isSunk = false;
    }

    public int[] getCoords() {
        int[] coords = {this.x, this.y};
        return coords;
    }

    public int getlength() {
        return this.length;
    }

    public String getdirection() {
        return this.direction;
    } 

    public boolean getIsSunk() {
        return this.isSunk;
    }

    public int getCoordX(){
        return this.x;
    }

    public int getCoordY(){
        return this.y;
    }

    public String getShipName(){
        return this.shipName;
    }

    public void setCoordX(int x) {
        this.x = x;
    }

    public void setCoordY(int y){
        this.y = y;
    }

    public void setShipName(String shipName){
        this.shipName = shipName;
    }
}