
public class Square {

    private String coords;
    private boolean isHit;
    private Ship ship;
    private final String HIT = "፠";
    private final String MISS = "\uFFEE";
    private final String EMPTY = "\u00B7";
    private final String SHIP = "X";

    public Square(String coords) {
        this.isHit = false;
        this.coords = coords;
    }

    public boolean getIsHit(){
        return isHit;
    }

    public String getCoords() {
        return coords;
    }

    public Ship getShip(){
        return ship;
    }

    public void markHit() {
        this.isHit = true;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public boolean hasShip(){
        if(this.ship != null){
            return true;
        }else return false;
    }

public String getIconSquare(boolean forOwner){
    if(!hasShip()) {
        if(isHit) return MISS;
        else return EMPTY;
    }else{
        if(isHit) return HIT;
        else {
            if(forOwner) return SHIP;
            else return EMPTY;
        }
    }        
}
}