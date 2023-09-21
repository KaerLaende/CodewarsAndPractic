package leetcode;

import javax.sql.rowset.Predicate;
import java.util.Arrays;

/**
 * Учитывая непустой  массив целых чисел nums, каждый элемент встречается дважды , кроме одного. Найди ту единственную.
 *
 * Вы должны реализовать решение с линейной сложностью времени выполнения и использовать только постоянное дополнительное пространство.
 */

/*
Пример 1:

Ввод: числа = [2,2,1]
 Вывод: 1
Пример 2:

Ввод: числа = [4,1,2,1,2]
 Вывод: 4
Пример 3:

Ввод: число = [1]
 Вывод: 1
 */

public class SingleNumberInArray {
	//решение с помощью побитовое или ^
    public int singleNumber(int[] nums) {
		if (nums.length==1){
            return nums[0];
        }
        return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
    }

    public int singleNumber2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

}
