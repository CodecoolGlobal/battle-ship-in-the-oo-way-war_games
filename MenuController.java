import java.util.Scanner;

public class MenuController {

    private static Scanner scan = new Scanner(System.in);

    public static void menu() {
        View view = new View();
        
        boolean gameOn = true;
        while(gameOn){
            view.clearDisplay();
            printMenu();

            System.out.print("Choose one of options: ");
            int userInput = getUserInput();
            

            if (userInput == 1) {
                SetupController.run();
            } else if (userInput == 2) {
                System.out.println("Some rules");
            } else if (userInput == 3) {
                System.out.println("See y next time");
                gameOn = false;
            }
        }
    }

    public static void printMenu() {

        String[] options = {"New game", "Help", "Exit"};

        for(int index = 0; index < options.length; index++){
            System.out.println(index + 1 + ". " + options[index]);
        }
    }

    static int getUserInput(){

        while(!scan.hasNextInt()) {
            System.out.println("Wrong input format");
            scan.next();
        }
        int input = scan.nextInt();

        return input;
    }
}