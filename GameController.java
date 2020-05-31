import java.util.Scanner;

public class GameController {
    private Ocean oceanOwner;
    private Ocean oceanOppo;
    private String coordsPattern = "[a-jA-J][1-9][0]*";
    private Scanner scan;
    private View view;

    public GameController(Ocean oceanOwner, Ocean oceanOppo){
        this.oceanOwner = oceanOwner;
        this.oceanOppo = oceanOppo;
    }

    public void run() {
        initialise();

        view.clearDisplay();
        view.printMessage("PLAYER1: Press enter to start turn.");
        scan.nextLine();
        scan.nextLine();

        view.displayGameScreen(oceanOwner.getMap(), oceanOppo.getMap());
    }

    void initialise() {
        scan = new Scanner(System.in);
        view = new View();
    }
}