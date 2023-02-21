package CodeWars;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class AllAddWithMinCost {
    public static int addAll(int[] numbers) {
        int cost = 0;
        Arrays.sort(numbers);
        ArrayList<Integer> sumList= new ArrayList<>();
            for (int i = 0; i < numbers.length; i++) {
                if (i==0) {
                    sumList.add(numbers[i] + numbers[i+1]);
                } else if(i>1){
                    sumList.set(0,(sumList.get(0)+numbers[i]));
                }
                int x=sumList.get(0);
            }
        return sumList.get(0);
    }


    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 4};
        int answer = 33;
        System.out.println(addAll(test));
    }

}
