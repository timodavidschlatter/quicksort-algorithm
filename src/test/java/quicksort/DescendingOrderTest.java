package quicksort;

import org.junit.jupiter.api.Test;
import quicksort.DescendingOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DescendingOrderTest {

    @Test
    public void testSingleDigit() {
        assertEquals(5, DescendingOrder.sortDesc(5));
    }

    @Test
    public void testZero() {
        assertEquals(0, DescendingOrder.sortDesc(0));
    }

    @Test
    public void testTwoDigits() {
        assertEquals(31, DescendingOrder.sortDesc(13));
    }


    @Test
    public void testWithSomeEqualNumbers() {
        assertEquals(66553, DescendingOrder.sortDesc(65536));
    }

    @Test
    public void testMultipleDigits() {
        assertEquals(321, DescendingOrder.sortDesc(123));
    }

    @Test
    public void testAlreadyDescending() {
        assertEquals(987, DescendingOrder.sortDesc(987));
    }

    @Test
    public void testWithZeros() {
        assertEquals(3210, DescendingOrder.sortDesc(1230));
    }

    @Test
    public void testAllSameDigits() {
        assertEquals(444, DescendingOrder.sortDesc(444));
    }

    @Test
    public void testLongNumber() {
        assertEquals(987654321, DescendingOrder.sortDesc(123456789));
    }

    @Test
    public void testNegativeNumber() {
        assertThrows(NumberFormatException.class, () -> {
            DescendingOrder.sortDesc(-123);
        });
    }
}

