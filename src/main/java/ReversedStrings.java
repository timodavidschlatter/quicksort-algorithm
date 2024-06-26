import java.util.ArrayList;
import java.util.stream.Collectors;

public class ReversedStrings {

    public static String solution(String str) {

        // Time and Space Complexity: O(n)
        // 1. Create ArrayList with initial values of the chars in the correct order.
        ArrayList<Character> charList = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(ArrayList::new));

        // Time and Space Complexity: O(n)
        // 2. Reverse the characters.
        for (int i = 0; i < str.length(); i++) {
            charList.set(str.length() - 1 - i, str.charAt(i));
        }

        // Time and Space Complexity: O(n)
        // 3. Create a String out of the ArrayList.
        return charList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static String solution2(String str) {

        /**
         * So, was will ich machen:
         * 1. Code verringern.
         * 2. Space und time Complexity verbessern falls möglich?
         */

        /**
         * CODE VERRINGERN
         * - Macht es Sinn, dass ich eine ArrayList benutze?
         * - Kann ich den Algorithmus verbessern?
         *
         * Ich erhalte einen String und muss einen String zurückgeben. Ein
         * String ist basically nur ein Array von chars. Kann ich damit arbeiten?
         *
         *
         */
        char[] returnStr = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            returnStr[str.length() - 1 - i] = str.charAt(i);
        }

        return new String(returnStr);
    }

    public static String solution3(String str) {

        // Use Streams instead of shitty programming (lol)
        // Weiss ich zu wenig darüber dass ich das anwenden könnte.

        //str.chars().map()

        return "";
    }

    public static String solution4(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String solution5(String str) {

        /**
         * Kann ich den Algorithmus anpassen? Gibt es etwas schnelleres?
         *
         * Ich kann die Chars tauschen anstatt ganz durchzuloopen.
         */

        int startPointer = 0;
        int endPointer = str.length() - 1;
        char[] chars = str.toCharArray();

        while (startPointer < endPointer) {
            char temp = chars[endPointer];
            chars[endPointer] = chars[startPointer];
            chars[startPointer] = temp;
            startPointer++;
            endPointer--;
        }

        return new String(chars);
    }
}
