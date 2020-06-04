
import java.util.ArrayList;

public class View {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    ArrayList<String> messageStream;

    public View(){
        messageStream = new ArrayList<String>();
    }

    void displayBoard(ArrayList<ArrayList<Square>> map){
        displayBoard(map, true, 0);
    }

    void clearDisplay(){
        System.out.print("\033[H\033[2J");
    }

    void displayBoard(ArrayList<ArrayList<Square>> map, boolean forOwner, int offset){
        System.out.print("\033[0;" + offset + "H");
        System.out.println("   A B C D E F G H I J");
        int i = 1;
        for (ArrayList<Square> row : map) {
            System.out.print("\033[" + (i+1) + ";" + offset + "H");
            if (i < 10){
                System.out.print(" " + i + " ");
            }else System.out.print(i + " ");
            
            for (Square square : row) {
                if (square.hasShip() && square.getShip().getIsSunk()) System.out.print(RED + square.getIconSquare(forOwner) + " " + RESET);
                else System.out.print(square.getIconSquare(forOwner) + " ");
            }
            System.out.println();
            i++;
        }
    }

    void printMessage(String message){
        System.out.print(message);
    }

    void displayGameScreen(ArrayList<ArrayList<Square>> mapOwner,
                           ArrayList<ArrayList<Square>> mapOpponent,
                           boolean isTurnOver){
        clearDisplay();
        displayBoard(mapOwner);
        displayBoard(mapOpponent, false, 30);
        if (!isTurnOver) {
            printMessage("Enter coordinates to attack: \n\n");
            trimMessageStream(6);
        } else {
            printMessage("You've missed! Press enter to end this turn.");
            trimMessageStream(0);
        }

        printMessageStream();
        System.out.print("\033[12;30H");
    }

    void displayGameScreen(ArrayList<ArrayList<Square>> mapOwner,
                           ArrayList<ArrayList<Square>> mapOpponent){
                            displayGameScreen(mapOwner, mapOpponent, false);
                            }

    void displayOptions(ArrayList<String> options){
        int i = 1;
        for (String option : options) {
            if (i<10){
                System.out.print(i + ". ");
            }else System.out.print(i + ".");
            System.out.println(option);
        }
    }

    void displaySetup(ArrayList<ArrayList<Square>> map,
                      String shipname,
                      String question){
        clearDisplay();
        displayBoard(map);
        printMessage("\n");
        printMessage(shipname + ":\n");
        printMessage(question + ":\n");
        printMessageStream();
        trimMessageStream(0);
        System.out.print("\033[13" + (question.length()+2) + "H"); // this might require calibration
    }

    void trimMessageStream(int limit){
        /**
         * Reduces number of element in messageStream
         * @param int limit Number of messages that will be left in messageStream
         */
        while (this.messageStream.size() > limit){
            this.messageStream.remove(0);
        }
    }

    void printMessageStream(){
        /**
         * Prints all messages from messageStream line by line, starting with latest
         */
        int i = messageStream.size() - 1;
        while (i >= 0){
            System.out.println(messageStream.get(i));
            i--;
        }
    }
}

