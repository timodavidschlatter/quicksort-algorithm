public class DescendingOrder {

    public static int sortDesc(final int num) {
        int[] digits = intToArray(num);
        recursion(digits, 0, digits.length - 1);

        StringBuilder sb = new StringBuilder();
        for (int i : digits) {
            sb.append(i);
        }
        int result = Integer.parseInt(sb.toString());
        System.out.println(result);
        return result;
    }

    /**
     * Quicksort Algorithm.
     * @param allDigits The int[] to sort
     * @param startOfSubList The start index of the list to sort in the recursion
     * @param endOfSubList The end index of the list to sort in the recursion
     * @return The sorted list
     */
    private static void recursion(int[] allDigits, int startOfSubList, int endOfSubList) {

        // TODO: Was wenn es Zahlen hat, welche gleich gross sind wie das Pivot?
        /*
         6 4 2 5 3 1 7 9 8
         Case 1: Int Array ist nur 1 lang.
                 Ist bereits sortiert.

         Case 2: Int array ist 2 lang.
                 Prüfen, ob die erste Zahl kleiner ist als die zweite.
                    Ja: switchNumbers();
                    Nein: Do Nothing.

         Case 3: Int array ist 3 lang.
                 Regulärer Ablauf vom Quicksort Algorithmus
                 1. index p = z1, index i = z2, index j = z3
                 2. i sucht Zahlen, welche kleiner als p sind
                 3. j sucht Zahlen, welche grösser als p sind
                 4. Wenn i und j eine Zahl gefunden haben, -> switchNumbers(i, j)
                 5. Überkreuzt: Wenn j grösser p -> switchNumbers(j, p)
                 6. Neuer Durchgang: recursion
         */

        /* Nur ein Element in der Subliste (Beide Indexe zeigen auf das gleiche Element)
           Es gibt nichts zu sortieren. */
        if (endOfSubList - startOfSubList == 0) {
            return;
        }

        /*
        Die Subliste hat zwei Elemente.
        Falls das erste Element kleiner ist als das zweite: Nummern tauschen
         */
        if (endOfSubList - startOfSubList == 1) {
            if (allDigits[startOfSubList] < allDigits[endOfSubList]) {
                switchNumbers(allDigits, startOfSubList, endOfSubList);
            }
            return;
        }

        /* Ab drei Elementen in der Subliste beginnt der Algorithmus. */
        int p = startOfSubList; // Pivot Element (immer das erste Element)
        int i = p + 1; // Index vom linken Pointer i, welcher nach rechts durchläuft
        int j = endOfSubList; // Index vom rechten Pointer j, welcher nach links durchläuft

        while (i <= j && i <= endOfSubList) { // Bedingung um i nach rechts zu bewegen: Noch nicht überkreuzt und noch nicht am Ende vom Array.

            if (allDigits[i] <= allDigits[p]) { // i < p

                while (j >= i && j > startOfSubList) { // Bedingung um j nach links zu bewegen: Noch nicht überkreuzt und vor dem Pivot Element anhalten.

                    if (allDigits[j] > allDigits[p]) { // j > p

                        switchNumbers(allDigits, i, j); // Zahlen tauschen
                        break; // Innerer Loop von J muss abgebrochen werden, weil ansonsten, sollte j nochmals
                               // j > p finden, wird das j mit dem gleichen i wie vorher getauscht.
                    }

                    j--; // Eine Zahl weiter nach links gehen.
                }
            }

            i++; // Eine Zahl weiter nach rechts gehen.
        }

        /*
            // So jetzt muss die eigentliche Rekursion erfolgen, weil wir den Durchlauf neustarten.
            // Wir wissen jetzt, dass das Pivot-Element am richtigen Ort ist.
            // Dieses Element müssen wir also nicht mehr anfassen. Es gibt aber mehrere Cases dazu.
            // Case 1: Das Pivot Element wurde getauscht. Das Pivot Element ist also irgendwo innerhalb der Liste.
            //         Es gibt also zwei Rekursionen. Einerseits die Liste vor Pivot, die Liste nach dem Pivot Element.

            // Case 2: Das Pivot Element wurde nicht getauscht. Das Pivot Element steht auch am richtigen Ort.
            //         Es gibt also nur eine Rekursion. Und zwar die von der Liste NACH dem Pivot Element.

            // TODO Kann ich das kombinieren? Also müssen es zwei Cases sein? Weil vielleicht kann ich
            // TODO auch beim zweiten Case das so in den ersten integrieren, dass es zwei Rekursionen startet
            // TODO aber die eine wird direkt wieder abgebrochen. Das sollte auch vom Aufwand überschaubar sein
            // TODO würde aber den code vereinfachen.
            // Ich glaube nicht, dass das geht. Ich muss wissen, wo sich das Pivot Element befindet.
            // Also unterscheidet es sich, ob es getauscht wurde oder nicht. Ich brauche in jedem Fall beide Cases.

            // TODO: Überkreuzung: Stimmt die Logik dahinter?
            // So nach dem Ende des While-Loops müssten die Zahlen jetzt überkreuzt sein.
            // Also sollte ich jetzt nur noch prüfen müssen, ob j > p ist
            // Falls ja: Tauschen. Falls nein: Nichts. p ist am richtigen Ort.
        */

        // Pivot Element muss getauscht werden.
        if (allDigits[j] > allDigits[p]) { // j > p
            switchNumbers(allDigits, j, p);
            p = j; // Das Pivot Element befindet sich jetzt am Index von j
        }

        if (p == startOfSubList) {
            // Case 2: Pivot Element ist ganz links richtig.
            recursion(allDigits, p + 1, endOfSubList);
        } else if (p == endOfSubList) {
            // Case 3: Pivot Element ist ganz rechts richtig.
            recursion(allDigits, startOfSubList, p - 1); // Start ist der Anfang vom Array und Ende eins links neben dem Pivot
        } else {
            // Case 1: Pivot Element wurde in die Mitte geswitcht.
            recursion(allDigits, startOfSubList, j - 1); // Linke Seite vom Pivot. Endet eins links neben dem Pivot.
            recursion(allDigits, j + 1, endOfSubList); // Rechte Seite vom Pivot. Endet am Schluss der Liste.
        }
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
