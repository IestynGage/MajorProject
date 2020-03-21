package SearchStateAI;

import Puzzle.PuzzleKR;

import java.util.ArrayList;
import java.util.Random;

public class RandomMove {
    PuzzleKR puzzleKR;

    public RandomMove(PuzzleKR puzzleKR){
        this.puzzleKR = puzzleKR;
    }

    public String getSolution(){
        Random random = new Random();
        while(!puzzleKR.isPuzzleComplete()){
            ArrayList<PuzzleKR> possibleChoice = puzzleKR.getAllMovesForAllVehicles();
            puzzleKR = possibleChoice.get(random.nextInt(possibleChoice.size()));
        }

        return puzzleKR.getMoveHistory();
    }
}
