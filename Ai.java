import java.util.ArrayList;
import java.util.Random;

public class Ai {

    private String difficultyLevel;

    public Ai(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getDifficultyLevel(){
        return this.difficultyLevel;
    }

    public String getCoordinatesToShoot(Ocean ocean){
        ArrayList<ArrayList<Square>> map = ocean.getMap();
        ArrayList<Square> targets = new ArrayList<Square>();

        if(difficultyLevel.equals("medium")){
            for (ArrayList<Square> row : map) {
                for (Square square : row) {
                    if(square.getIsHit() && !square.getShip().getIsSunk()) {
                        ArrayList<Square> neighbours = getNeighbourSquares(ocean, square);
                        if(!neighbourIsHit(neighbours)) {
                            for (Square neighbour : neighbours) {
                                if(!neighbour.getIsHit()) neighbour.markIsGoodTarget();
                            }
                        }else {
                            if(isTargetHorizontal(square, ocean)) {
                                do{
                                    // oznaczanie celów
                                }while();
                            }
                        }
                    }
                }
            }
        }

        if(difficultyLevel.equals("easy") || !hasTargets(map)){
            for (ArrayList<Square> row : map) {
                for (Square square : row) {
                    if(!square.getIsHit()) square.markIsGoodTarget();
                }
            }
        }

        if(difficultyLevel.equals("medium")){
            for (ArrayList<Square> row : map) {
                for (Square square : row) {
                    if(hasSunkNeighbour(ocean, square)) square.unmarkIsGoodTarget();
                }
            }
        }

        for (ArrayList<Square> row : map) {
            for (Square square : row) {
                if(square.getIsGoodTarget()) targets.add(square);
                square.unmarkIsGoodTarget();
            }
        }

        return drawSquare(targets).getCoords();
    }

    private Square drawSquare(ArrayList<Square> targets){
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(targets.size());

        return targets.get(randomIndex);
    }

    private boolean hasTargets(ArrayList<ArrayList<Square>> map){
        for (ArrayList<Square> row : map) {
            for (Square square : row) {
                if(square.getIsGoodTarget()) return true;
            }
        }
        return false;
    }

    private boolean hasSunkNeighbour(Ocean ocean, Square square){
        for (Square neighbour : getNeighbourSquares(ocean, square)) {
            if(neighbour.getShip() != null && neighbour.getShip().getIsSunk()) return true;
        }
        return false;
    }

    private ArrayList<Square> getNeighbourSquares(Ocean ocean, Square square){
        int[] coord = ocean.getSquareLocation(square.getCoords());
        ArrayList<Square> neighbours = new ArrayList<Square>();
        if((coord[0] - 1) >= 0) neighbours.add(ocean.getMap().get(coord[0] - 1).get(coord[1]));
        if((coord[0] + 1) <= 9) neighbours.add(ocean.getMap().get(coord[0] + 1).get(coord[1]));
        if((coord[1] - 1) >= 0) neighbours.add(ocean.getMap().get(coord[0]).get(coord[1] - 1));
        if((coord[1] + 1) <= 9) neighbours.add(ocean.getMap().get(coord[0]).get(coord[1] + 1));
        
        return neighbours;
    }

    private boolean neighbourIsHit(ArrayList<Square> neighbours){
        for (Square square : neighbours) {
            if(square.hasShip() && square.getIsHit()) return true;
        }
        return false;
    }

    private boolean isTargetHorizontal(Square square, Ocean ocean){
        int[] coord = ocean.getSquareLocation(square.getCoords());
        if((coord[1] + 1) <= 9 && ocean.getMap().get(coord[0]).get(coord[1] + 1).hasShip()) return true;
        else if((coord[1] - 1) >= 0 && ocean.getMap().get(coord[0]).get(coord[1] - 1).hasShip()) return true;
        return false;
    }
}