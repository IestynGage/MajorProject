package PuzzleElements;

import java.util.Objects;

public class Location {
    private Integer xAxis;
    private Integer yAxis;

    Location(Integer xAxis, Integer yAxis){
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    Location(Integer[] location){
        if(location.length==2){
            xAxis = location[0];
            yAxis = location[1];
        }
    }

    Location(Location newLocation){
        this.xAxis = newLocation.getYAxis();
        this.yAxis = newLocation.getXAxis();
    }

    public Integer[] toArray(){
        return new Integer[]{xAxis, yAxis};
    }

    public void add(Axis axis, Integer amount){
        if(axis == Axis.Horizontal){
            xAxis +=amount;
        } else{
            yAxis +=amount;
        }
    }

    public Integer getXAxis(){
        return xAxis;
    }

    public Integer getYAxis(){
        return yAxis;
    }

    public String toString(){
        return "Location:" + xAxis + "," + yAxis;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(xAxis, location.xAxis) &&
                Objects.equals(yAxis, location.yAxis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xAxis, yAxis);
    }
}
