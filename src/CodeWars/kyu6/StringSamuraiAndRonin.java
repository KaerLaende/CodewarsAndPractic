package CodeWars.kyu6;
/*
Complete the method so that it formats the words into a single comma separated value. The last word should be separated by the word 'and' instead of a comma. The method takes in an array of strings and returns a single formatted string.

Note:

Empty string values should be ignored.
Empty arrays or null/nil/None values being passed into the method should result in an empty string being returned.
Example: (Input --> output)

['ninja', 'samurai', 'ronin'] --> "ninja, samurai and ronin"
['ninja', '', 'ronin'] --> "ninja and ronin"
[] -->""
 */

import java.util.Arrays;

public class StringSamuraiAndRonin {


    public static String formatWords(String[] words) {
        StringBuilder stringBuilder = new StringBuilder();
        if (words != null) {
            for (int i = 0; i < words.length; i++) {
                if (!words[i].isBlank() && !words[i].isEmpty()) {
                    stringBuilder.append(words[i]).append(", ");
                }
            }
            if (stringBuilder.lastIndexOf(",") == (stringBuilder.length() - 2)) {
                stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(",")).deleteCharAt(stringBuilder.lastIndexOf(" "));
            }
            if (stringBuilder.lastIndexOf(",") != -1)
                stringBuilder.replace(stringBuilder.lastIndexOf(","), stringBuilder.lastIndexOf(",") + 1, " and");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] one = new String[]{"one", "two", "three", "four"};
        String[] two = new String[]{"one", "", "three"};
        String[] third = new String[]{"", "", "three"};
        String[] str4 = new String[]{"one", "two", ""};
        System.out.println(formatWords(str4));
    }


}
