package leetcode;

import java.util.*;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        Map<Character, Character>map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Deque<Character> stack = new LinkedList<>();

        for (Character symbol : s.toCharArray()) {
            if (map.containsValue(symbol)) {
            stack.push(symbol);
            } else if (map.containsKey(symbol)) {
                if (stack.isEmpty()|| stack.pop()!=map.get(symbol)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
       String s ="((()))";
        System.out.println(isValid(s));
    }
}




