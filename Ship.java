
public class Ship {

    private int x;
    private int y;
    private int length;
    private String direction;

    public Ship(int length, String direction) {
        this.length = length;
        this.direction = direction;
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
}