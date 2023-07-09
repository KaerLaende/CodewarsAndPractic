package CodeWars;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinIndexfromMassive {
    public static int findSmallestInt1(int[] args) {
        return IntStream.of(args).min().getAsInt();
    }
    public static int findSmallestInt2(int[] args) {
        Arrays.sort(args);
        return args[0];
    }
    public static int findSmallestInt3(int[] args) {
        int smallest = Integer.MAX_VALUE;
        for (int i : args)
            smallest = Math.min(smallest, i);
        return smallest;
    }
    public static int findSmallestInt4(int[] args) {
        return java.util.Arrays.stream(args).min().getAsInt();
    }
}
