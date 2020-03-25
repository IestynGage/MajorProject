package PuzzleElements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LocationTest {
    //==============================================================//
    //  Constructer method Test
    //==============================================================//

    @Test
    public void LocationDeepCopyTest(){
        Location actual = new Location(3,4);
        Location clone = new Location(actual);
        clone.add(Axis.Vertical,5);

        Location expected = new Location(3,4);

        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());


    }
}
