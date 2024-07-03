package quicksort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuickSortTest {

    @Test
    public void testSingleDigit() {
        assertEquals(5, QuickSort.sortDesc(5));
    }

    @Test
    public void testZero() {
        assertEquals(0, QuickSort.sortDesc(0));
    }

    @Test
    public void testTwoDigits() {
        assertEquals(31, QuickSort.sortDesc(13));
    }


    @Test
    public void testWithSomeEqualNumbers() {
        assertEquals(66553, QuickSort.sortDesc(65536));
    }

    @Test
    public void testMultipleDigits() {
        assertEquals(321, QuickSort.sortDesc(123));
    }

    @Test
    public void testAlreadyDescending() {
        assertEquals(987, QuickSort.sortDesc(987));
    }

    @Test
    public void testWithZeros() {
        assertEquals(3210, QuickSort.sortDesc(1230));
    }

    @Test
    public void testAllSameDigits() {
        assertEquals(444, QuickSort.sortDesc(444));
    }

    @Test
    public void testLongNumber() {
        assertEquals(987654321, QuickSort.sortDesc(123456789));
    }

    @Test
    public void testNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuickSort.sortDesc(-123);
        });
    }
}

