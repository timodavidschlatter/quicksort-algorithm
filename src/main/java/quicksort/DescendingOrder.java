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
        for (int i : digits) {
            sb.append(i);
        }

        int result = Integer.parseInt(sb.toString());
        System.out.println(result);
        return result;
    }

    /**
     * Quicksort Algorithm (in-place)
     * @param digits The int[] to sort
     * @param startOfSubArray The start index of the array to sort in the recursion
     * @param endOfSubArray The end index of the array to sort in the recursion
     */
    private static void quicksort(int[] digits, int startOfSubArray, int endOfSubArray) {

        /* Nur ein Element in der Subliste (Beide Indexe zeigen auf das gleiche Element)
           Es gibt nichts zu sortieren. */
        if (endOfSubArray - startOfSubArray == 0) {
            return;
        }

        /*
        Die Subliste hat zwei Elemente.
        Falls das erste Element kleiner ist als das zweite: Nummern tauschen
         */
        if (endOfSubArray - startOfSubArray == 1) {
            if (digits[startOfSubArray] < digits[endOfSubArray]) {
                switchNumbers(digits, startOfSubArray, endOfSubArray);
            }
            return;
        }

        int p = startOfSubArray; // Pivot Element (immer das erste Element)
        int i = p + 1; // Index vom linken Pointer i, welcher nach rechts durchläuft
        int j = endOfSubArray; // Index vom rechten Pointer j, welcher nach links durchläuft

        while (i <= j && i <= endOfSubArray) { // Bedingung um i nach rechts zu bewegen: Noch nicht überkreuzt und noch nicht am Ende vom Array.

            if (digits[i] <= digits[p]) { // i < p

                while (j >= i && j > startOfSubArray) { // Bedingung um j nach links zu bewegen: Noch nicht überkreuzt und vor dem Pivot Element anhalten.

                    if (digits[j] > digits[p]) { // j > p

                        switchNumbers(digits, i, j); // Zahlen tauschen
                        break; // Innerer Loop von J muss abgebrochen werden, weil ansonsten, sollte j nochmals
                               // j > p finden, wird das j mit dem gleichen i wie vorher getauscht.
                    }

                    j--; // Eine Zahl weiter nach links gehen.
                }
            }

            i++; // Eine Zahl weiter nach rechts gehen.
        }

        // Pivot Element muss getauscht werden.
        if (digits[j] > digits[p]) { // j > p
            switchNumbers(digits, j, p);
            p = j; // Das Pivot Element befindet sich jetzt am Index von j
        }

        if (p == startOfSubArray) {
            // Case 2: Pivot Element ist ganz links richtig.
            quicksort(digits, p + 1, endOfSubArray);
        } else if (p == endOfSubArray) {
            // Case 3: Pivot Element ist ganz rechts richtig.
            quicksort(digits, startOfSubArray, p - 1); // Start ist der Anfang vom Array und Ende eins links neben dem Pivot
        } else {
            // Case 1: Pivot Element wurde in die Mitte geswitcht.
            quicksort(digits, startOfSubArray, j - 1); // Linke Seite vom Pivot. Endet eins links neben dem Pivot.
            quicksort(digits, j + 1, endOfSubArray); // Rechte Seite vom Pivot. Endet am Schluss der Liste.
        }
    }

    /**
     * How sorting can be used with the implemented version in Java.
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

    private static void switchNumbers(int[] digits, int i1, int i2) {
        int temp = digits[i1];
        digits[i1] = digits[i2];
        digits[i2] = temp;
    }

    private static int[] intToArray(int num) {
        // Convert the integer to a string
        String numStr = Integer.toString(num);

        // Create an array of integers with the same length as the string
        int[] digits = new int[numStr.length()];

        // Iterate over each character in the string
        for (int i = 0; i < numStr.length(); i++) {
            // Convert the character to an integer and store it in the array
            digits[i] = numStr.charAt(i) - '0';
        }

        return digits;
    }
}
