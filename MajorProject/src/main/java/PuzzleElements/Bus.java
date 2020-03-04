package PuzzleElements;

public class Bus extends Vehicle {
    public Bus(Integer[] headLocation,Axis axis, String vehicleID){
        this.size = 3;
        this.headLocation = new Location(headLocation);
        this.axis = axis;
        this.vehicleID = vehicleID;
    }

    public Bus(Location headLocation,Axis axis, String vehicleID){
        this.size = 3;
        this.headLocation = headLocation;
        this.axis = axis;
        this.vehicleID = vehicleID;
    }
}
