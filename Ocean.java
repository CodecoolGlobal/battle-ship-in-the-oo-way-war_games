package Battleships;

import java.util.ArrayList;

public class Ocean {
    private ArrayList<ArrayList<Square>> Ocean;
    final private int WIDTH = 10;
    final private int HEIGHT = 10;

    public Ocean(){
        this.Ocean = new ArrayList<ArrayList<Square>>();
        for (int i=0; i<HEIGHT; i++){
            Ocean.add(new ArrayList<Square>());
        }

        for (ArrayList<Square> line : Ocean) {
            for (int i=0; i<WIDTH; i++){
                line.add(new Square());
            }
        }
    }
}