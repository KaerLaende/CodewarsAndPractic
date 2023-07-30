package leetcode;

/**
 * Напишите функцию, которая находит самую длинную строку общего префикса среди массива строк.
 * Если общего префикса нет, вернуть пустую строку "".
 */
/*
Input: strs = ["flower","flow","flight"]
Output: "fl"
 */

public class LongestPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // Находим самую короткую строку в массиве
        String shortestStr = strs[0];
        for (String str : strs) {
            if (str.length() < shortestStr.length()) {
                shortestStr = str;
            }
        }
        // Проверяем каждый символ самой короткой строки
        // с символами остальных строк
        for (int i = 0; i < shortestStr.length(); i++) {
            char c = shortestStr.charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != c) {
                    return shortestStr.substring(0, i);
                }
            }
        }
        return shortestStr;
    }
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String str = strs[0];
        for(int i =1; i<strs.length; i++){
            System.out.println(strs[i].indexOf(str));
            while(strs[i].indexOf(str)!=0){
                str = str.substring(0, str.length()-1);
                if(str.isEmpty()){
                    return "";
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix2(strs));
    }
}
