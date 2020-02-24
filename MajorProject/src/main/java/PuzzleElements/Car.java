package PuzzleElements;

public class Car extends Vehicle {
    public final Integer size = 2;

    public Car(Integer[] headLocation,Axis axis, String vehicleID){
        this.headLocation = headLocation;
        this.axis = axis;
        this.vehicleID = vehicleID;
    }


}
