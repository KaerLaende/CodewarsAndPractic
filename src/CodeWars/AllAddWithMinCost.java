package CodeWars;

import java.util.Arrays;

public class AllAddWithMinCost {
    public static int addAll(final int[] numbers) {
        int cost = 0;
        int index=0;
        int[] summ= new int[numbers.length - 1];
        for (int i = 0; i < numbers.length;i++) {
            if(i==0){cost=numbers[i]+ numbers[++i];
            summ[index]=cost;
            index++;}
            else{
                cost=cost+ numbers[i];
                summ[index]=cost;
                index++;
            }
        }
        return Arrays.stream(summ).sum();


    }

}
