package Other;

import java.util.HashMap;
import java.util.HashSet;

public class StringNoDuplicate {

    public static int getNoDuplicateStringLength(String str){
        HashSet<Character> charSet = new HashSet<>();
        char[] letters=str.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            charSet.add(letters[i]);
        }
        return charSet.size();
    }
    // "abcabcbbc"
//    public static int lengthOfLongestSubstring(String str){
//        char[] letter = str.toCharArray();
//        boolean flag = false;
//        for (int i = 0, j = letter.length; i < letter.length; i++, j--) {
//            HashSet<Character> testCharSet = new HashSet<>();
//            testCharSet.add(letter[i]);
//        }
//    }



    public static void main(String[] args) {
        String str = "aabbcc";
        System.out.println(getNoDuplicateStringLength(str));
    }

}
