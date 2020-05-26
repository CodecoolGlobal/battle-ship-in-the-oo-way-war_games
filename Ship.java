
public class Ship {

    private int x;
    private int y;
    private int length;
    private String shipName;
    private String direction;
    private boolean isSunk;

    public Ship(int length, String direction, String shipName) {
        this.x = 0;
        this.y = 0;
        this.length = length;
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