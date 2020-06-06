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
        Random randomGenerator = new Random();
        ArrayList<ArrayList<Square>> map = ocean.getMap();
        int x = 0;
        int y = 0;
        Square square = map.get(x).get(y);

        do{
            x = randomGenerator.nextInt(map.size());
            y = randomGenerator.nextInt(map.get(x).size());
            square = map.get(x).get(y);
            
        }while(square.getIsHit());

        return square.getCoords();
    }
}