package quicksort;

import java.util.Arrays;
import java.util.Collections;

public class DescendingOrder {

    public static int sortDesc(final int num) {

        if (num < 0) {
            throw new IllegalArgumentException("Input number must be non-negative");
        }

        int[] digits = intToArray(num);
        quicksort(digits, 0, digits.length - 1);

        StringBuilder sb = new StringBuilder();
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
    private static void quicksort(int[] digits, int left, int right) {

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

                        /* Break inner loop of j. Otherwise, if the loop continues and j finds again a "j > p",
                        the new number j is again switched with the same number i as before. */
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

        quicksort(digits, left, p - 1);
        quicksort(digits, p + 1, right);
    }

    /**
     * Alternative sorting method using Java built-in sort
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

    private static void swap(int[] digits, int i1, int i2) {
        int temp = digits[i1];
        digits[i1] = digits[i2];
        digits[i2] = temp;
    }

    private static int[] intToArray(int num) {
        return Integer.toString(num).chars().map(c -> c - '0').toArray();
    }
}
