package SearchStateAI;

import Puzzle.ListKR;
import PuzzleElements.*;
import org.junit.jupiter.api.Test;

public class BreathFirstSearchTest {

    @Test
    public void simplePuzzleTest(){
        ListKR puzzle = new ListKR();
        Car car1 = new Car(new Integer[]{2,3}, Axis.Horizontal, "C1");
        Car car2 = new Car(new Integer[]{2,4},Axis.Horizontal, "C2");
        Car target = new Car(new Integer[]{1,2},Axis.Horizontal, "TT");
        Car bus1 = new Car(new Integer[]{3,0},Axis.Vertical, "C3");
        puzzle.addVehicle(car1);
        puzzle.addVehicle(car2);
        puzzle.addVehicle(bus1);

        puzzle.addTargetVehicle(target);


        BreathFirstSearch ai = new BreathFirstSearch(puzzle);
        ai.getSolution();
    }
}
