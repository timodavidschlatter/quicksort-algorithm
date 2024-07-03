package quicksort;

import java.util.Arrays;
import java.util.Collections;

/**
 * Initially this was a kata from Codewars (Link: https://www.codewars.com/kata/5467e4d82edf8bbf40000155/java).
 * The task was to create a function to sort the digits of an integer descending.
 * I decided to manually implemented a quicksort algorithm for practice.
 */
public class QuickSort {

    /**
     * The main method which takes the input number, starts the quicksort and returns the result.
     * @param num The input number
     * @return The number with the digits in descending order.
     */
    public static int sortDesc(final int num) {

        if (num < 0) {
            throw new IllegalArgumentException("Input number must be non-negative");
        }

        int[] digits = intToArray(num);
        quickSort(digits, 0, digits.length - 1);

        StringBuilder sb = new StringBuilder(digits.length);
        for (int digit : digits) {
            sb.append(digit);
        }

        return Integer.parseInt(sb.toString());
    }

    /**
     * Quicksort Algorithm (in-place)
     * The pivot element is always the digit on the left.
     * @param digits The int[] to sort
     * @param left The start index of the array to sort in the recursion
     * @param right The end index of the array to sort in the recursion
     */
    private static void quickSort(int[] digits, int left, int right) {

        if (left >= right) {
            return;
        }

        int p = left; // Pivot element
        int i = p + 1; // The left pointer going right
        int j = right; // The right pointer going left

        while (i <= j) {
            if (digits[i] <= digits[p]) {
                while (j >= i) {
                    if (digits[j] > digits[p]) {
                        swap(digits, i, j);
                        break;
                    }
                    j--; // Move left
                }
            }
            i++; // Move right
        }

        if (digits[j] > digits[p]) {
            swap(digits, j, p);
            p = j;
        }

        quickSort(digits, left, p - 1);
        quickSort(digits, p + 1, right);
    }

    /**
     * Alternative sorting method using Java built-in sort.
     * According to ChatGPT, "Arrays.sort()" uses a Dual-Pivot Quicksort algorithm
     * for primitive arrays (int, char, etc.) and a Timsort algorithm for Object arrays.
     * @param num The input integer to be sorted.
     * @return The integer with the numbers sorted in desc.
     */
    public static int sortDescInJava(int num) {
        String[] array = String.valueOf(num).split("");
        Arrays.sort(array, Collections.reverseOrder());
        return Integer.valueOf(String.join("", array));
    }

    /**
     * Swaps two numbers within the given array.
     * @param digits Input array
     * @param i1 Array index of the first number
     * @param i2 Array index of the second number
     */
    private static void swap(int[] digits, int i1, int i2) {
        int temp = digits[i1];
        digits[i1] = digits[i2];
        digits[i2] = temp;
    }

    /**
     * Transforms an integer to an int[]
     * @param num Input integer
     * @return The int[]
     */
    private static int[] intToArray(int num) {
        return Integer.toString(num).chars().map(c -> c - '0').toArray();
    }
}
