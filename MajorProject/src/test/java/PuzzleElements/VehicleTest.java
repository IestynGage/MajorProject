package PuzzleElements;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class VehicleTest {
  /**
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
**/
    @Test
    public void carGetWholeBodyLocationHorizontal(){
        Car testCar = new Car(new Integer[]{3,3},Axis.Horizontal,"C1");
        ArrayList<Location> actualList = testCar.getWholeBodyLocation();
        Integer[] expected0 = new Integer[]{3,3};
        Integer[] expected1 = new Integer[]{3,4};

        Assertions.assertArrayEquals(expected0,actualList.get(0).toArray());
        Assertions.assertArrayEquals(expected1,actualList.get(1).toArray());
    }

    @Test
    public void carGetWholeBodyLocationVertical(){
        Car testCar1 = new Car(new Integer[]{3,3},Axis.Vertical,"C1");
        Car testCar2 = new Car(new Integer[]{2,3},Axis.Vertical, "C2");
        ArrayList<Location> actualList1 = testCar1.getWholeBodyLocation();
        ArrayList<Location> actualList2 = testCar2.getWholeBodyLocation();

        Integer[] car1Expected0 = new Integer[]{3,3};
        Integer[] car1Expected1 = new Integer[]{4,3};

        Integer[] car2Expected0 = new Integer[]{2,3};
        Integer[] car2Expected1 = new Integer[]{3,3};

        Assertions.assertArrayEquals(car1Expected0,actualList1.get(0).toArray());
        Assertions.assertArrayEquals(car1Expected1,actualList1.get(1).toArray());

        Assertions.assertArrayEquals(car2Expected0,actualList2.get(0).toArray());
        Assertions.assertArrayEquals(car2Expected1,actualList2.get(1).toArray());
    }
    @Test
    public void carToStringTest(){
        Car testCar = new Car(new Integer[]{3,3},Axis.Horizontal,"C1");

        String expected = "C1";
        String actual = testCar.toString();

        Assertions.assertEquals(expected,actual);
    }
/**
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
**/
    @Test
    public void busGetWholeBodyLocationHorizontal(){
        Bus testBus = new Bus(new Integer[]{3,3},Axis.Horizontal,"B1");
        ArrayList<Location> actualList = testBus.getWholeBodyLocation();
        Integer[] expected0 = new Integer[]{3,3};
        Integer[] expected1 = new Integer[]{3,4};
        Integer[] expected2 = new Integer[]{3,5};

        Assertions.assertArrayEquals(expected0,actualList.get(0).toArray());
        Assertions.assertArrayEquals(expected1,actualList.get(1).toArray());
        Assertions.assertArrayEquals(expected2,actualList.get(2).toArray());
    }

    @Test
    public void busGetWholeBodyLocationVertical(){
        Bus testBus = new Bus(new Integer[]{3,3},Axis.Vertical,"B1");
        ArrayList<Location> actualList = testBus.getWholeBodyLocation();
        Integer[] expected0 = new Integer[]{3,3};
        Integer[] expected1 = new Integer[]{4,3};
        Integer[] expected2 = new Integer[]{5,3};

        Assertions.assertArrayEquals(expected0,actualList.get(0).toArray());
        Assertions.assertArrayEquals(expected1,actualList.get(1).toArray());
        Assertions.assertArrayEquals(expected2,actualList.get(2).toArray());
    }
    @Test
    public void busToStringTest(){
        Bus testBus = new Bus(new Integer[]{3,3},Axis.Horizontal,"B1");

        String expected = "B1";
        String actual = testBus.toString();

        Assertions.assertEquals(expected,actual);
    }


}
