package PuzzleElements;

public class Vehicle extends Tile {
    /**
     *  headLocation - the location of where the head is stored
     *  [0] X axis, [1] Y axis
     */
    public Integer[] headLocation = new Integer[2];
    public Axis axis;
    public String vehicleID;

    public void move(Integer amount){
        if(axis==Axis.Horizontal){
            if((headLocation[0] + amount) < 0){
                //TODO: Return custom error?
                //System.err.println("Out of bounds");
                return;
            }
            headLocation[0] += amount;
        } else if(axis==Axis.Vertical){
            if((headLocation[1] + amount) < 0){
                //TODO: Return custom error?
                //System.err.println("Out of bounds");
                return;
            }
            headLocation[1] += amount;
        } else {
            //System.err.println("Vehicle "+ vehicleID + " does not have axis Set");
            //TODO: Create an custom error?
        }
    }

    public Integer[] getHeadLocation() {
        return headLocation;
    }

    public void setHeadLocation(Integer[] headLocation) {
        this.headLocation = headLocation;
    }

    public Axis getAxis() {
        return axis;
    }

    public void setAxis(Axis axis) {
        this.axis = axis;
    }

    public String toString(){
        return vehicleID;
    }
}
