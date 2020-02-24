package PuzzleElements;

public class Bus extends Vehicle {
    public final Integer size = 3;

    public Bus(Integer[] headLocation,Axis axis, String vehicleID){
        this.headLocation = headLocation;
        this.axis = axis;
        this.vehicleID = vehicleID;
    }
}
