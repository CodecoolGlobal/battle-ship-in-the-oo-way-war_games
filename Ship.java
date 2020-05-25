
public class Ship {

    private int x;
    private int y;
    private int length;
    private String direction;
    private boolean isSunk;

    public Ship(int length, String direction) {
        this.x = 0;
        this.y = 0;
        this.length = length;
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
}