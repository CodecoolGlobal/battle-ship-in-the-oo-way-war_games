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
                printRules(view);
            } else if (userInput == 3) {
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

    static void printRules(View view){
        view.clearDisplay();
        String[] rules = {"***RULES***\n\nEach player's fleet contains 5 different ships:\n -Carrier (5 holes)\n -Battleship (4 holes)\n -Cruiser (3 holes)\n -Submarine (3 holes)\n -Destroyer (2 holes) \n",
                          "Place your fleet of 5 ships on the ocean grid. Rules for placing ships: \n -Place each ship in any horizontal or vertical position but not diagonally",
                          " -Don't place a ship so that any part of it overlaps letters, numbers, the edge of the grid or another ship\n",
                          "Decide who will start. You and your opponent will alternate turns, calling out one shot per turn to try to hit each other's ships. If you hit you get additional shot.",
                          "Once all the squares in any one ship are marked hit, the ship will sink. If you are the first player to sink your opponent's entire fleet of 5 ships, you win the game.\n"};
        
        for(int index = 0; index < rules.length; index++){
            System.out.println(rules[index]);
        }

        String input = null;
        while(input == null){
            System.out.print("Enter any key to return to the main menu ");
            input = scan.next();
        }
    }
}