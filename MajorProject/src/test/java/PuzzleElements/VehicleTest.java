package PuzzleElements;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class VehicleTest {
    @Test
    public void carVerticalMoveTest(){
        Integer[] theLocation = new Integer[]{3,3};
        Car testCar = new Car(theLocation,Axis.Vertical,"C1");
        testCar.move(3);

        Integer[] expected = new Integer[]{3,6};
        Integer[] actual = testCar.getHeadLocation();
        Assertions.assertArrayEquals(expected,actual);

    }

    @Test
    public void carHorizontalMoveTest(){
        Integer[] theLocation = new Integer[]{3,3};
        Car testCar = new Car(theLocation,Axis.Horizontal,"C1");
        testCar.move(3);

        Integer[] expected = new Integer[]{6,3};
        Integer[] actual = testCar.getHeadLocation();
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void carMoveOutOfRangeTest(){
        Integer[] theLocation = new Integer[]{3,3};
        Car testCar = new Car(theLocation,Axis.Horizontal,"C1");
        testCar.move(-5);

        Integer[] expected = new Integer[]{3,3};
        Integer[] actual = testCar.getHeadLocation();
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void carToStringTest(){
        Car testCar = new Car(new Integer[]{3,3},Axis.Horizontal,"C1");

        String expected = "C1";
        String actual = testCar.toString();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void busVerticalMoveTest(){
        Integer[] theLocation = new Integer[]{3,3};
        Bus testBus = new Bus(theLocation,Axis.Vertical,"B1");
        testBus.move(3);

        Integer[] expected = new Integer[]{3,6};
        Integer[] actual = testBus.getHeadLocation();
        Assertions.assertArrayEquals(expected,actual);

    }

    @Test
    public void busHorizontalMoveTest(){
        Integer[] theLocation = new Integer[]{3,3};
        Bus testBus = new Bus(theLocation,Axis.Horizontal,"B1");
        testBus.move(3);

        Integer[] expected = new Integer[]{6,3};
        Integer[] actual = testBus.getHeadLocation();
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void busMoveOutOfRangeTest(){
        Integer[] theLocation = new Integer[]{3,3};
        Bus testBus = new Bus(theLocation,Axis.Horizontal,"B1");
        testBus.move(-5);

        Integer[] expected = new Integer[]{3,3};
        Integer[] actual = testBus.getHeadLocation();
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void busToStringTest(){
        Bus testBus = new Bus(new Integer[]{3,3},Axis.Horizontal,"B1");

        String expected = "B1";
        String actual = testBus.toString();

        Assertions.assertEquals(expected,actual);
    }


}
