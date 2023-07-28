package leetcode;

import java.util.*;

/**
 * Дан массив целых чисел nums и целое число target, вернуть индексы двух чисел так, чтобы они в сумме составлялиtarget .
 * Вы можете предположить, что каждый вход будет иметь ровно одно решение , и вы не можете использовать один и тот же элемент дважды.
 * Вы можете вернуть ответ в любом порядке.
 */
/* ПРИМЕР
Ввод: nums = [2,7,11,15], target = 9
 Вывод: [0,1]
 */

public class TwoSum {
    public  static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if(hashMap.containsKey(n)){
                int first= hashMap.get(n);
                return new int[]{first, i};
            } else {
                hashMap.put(nums[i],i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] ints = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(ints, 9)));
    }

}
