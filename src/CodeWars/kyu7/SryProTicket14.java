package CodeWars.kyu7;

import java.util.Arrays;

public class SryProTicket14 {

    public static void main(String[] args) {
        int[] ints = {1, 2, 32, 42, 52, 62, 7, 8, 9, 10};
        int[] newInt = cutAndIncreaseMassive(ints);
        for (int i = 0; i < newInt.length; i++) {
            System.out.println(newInt[i]);
        }
    }

    public static int[] cutAndIncreaseMassive(int[] ints) {
        return Arrays.stream(ints).limit(6)
                .skip(2)
                .map(x -> x % 2 == 0 ? x + 1 : x)
                .toArray();
    }
}



