
public class Ship {

    private int x;
    private int y;
    private int length;
    private String shipName;
    private String position;
    private boolean isSunk;

    public Ship(String shipName, int x, int y, String position) {

        if (shipName.toUpperCase().equals("CARRIER")) this.length = 5;
        else if(shipName.toUpperCase().equals("BATTLESHIP")) this.length = 4;
        else if(shipName.toUpperCase().equals("CRUISER")) this.length = 3;
        else if(shipName.toUpperCase().equals("SUBMARINE")) this.length = 2;
        else this.length = 1;

        this.x = x;
        this.y = y;
        this.shipName = shipName;
        this.position = position;
        this.isSunk = false;
    }

    public int getLength() {
        return this.length;
    }

    public String getPosition() {
        return this.position;
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