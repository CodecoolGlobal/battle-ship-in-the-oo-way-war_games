import java.util.Scanner;

public class GameController {
    private Ocean ocean1;
    private Ocean ocean2;
    private String coordsPattern = "[a-jA-J][1-9][0]*";
    private Scanner scan;
    private View view;
    private boolean isRunning = true;

    public GameController(Ocean ocean1, Ocean ocean2){
        this.ocean1 = ocean1;
        this.ocean2 = ocean2;
    }

    public void run() {
        initialise();

        while (this.isRunning){
            runTurn(ocean1, ocean2, "Player 1");
            if (isRunning) runTurn(ocean2, ocean1, "Player 2");
        }
    }

    void initialise() {
        scan = new Scanner(System.in);
        view = new View();
    }

    void runTurn(Ocean oceanOwner,
                 Ocean oceanOppo,
                 String playerName){
        boolean isTurnOver = false;
        String input;

        view.clearDisplay();
        view.printMessage(playerName + ": Press enter to start turn.");
        scan.nextLine();
        scan.nextLine();

        while (!isTurnOver){
            view.displayGameScreen(oceanOwner.getMap(), oceanOppo.getMap());
            input = scan.nextLine(); 
            if (!input.matches(this.coordsPattern)) {
                view.messageStream.add("Please enter valid coordinates (example: B5).");
            } else {
                int[] coords = oceanOppo.getSquareLocation(input);
                if (oceanOppo.getMap().get(coords[0]).get(coords[1]).getIsHit()){
                    view.messageStream.add("You've already hit this square!");
            } else {
                oceanOppo.getMap().get(coords[0]).get(coords[1]).markHit();
                if (!oceanOppo.getMap().get(coords[0]).get(coords[1]).hasShip()){
                    view.messageStream.add("You've missed!");
                    view.messageStream.add("Press enter to end this turn.");
                    isTurnOver = true;
            } else {
                oceanOppo.isShipSunk(input);
                if (oceanOppo.getMap().get(coords[0]).get(coords[1]).getShip().getIsSunk()){
                    view.messageStream.add("You've sunk a " + oceanOppo.getMap().get(coords[0]).get(coords[1]).getShip().getShipName() + "!");
                } else view.messageStream.add("You've hit a " + oceanOppo.getMap().get(coords[0]).get(coords[1]).getShip().getShipName() + "!");
            }
            }
            }
        }
        scan.nextLine();
        scan.nextLine();
    }
}