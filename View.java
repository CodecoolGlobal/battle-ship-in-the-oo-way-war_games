
import java.util.ArrayList;

public class View {

    void displayBoard(ArrayList<ArrayList<Square>> map){
        displayBoard(map, true, 0);
    }

    void clearDisplay(){
        System.out.print("\033[H\033[2J");
    }

    void displayBoard(ArrayList<ArrayList<Square>> map, boolean forOwner, int offset){
        System.out.print("\033[0;" + offset + "H");
        System.out.println("   A B C D E F G A H I");
        int i = 1;
        for (ArrayList<Square> row : map) {
            System.out.print("\033[" + (i+1) + ";" + offset + "H");
            if (i < 10){
                System.out.print(i + ". ");
            }else System.out.print(i + ".");
            
            for (Square square : row) {
                System.out.print(square.toString() + " ");
            }
            System.out.println();
            i++;
        }
    }

    void printMessage(String message){
        System.out.print(message);
    }

    void displayGameScreen(ArrayList<ArrayList<Square>> mapOwner,
                           ArrayList<ArrayList<Square>> mapOpponent){
        clearDisplay();
        displayBoard(mapOwner);
        displayBoard(mapOwner, false, 30);
        printMessage("Enter coordinates to attack: ");
    }
} 