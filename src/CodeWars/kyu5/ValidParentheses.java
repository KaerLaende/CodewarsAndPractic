package CodeWars.kyu5;

public class ValidParentheses {
    public static boolean validParentheses(String parenStr) {
        while (parenStr.contains("()"))
            parenStr = parenStr.replace("()", "");
        return parenStr == "";
    }


}
