package SearchStateAI;

import Puzzle.ListKR;
import Puzzle.PuzzleKR;

import java.util.*;

public class BreathFirstSearch {

    Queue<ListKR> puzzleKRQueue = new LinkedList<>();

    public BreathFirstSearch(ListKR firstQueue) {
        puzzleKRQueue.add(firstQueue);
    }

    public String getSolution(){
        while(!puzzleKRQueue.isEmpty()){
            ListKR puzzle = puzzleKRQueue.remove();

            if(puzzle.isPuzzleComplete()) {
                System.out.println("Solution found");
                return puzzle.getMoveHistory();
            }
            for (PuzzleKR puzzleToAdd:puzzle.getAllMovesForAllVehicles()) {
                puzzleKRQueue.add((ListKR) puzzleToAdd);
            }
        }
        System.out.println("Solution Not found");
        return "No Solution";
    }

}
