
public class Square {

    private String coords;
    private boolean isHit;
    private boolean isMiss;
    private boolean isEmpty;
    private Ship ship;

    public Square(String coords) {
        this.isHit = false;
        //this.isMiss = false;
        this.isEmpty = true;
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

    @Override
    public String toString() {
        return hasShip() ? "X" : "\u00B7"; 
    }
}