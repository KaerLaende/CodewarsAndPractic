package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply
 * X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four. T
 * he same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 */

/*
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class RomanToInt {
    static public int romanToInt(String s) {
        Map<Character,Integer> romanMap= new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);
        short sum = 0;
        int first = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int second = romanMap.get(ch);
            if (first<second){
                sum-=2*first;
            }
        	first = romanMap.get(ch);
            sum+=second;
        }
        return sum;
    }

    static public int romanToInt2(String s) {
        int[] romanValues = new int[26];
        romanValues['I' - 'A'] = 1;
        romanValues['V' - 'A'] = 5;
        romanValues['X' - 'A'] = 10;
        romanValues['L' - 'A'] = 50;
        romanValues['C' - 'A'] = 100;
        romanValues['D' - 'A'] = 500;
        romanValues['M' - 'A'] = 1000;
        int sum = 0;
        int prevValue = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int currValue = romanValues[ch - 'A'];
            if (currValue > prevValue) {
                sum -= 2 * prevValue;
            }
            sum += currValue;
            prevValue = currValue;
        }
        return sum;
    }

    static public int romanToInt3(String s) {
        short sum = 0;
        short prevValue = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            short currValue = 0;
            switch (ch) {
                case 'I':
                    currValue = 1;
                    break;
                case 'V':
                    currValue = 5;
                    break;
                case 'X':
                    currValue = 10;
                    break;
                case 'L':
                    currValue = 50;
                    break;
                case 'C':
                    currValue = 100;
                    break;
                case 'D':
                    currValue = 500;
                    break;
                case 'M':
                    currValue = 1000;
                    break;
            }
            if (currValue > prevValue) {
                sum -= 2 * prevValue;
            }
            sum += currValue;
            prevValue = currValue;
        }
        return sum;
    }

    public static void main(String[] args) {
        int i = 'V'-'I';
        int g = 'X'-'I';
        System.out.println(i);
        System.out.println(g);
        System.out.println(romanToInt3("MCMXCIV"));
    }


}
