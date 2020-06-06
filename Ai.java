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
        
        for (ArrayList<Square> row : map) {
            for (Square square : row) {
                if(!square.getIsHit()) square.markIsGoodTarget();
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
}