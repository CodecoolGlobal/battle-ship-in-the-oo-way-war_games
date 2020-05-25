
import java.util.ArrayList;

public class View {

    public void displayBoard(ArrayList<ArrayList<Square>> map){
        System.out.print("\033[H\033[2J");
        for (ArrayList<Square> row : map) {
            for (Square square : row) {
                System.out.print(square.toString());
            }
            System.out.println();
        }
    }
} 