package PuzzleElements;

import java.util.ArrayList;
import java.util.Objects;

public class Vehicle extends Tile {
    Location headLocation;
    Axis axis;
    String vehicleID;
    Integer size;

    public Vehicle(String vehicleID){
        this.vehicleID = vehicleID;
    }

    public Vehicle(Vehicle original){
        this.headLocation = new Location(original.getHeadLocation().toArray());
        this.axis = original.getAxis();
        this.vehicleID = original.vehicleID;
        size = original.size;
    }

    public void move(Integer amount){
        if(axis==Axis.Horizontal){
            headLocation.add(Axis.Horizontal,amount);
        } else if(axis==Axis.Vertical){
            headLocation.add(Axis.Vertical,amount);
        } else {
            System.err.println("Vehicle "+ vehicleID + " does not have axis Set");
            //TODO: Create an custom error?
        }
    }

    public Location getHeadLocation() {
        return headLocation;
    }

    public ArrayList<Location> getWholeBodyLocation(){
        ArrayList<Location> location = new ArrayList<>();
        location.add(headLocation);
        for(int i=1;i<size;i++){
                Location bodyLocationToAdd = new Location(headLocation.toArray());
                bodyLocationToAdd.add(axis,i);
                location.add(bodyLocationToAdd);
        }
        return location;
    }

    //Returns true if is on location else it's false if it's not on location
    public Boolean isOnLocation(Location theLocation){
        ArrayList<Location> allLocation = this.getWholeBodyLocation();
        for (Location locationToCheck : allLocation) {
            if(locationToCheck.equals(theLocation)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Location> getPathToLocation(Integer amount){
        if(amount==0){
            return new ArrayList<>();
        }
        ArrayList<Location> path = new ArrayList<>();
        for(Integer i=1;i<=amount;i++){
            Location newPathLocation = new Location(headLocation.toArray());
            newPathLocation.add(axis,i);
            path.add(newPathLocation);
        }
        return path;
    }

    public void setHeadLocation(Location headLocation) {
        this.headLocation = headLocation;
    }

    public Axis getAxis() {
        return axis;
    }

    public void setAxis(Axis axis) {
        this.axis = axis;
    }

    public Integer getHorizontal(){
        return headLocation.getXAxis();
    }

    public Integer getVertical(){
        return headLocation.getYAxis();
    }

    public Integer getSize() {
        return size;
    }

    public Location getMovedMaxPosition(Integer amount){
        if(axis == Axis.Vertical){
            if(amount>0){
                return new Location(headLocation.getXAxis(), headLocation.getYAxis()+ amount + size-1);
            } else {
                return new Location(headLocation.getXAxis(), headLocation.getYAxis()+ amount + size);
            }
        } else if (axis == Axis.Horizontal){
            if(amount>0){
                return new Location(headLocation.getXAxis()+ amount + size-1, headLocation.getYAxis());
            } else {
                return new Location(headLocation.getXAxis()+ amount, headLocation.getYAxis());
            }
        } else {
            System.err.println("No Axis set");
            //TODO: Create an custom error?
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Vehicle vehicle = (Vehicle) o;
        return vehicleID.equals(vehicle.vehicleID);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(vehicleID);
        result = 31 * result;
        return result;
    }

    public String toString(){
        return vehicleID;
    }
}
