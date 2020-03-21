package Puzzle;

import PuzzleElements.Axis;
import PuzzleElements.Vehicle;
import java.util.ArrayList;

public interface PuzzleKR {
    void addVehicle(Vehicle newVehicle);

    void replaceAllVehicles(ArrayList<Vehicle> vehicles);

    Boolean moveVehicle(Vehicle car, Integer amount);

    ArrayList<PuzzleKR> getAllMovesForAllVehicles();

    Boolean checkBoardLegal();

    String getMoveHistory();

    Boolean isPuzzleComplete();

}