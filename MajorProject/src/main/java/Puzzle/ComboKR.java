package Puzzle;

import PuzzleElements.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ComboKR implements PuzzleKR{

    private Tile[][] puzzleMap;
    private ArrayList<Vehicle> vehiclesList;
    private Integer[] exitTile;
    private Car targetCar;
    private String solution = "";

    ComboKR(){
        final Integer mapSize = 6;

        this.puzzleMap = new Tile[mapSize][mapSize];
        this.exitTile = new Integer[]{5,2};
        vehiclesList = new ArrayList<Vehicle>();

        for(int y=0;y<puzzleMap.length;y++){
            Arrays.fill(puzzleMap[y], new EmptyTile());
        }

    }

    ComboKR(Integer mapSize, Integer[] exitTile){
        this.puzzleMap = new Tile[mapSize][mapSize];

        for(int y=0;y<puzzleMap.length;y++){
            Arrays.fill(puzzleMap[y], new EmptyTile());
        }

        this.exitTile = exitTile;
        vehiclesList = new ArrayList<Vehicle>();
    }

    public void addVehicle(Vehicle newVehicle) {
        this.vehiclesList.add(newVehicle);
        Integer horizontalLocation = newVehicle.getHorizontal();
        Integer verticalLocation = newVehicle.getVertical();

        for(int i = 0;i<newVehicle.size;i++){
            puzzleMap[horizontalLocation][verticalLocation] = newVehicle;
            if(newVehicle.getAxis() == Axis.Horizontal){
                horizontalLocation += 1;
            } else {
                verticalLocation += 1;
            }
        }

    }

    public void addTargetCar(Car targetCar){
        this.targetCar = targetCar;
    }

    public void replaceAllVehicles(ArrayList<Vehicle> vehicles){
        this.vehiclesList = new ArrayList<Vehicle>();
        for (Vehicle theVehicle:vehicles) {
            this.addVehicle(theVehicle);
        }
    }

    public Boolean moveVehicle(Vehicle vehicle, Integer amount) {
        if(vehicle.getAxis() == Axis.Vertical){
            Integer totalCheck;
            if(amount>0){
                totalCheck = vehicle.size + amount;
            } else{
                totalCheck = vehicle.size;
            }
            if( (vehicle.getVertical()+totalCheck) >= puzzleMap.length ||
                    (vehicle.getVertical()+totalCheck) < 0){
                return false;
            }
            for(Integer i = 0; i<=totalCheck;i++){
                //if(puzzleMap[vehicle.getXAxis()][i] == ;
            }

        } else {

        }
        vehicle.move(amount);
        //TODO: Rearrange array
        solution = solution + (vehicle.toString() + amount);

        return false;
    }

    public ArrayList<Vehicle> getVehiclesList(){ return vehiclesList;}

    public ArrayList<PuzzleKR> getAllMoves() {
        return null;
    }

    public Boolean checkBoardLegal() {
        return false;
    }

    public String getSolution() {
        return solution;
    }

    public Boolean isPuzzleComplete() {
        if(checkBoardLegal()==false){
            return false;
        }
        if(targetCar.getVertical()==exitTile[0] && targetCar.getHorizontal() == exitTile[1]){
            return true;
        } else{
            return false;
        }
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int y=0;y<puzzleMap.length;y++){
            for(int x=0;x<puzzleMap.length;x++){

                stringBuilder.append(puzzleMap[x][y].toString() + "||");
            }
            stringBuilder.append("\n");

            for(int x=0;x<puzzleMap.length;x++){
                stringBuilder.append("==||");

            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
