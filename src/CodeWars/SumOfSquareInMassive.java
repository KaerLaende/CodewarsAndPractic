package CodeWars;

import java.util.Arrays;

public class SumOfSquareInMassive {

    public static int squareSum(int[] n) {
        int summ=0;
        for(int i:n){
            summ+=i*i;
        }
        return summ;
    }
    public static int squareSum1(int[] n) {
        return Arrays.stream(n).map(x -> x * x).sum();
    }

}
