
public class Square {

    private String coords;
    private boolean isHit;
    private boolean isMiss;
    private Ship ship;

    public Square(String coords) {
        this.isHit = false;
        this.isMiss = false;
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

    public void markMiss(){
        this.isMiss = true;
    }

    public boolean hasShip(){
        if(this.ship != null){
            return true;
        }else return false;
    }

    public String getIconSquare(boolean forOwner){
        if(!hasShip()) {
            if(isHit) return "o";
            else return ".";
        }else{
            if(isHit) return "!";
            else {
                if(forOwner) return "X";
                else return ".";
            }
        }        
    }
}