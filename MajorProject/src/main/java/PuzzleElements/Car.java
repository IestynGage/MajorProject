package PuzzleElements;

public class Car extends Vehicle {
    public Car(Integer[] headLocation,Axis axis, String vehicleID){
        this.size = 2;
        this.headLocation = new Location(headLocation);
        this.axis = axis;
        this.vehicleID = vehicleID;
    }

    public Car(Location headLocation,Axis axis, String vehicleID){
        this.size = 2;
        this.headLocation = headLocation;
        this.axis = axis;
        this.vehicleID = vehicleID;
    }

}
