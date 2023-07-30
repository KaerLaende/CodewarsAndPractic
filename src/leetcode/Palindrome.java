package leetcode;

import static java.lang.Character.isLetterOrDigit;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
 * non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
/*
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
 */

public class Palindrome {
    public static boolean isPalindrome(String s) {

        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (!isLetterOrDigit(chars[left])) {
                left++;
                continue;
            }
            if (!isLetterOrDigit(chars[right])) {
                right--;
                continue;
            }
            if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(".,"));
    }
}
