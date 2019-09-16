package week2;

import static org.junit.jupiter.api.Assertions.*;

class MaximumIntSortingTest {

    @org.junit.jupiter.api.Test
    void maximum() {
        int[] values = {5, 7, 9, 2, 1, 11, 13, 8};

        assertEquals(13, MaximumIntSorting.maximum(values, 0, values.length));
        assertEquals(11, MaximumIntSorting.maximum(values, 3, 6));

        //assertThrows();

        //assertThrows(ArrayIndexOutOfBoundsException.class, MaximumIntSorting.maximum(values))
    }
}