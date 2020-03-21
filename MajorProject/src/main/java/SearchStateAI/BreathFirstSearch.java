package SearchStateAI;

import Puzzle.PuzzleKR;

import java.util.*;

public class BreathFirstSearch {

    Queue<PuzzleKR> puzzleKRQueue = new LinkedList<>();

    public BreathFirstSearch(PuzzleKR firstQueue) {
        puzzleKRQueue.add(firstQueue);
    }

    public String getSolution(){
        while(!puzzleKRQueue.isEmpty()){
            PuzzleKR puzzle = puzzleKRQueue.remove();
            System.out.println(puzzle.toString());
            if(puzzle.isPuzzleComplete()) {
                System.out.println("Solution found");
                return puzzle.getMoveHistory();
            }
            puzzleKRQueue.addAll(puzzle.getAllMovesForAllVehicles());
        }
        System.out.println("Solution Not found");
        return "No Solution";
    }

}
