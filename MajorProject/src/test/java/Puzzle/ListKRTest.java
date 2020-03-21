package Puzzle;

import PuzzleElements.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ListKRTest {
    //==============================================================//
    //  addVehicle method Test
    //==============================================================//
    @Test
    public void addVehicleSingleVehicleAdded() {
        ComboKR puzzle = new ComboKR();
        Car car1 = new Car(new Integer[]{2, 3}, Axis.Vertical, "C1");
        puzzle.addVehicle(car1);

        ArrayList<Vehicle> expected = new ArrayList<Vehicle>(Arrays.asList(car1));
        ArrayList<Vehicle> actual = puzzle.getVehiclesList();

        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    public void addVehicleMultiVehicleAdded1(){
        ComboKR puzzle = new ComboKR();
        Car car1 = new Car(new Integer[]{2, 3}, Axis.Vertical, "C1");
        Car car2 = new Car(new Integer[]{0, 0}, Axis.Vertical, "C2");
        puzzle.addVehicle(car1);
        puzzle.addVehicle(car2);

        ArrayList<Vehicle> expected = new ArrayList<Vehicle>(Arrays.asList(car1, car2));
        ArrayList<Vehicle> actual = puzzle.getVehiclesList();

        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());

    }

    @Test
    public void addVehicleMultiVehicleAdded2(){
        ComboKR puzzle = new ComboKR();
        Car car1 = new Car(new Integer[]{0, 0}, Axis.Vertical, "C1");
        Car car2 = new Car(new Integer[]{1, 0}, Axis.Vertical, "C2");
        Car car3 = new Car(new Integer[]{2, 0}, Axis.Vertical, "C3");
        Car car4 = new Car(new Integer[]{0, 3}, Axis.Horizontal,"C4");
        Bus bus1 = new Bus(new Integer[]{4, 0}, Axis.Vertical, "B1");

        puzzle.addVehicle(car1);
        puzzle.addVehicle(car2);
        puzzle.addVehicle(car3);
        puzzle.addVehicle(car4);
        puzzle.addVehicle(bus1);

        ArrayList<Vehicle> expected = new ArrayList<Vehicle>(Arrays.asList(car1,car2,car3,car4,bus1));
        ArrayList<Vehicle> actual = puzzle.getVehiclesList();

        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());

    }

    /**
    @Test
    public void addVehicle2DArrayUpdate1(){
        ComboKR puzzle = new ComboKR();
        Car car1 = new Car(new Integer[]{0, 0}, Axis.Vertical, "C1");
        Bus bus1 = new Bus(new Integer[]{4, 0}, Axis.Vertical, "B1");

    }

    @Test
    public void addVehicle2DArrayUpdate2(){
        ComboKR puzzle = new ComboKR();

    }
    **/

    //==============================================================//
    //  getAllMovesSingleVehicle method Test
    //==============================================================//

    @Test
    void getAllMovesSingleCar1(){
        ListKR puzzle = new ListKR();
        Car testCar1 = new Car(new Integer[]{1,2},Axis.Horizontal,"C1");
        Car testCar2 = new Car(new Integer[]{4,4},Axis.Vertical,"C2");
        puzzle.addVehicle(testCar1);
        puzzle.addVehicle(testCar2);
        System.out.println(puzzle.toString());
        puzzle.getAllMovesForSingleVehicle(testCar1);
    }

    @Test
    void getAllMovesSingleCar2(){

    }
    //==============================================================//
    //  addTargetVehicle method Test
    //==============================================================//

    //==============================================================//
    //  ReplaceAllVehicles method Test
    //==============================================================//

    //==============================================================//
    //  moveVehicle method Test
    //==============================================================//
    @Test
    void moveVehicleSingleCarLegalMove(){
        ListKR puzzle = new ListKR();
        Car testCar = new Car(new Integer[]{2,2},Axis.Horizontal,"C1");
        puzzle.addVehicle(testCar);
        puzzle.moveVehicle(testCar,2);


        Integer[] expected = new Integer[]{4,2};
        Integer[] actual = puzzle.getVehicle(0).getHeadLocation().toArray();

        Assertions.assertArrayEquals(expected,actual);

    }

    @Test
    void moveVehicleSingleCarIllegalMove(){
        ListKR puzzle = new ListKR();
        Car testCar1 = new Car(new Integer[]{2,2},Axis.Horizontal,"C1");
        Car testCar2 = new Car(new Integer[]{4,2},Axis.Vertical,"C2");
        puzzle.addVehicle(testCar1);
        puzzle.addVehicle(testCar2);
        puzzle.moveVehicle(testCar1,1);

        Integer[] expected = new Integer[]{2,2};
        Integer[] actual = puzzle.getVehicle(1).getHeadLocation().toArray();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    void moveVehicleMultiCarLegalMove(){


    }

    @Test
    void moveVehicleMultiCarIllegalMove(){


    }
    //==============================================================//
    //  toString method Test
    //==============================================================//
    @Test
    public void toStringDefaultEmpty(){
        ListKR puzzle = new ListKR();
        String expected =
                "  ||  ||  ||  ||  ||  ||\n" +
                        "==||==||==||==||==||==||\n" +
                        "  ||  ||  ||  ||  ||  ||\n" +
                        "==||==||==||==||==||==||\n" +
                        "  ||  ||  ||  ||  ||  ||\n" +
                        "==||==||==||==||==||==||\n" +
                        "  ||  ||  ||  ||  ||  ||\n" +
                        "==||==||==||==||==||==||\n" +
                        "  ||  ||  ||  ||  ||  ||\n" +
                        "==||==||==||==||==||==||\n" +
                        "  ||  ||  ||  ||  ||  ||\n" +
                        "==||==||==||==||==||==||\n";

        String actual = puzzle.toString();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void toStringDefaultfilled1(){
        ListKR puzzle = new ListKR();

        Car car1 = new Car(new Integer[]{2,3},Axis.Vertical, "C1");
        Car car2 = new Car(new Integer[]{4,3},Axis.Horizontal, "C2");
        puzzle.addVehicle(car1);
        puzzle.addVehicle(car2);
        String expected =
                "  ||  ||  ||  ||  ||  ||\n" +
                        "==||==||==||==||==||==||\n" +
                        "  ||  ||  ||  ||  ||  ||\n" +
                        "==||==||==||==||==||==||\n" +
                        "  ||  ||  ||  ||  ||  ||\n" +
                        "==||==||==||==||==||==||\n" +
                        "  ||  ||C1||  ||C2||C2||\n" +
                        "==||==||==||==||==||==||\n" +
                        "  ||  ||C1||  ||  ||  ||\n" +
                        "==||==||==||==||==||==||\n" +
                        "  ||  ||  ||  ||  ||  ||\n" +
                        "==||==||==||==||==||==||\n";

        String actual = puzzle.toString();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void toStringDefaultfilled2(){
        ListKR puzzle = new ListKR();
        Car car1 = new Car(new Integer[]{0,0},Axis.Vertical, "C1");
        Car car2 = new Car(new Integer[]{2,1},Axis.Horizontal, "C2");
        Bus bus1 = new Bus(new Integer[]{4,2},Axis.Vertical, "B1");
        puzzle.addVehicle(car1);
        puzzle.addVehicle(car2);
        puzzle.addVehicle(bus1);
        String expected =
                        "C1||  ||  ||  ||  ||  ||\n" +
                        "==||==||==||==||==||==||\n" +
                        "C1||  ||C2||C2||  ||  ||\n" +
                        "==||==||==||==||==||==||\n" +
                        "  ||  ||  ||  ||B1||  ||\n" +
                        "==||==||==||==||==||==||\n" +
                        "  ||  ||  ||  ||B1||  ||\n" +
                        "==||==||==||==||==||==||\n" +
                        "  ||  ||  ||  ||B1||  ||\n" +
                        "==||==||==||==||==||==||\n" +
                        "  ||  ||  ||  ||  ||  ||\n" +
                        "==||==||==||==||==||==||\n";

        String actual = puzzle.toString();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void toStringCustomEmpty(){
        ListKR puzzle = new ListKR(4,new Integer[]{1,1});
        String expected =
                "  ||  ||  ||  ||\n" +
                        "==||==||==||==||\n" +
                        "  ||  ||  ||  ||\n" +
                        "==||==||==||==||\n" +
                        "  ||  ||  ||  ||\n" +
                        "==||==||==||==||\n" +
                        "  ||  ||  ||  ||\n" +
                        "==||==||==||==||\n";

        String actual = puzzle.toString();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void toStringCustomFilled1(){
        ListKR puzzle = new ListKR(8,new Integer[]{7,7});
        Car car1 = new Car(new Integer[]{1,0},Axis.Vertical, "C1");
        Car car2 = new Car(new Integer[]{3,0},Axis.Horizontal, "C2");
        Car car3 = new Car(new Integer[]{5,2},Axis.Vertical, "C3");
        Car car4 = new Car(new Integer[]{3,3},Axis.Horizontal, "C4");
        Car car5 = new Car(new Integer[]{6,5},Axis.Vertical, "C5");
        Car car6 = new Car(new Integer[]{2,7},Axis.Horizontal, "C6");
        Bus bus1 = new Bus(new Integer[]{2,4},Axis.Vertical, "B1");
        Bus bus2 = new Bus(new Integer[]{3,1},Axis.Horizontal, "B2");
        Bus bus3 = new Bus(new Integer[]{7,2},Axis.Vertical, "B3");
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>(Arrays.asList(car1,car2,car3,car4,car5,car6,bus1,bus2,bus3));
        puzzle.replaceAllVehicles(vehicles);
        System.out.println("\n" + puzzle.getVehicles());
        String expected =
                        "  ||C1||  ||C2||C2||  ||  ||  ||\n" +
                        "==||==||==||==||==||==||==||==||\n" +
                        "  ||C1||  ||B2||B2||B2||  ||  ||\n" +
                        "==||==||==||==||==||==||==||==||\n" +
                        "  ||  ||  ||  ||  ||C3||  ||B3||\n" +
                        "==||==||==||==||==||==||==||==||\n" +
                        "  ||  ||  ||C4||C4||C3||  ||B3||\n" +
                        "==||==||==||==||==||==||==||==||\n" +
                        "  ||  ||B1||  ||  ||  ||  ||B3||\n" +
                        "==||==||==||==||==||==||==||==||\n" +
                        "  ||  ||B1||  ||  ||  ||C5||  ||\n" +
                        "==||==||==||==||==||==||==||==||\n" +
                        "  ||  ||B1||  ||  ||  ||C5||  ||\n" +
                        "==||==||==||==||==||==||==||==||\n" +
                        "  ||  ||C6||C6||  ||  ||  ||  ||\n" +
                        "==||==||==||==||==||==||==||==||\n";

        String actual = puzzle.toString();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void toStringCustomFilled2(){
        ListKR puzzle = new ListKR(5,new Integer[]{0,4});
        Car car1 = new Car(new Integer[]{0,3},Axis.Vertical, "C1");
        Car car2 = new Car(new Integer[]{2,1},Axis.Horizontal, "C2");
        Car car3 = new Car(new Integer[]{3,3},Axis.Vertical, "C3");
        Bus bus1 = new Bus(new Integer[]{0,2},Axis.Horizontal, "B1");
        Bus bus2 = new Bus(new Integer[]{4,1},Axis.Vertical, "B2");

        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>(Arrays.asList(car1,car2,car3,bus1,bus2));
        puzzle.replaceAllVehicles(vehicles);
        String expected =
                "  ||  ||  ||  ||  ||\n" +
                        "==||==||==||==||==||\n" +
                        "  ||  ||C2||C2||B2||\n" +
                        "==||==||==||==||==||\n" +
                        "B1||B1||B1||  ||B2||\n" +
                        "==||==||==||==||==||\n" +
                        "C1||  ||  ||C3||B2||\n" +
                        "==||==||==||==||==||\n" +
                        "C1||  ||  ||C3||  ||\n" +
                        "==||==||==||==||==||\n";

        String actual = puzzle.toString();

        Assertions.assertEquals(expected,actual);
    }



    //
    //
    //

    @Test
    public void singleVehiclepossibleMovesTest(){
        ListKR puzzle = new ListKR(5,new Integer[]{0,4});
        Car car1 = new Car(new Integer[]{0,3},Axis.Vertical, "C1");
        puzzle.addVehicle(car1);
        System.out.println(puzzle.toString());

        ArrayList<Location> d = puzzle.singleVehiclepossibleMoves(car1);
        for (Location a:d) {
            System.out.println(a.toString());
        }

    }

    @Test
    public void singleVehicleMovesTest(){
        ListKR puzzle = new ListKR(5,new Integer[]{0,4});
        Car car1 = new Car(new Integer[]{0,3},Axis.Vertical, "C1");
        puzzle.addVehicle(car1);
        System.out.println(puzzle.toString());

        ArrayList<PuzzleKR> d = puzzle.getAllMovesForSingleVehicle(car1);
        for (PuzzleKR a:d) {
            System.out.println(a.toString());
        }

    }
}
