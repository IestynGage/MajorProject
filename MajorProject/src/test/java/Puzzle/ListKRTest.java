package Puzzle;

import PuzzleElements.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ListKRTest {

    //==============================================================//
    //  Constructer method Test
    //==============================================================//
    @Test
    void ListKrDeepCloneVehiclesTest(){
        ListKR puzzle = new ListKR();
        Car car1 = new Car(new Integer[]{2, 3}, Axis.Vertical, "C1");
        puzzle.addVehicle(car1);

        ListKR clone = new ListKR(puzzle);
        Vehicle a = clone.getVehicle("C1");
        clone.moveVehicle(a,2);

        Integer[] expected = new Integer[]{2,3};
        Integer[] actual = puzzle.getVehicle("C1").getHeadLocation().toArray();
        Assertions.assertArrayEquals(expected,actual);

    }

    @Test
    void ListKrDeepCloneTargetCarTest(){
        ListKR puzzle = new ListKR();
        Car car1 = new Car(new Integer[]{2, 3}, Axis.Vertical, "C1");
        Car targetCar = new Car(new Integer[]{5, 5}, Axis.Vertical, "C1");
        puzzle.addVehicle(car1);
        puzzle.addTargetVehicle(targetCar);

        ListKR clone = new ListKR(puzzle);

    }

    //==============================================================//
    //  addVehicle method Test
    //==============================================================//
    @Test
    void addVehicleSingleVehicleAdded() {
        ListKR puzzle = new ListKR();
        Car car1 = new Car(new Integer[]{2, 3}, Axis.Vertical, "C1");
        puzzle.addVehicle(car1);

        ArrayList<Vehicle> expected = new ArrayList<Vehicle>(Collections.singletonList(car1));
        ArrayList<Vehicle> actual = puzzle.getVehicles();

        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    void addVehicleMultiVehicleAdded1(){
        ListKR puzzle = new ListKR();
        Car car1 = new Car(new Integer[]{2, 3}, Axis.Vertical, "C1");
        Car car2 = new Car(new Integer[]{0, 0}, Axis.Vertical, "C2");
        puzzle.addVehicle(car1);
        puzzle.addVehicle(car2);

        ArrayList<Vehicle> expected = new ArrayList<Vehicle>(Arrays.asList(car1, car2));
        ArrayList<Vehicle> actual = puzzle.getVehicles();

        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());

    }

    @Test
    void addVehicleMultiVehicleAdded2(){
        ListKR puzzle = new ListKR();
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

        ArrayList<Vehicle> expected = new ArrayList<>(Arrays.asList(car1,car2,car3,car4,bus1));
        ArrayList<Vehicle> actual = puzzle.getVehicles();

        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());

    }

    /**
    @Test
    public void addVehicle2DArrayUpdate1(){
        ListKR puzzle = new ListKR();
        Car car1 = new Car(new Integer[]{0, 0}, Axis.Vertical, "C1");
        Bus bus1 = new Bus(new Integer[]{4, 0}, Axis.Vertical, "B1");

    }

    @Test
    public void addVehicle2DArrayUpdate2(){
        ListKR puzzle = new ListKR();

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
    void toStringDefaultEmpty(){
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
    void toStringDefaultfilled1(){
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
    void toStringDefaultfilled2(){
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
    void toStringCustomEmpty(){
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
    void toStringCustomFilled1(){
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
        ArrayList<Vehicle> vehicles = new ArrayList<>(Arrays.asList(car1,car2,car3,car4,car5,car6,bus1,bus2,bus3));
        puzzle.replaceAllVehicles(vehicles);

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
    void toStringCustomFilled2(){
        ListKR puzzle = new ListKR(5,new Integer[]{0,4});
        Car car1 = new Car(new Integer[]{0,3},Axis.Vertical, "C1");
        Car car2 = new Car(new Integer[]{2,1},Axis.Horizontal, "C2");
        Car car3 = new Car(new Integer[]{3,3},Axis.Vertical, "C3");
        Bus bus1 = new Bus(new Integer[]{0,2},Axis.Horizontal, "B1");
        Bus bus2 = new Bus(new Integer[]{4,1},Axis.Vertical, "B2");

        ArrayList<Vehicle> vehicles = new ArrayList<>(Arrays.asList(car1,car2,car3,bus1,bus2));
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
    void isCompleteTrueTest(){
        ListKR puzzle = new ListKR();
        Car target = new Car(new Integer[]{4,2},Axis.Horizontal, "RR");
        puzzle.addTargetVehicle(target);
        Boolean actual = puzzle.isPuzzleComplete();
        System.out.println(puzzle.toString());

        Assertions.assertEquals(true,actual);
    }


    //
    //
    //

    @Test
    void singleVehiclepossibleMovesArrayLengthTest(){
        ListKR puzzle = new ListKR(5,new Integer[]{0,4});
        Car car1 = new Car(new Integer[]{0,3},Axis.Vertical, "C1");
        puzzle.addVehicle(car1);

        ArrayList<Location> actual = puzzle.getSingleVehiclePossibleMoves(car1);
        ArrayList<Location> expected = new ArrayList<>(Arrays.asList(new Location(0,0),new Location(0,1),new Location(0,2)));

        if(actual.size()!=expected.size()){
            Assertions.fail("singleVehiclePossibleMoveTest fail: actual arrayList and expected different lengths");
        }
    }

    @Test
    void singleVehiclepossibleMovesTest(){
        ListKR puzzle = new ListKR(5,new Integer[]{0,4});
        Car car1 = new Car(new Integer[]{0,3},Axis.Vertical, "C1");
        puzzle.addVehicle(car1);

        ArrayList<Location> actual = puzzle.getSingleVehiclePossibleMoves(car1);
        ArrayList<Location> expected = new ArrayList<>(Arrays.asList(new Location(0,0),new Location(0,1),new Location(0,2)));

        for (Location check:expected) {
            if(!actual.contains(check)){
                Assertions.fail("singleVehiclePossibleMoveTest fail: Didn't contain expected location \n" +
                        "Expected location:" + check.toString());

            }
        }
    }

    @Test
    void singleVehicleMovesTest(){
        ListKR puzzle = new ListKR(5,new Integer[]{0,4});
        Car car1 = new Car(new Integer[]{0,3},Axis.Vertical, "C1");
        puzzle.addVehicle(car1);


        ArrayList<PuzzleKR> d = puzzle.getAllMovesForSingleVehicle(car1);
        //d.get(1).moveVehicle(car1,1);

        for (PuzzleKR a:d) {
            System.out.println(a.toString());
        }

    }

    @Test
    void getAllMovesForAllVehiclesTest(){
        ListKR puzzle = new ListKR();
        Car car1 = new Car(new Integer[]{2,3}, Axis.Horizontal, "C1");
        Car car2 = new Car(new Integer[]{2,4},Axis.Horizontal, "C2");
        Car target = new Car(new Integer[]{1,2},Axis.Horizontal, "RR");
        Bus bus1 = new Bus(new Integer[]{3,0},Axis.Vertical, "B1");
        puzzle.addVehicle(car1);
        puzzle.addVehicle(car2);
        puzzle.addVehicle(bus1);

        puzzle.addTargetVehicle(target);


        ArrayList<Location> expected = puzzle.getSingleVehiclePossibleMoves(car1);
        for (Location a:expected) {
            System.out.println(a.toString());
        }
        ArrayList<PuzzleKR> a = puzzle.getAllMovesForSingleVehicle(car1);
        for (PuzzleKR c:a) {
            System.out.println(c.toString());
        }

    }
}
