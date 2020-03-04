package Puzzle;

import PuzzleElements.EmptyTile;
import PuzzleElements.Location;
import PuzzleElements.Tile;
import PuzzleElements.Vehicle;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class ListKR implements PuzzleKR {

    private List<Vehicle> vehicles;
    private Integer mapSize;
    private Integer[] exitTile;

    ListKR(){
        mapSize = 6;
        vehicles = new ArrayList<>();
        this.exitTile = new Integer[]{5,2};
    }

    ListKR(Integer mapSize,Integer[] exitTile){
        this.mapSize = mapSize;
        vehicles = new ArrayList<>();
        this.exitTile = exitTile;
    }

    @Override
    public void addVehicle(Vehicle newVehicle) {
        vehicles.add(newVehicle);
    }

    @Override
    public void replaceAllVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;

    }

    //Returns false if it wasn't able to make the move, returns true if it can
    @Override
    public Boolean moveVehicle(Vehicle vehicle, Integer amount) {
        ArrayList<Location> locationOfEachMove = vehicle.getPathToLocation(amount);

        vehicles.remove(vehicle);
        for (Vehicle vehicleToCheck : vehicles) {
            Location location = vehicle.getMovedMaxPosition(amount);
            if(vehicleToCheck.isOnLocation(location)){
                vehicles.add(vehicle);
                return false;
            }
            for (Location pathLocation:locationOfEachMove) {
                if(vehicleToCheck.isOnLocation(pathLocation)){
                    vehicles.add(vehicle);
                    return false;
                }
            }
        }
        vehicle.move(amount);
        vehicles.add(vehicle);

        return true;
    }

    @Override
    public ArrayList<PuzzleKR> getAllMoves() {
        return null;
    }

    public ArrayList<PuzzleKR> getAllMovesSingleCar(Vehicle theVehicle){

        return null;
    }

    @Override
    public Boolean checkBoardLegal() {
        return null;
    }

    @Override
    public String getSolution() {
        return null;
    }

    @Override
    public Boolean isPuzzleComplete() {
        return null;
    }

    private Tile[][] getPuzzleMap() {
        Tile[][] puzzleMap = new Tile[mapSize][mapSize];
        for(int y=0;y<puzzleMap.length;y++){
            Arrays.fill(puzzleMap[y], new EmptyTile());
        }

        for (Vehicle vehicleToAdd:vehicles) {
            ArrayList<Location> locationOfVehicle = vehicleToAdd.getWholeBodyLocation();
            for (Location locationToAdd:locationOfVehicle) {
                puzzleMap[locationToAdd.getXAxis()][locationToAdd.getYAxis()] = vehicleToAdd;

            }
        }
        return puzzleMap;
    }

    public Vehicle getVehicle(Integer index){
        return vehicles.get(index);
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        Tile[][] puzzleMap = this.getPuzzleMap();

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
