package CodeWars;

import java.util.stream.IntStream;

//(new int[]{1,2,3,4,5}, new int[]{3,4,1,5})
public class LostNumber {
    public static int findDeletedNumber(int[] arr, int[] mixedArr) {
        int lostNumber = 0;
        int findNumber=0;
        for (int i = 0; i < arr.length; i++) { //проход i в 1ом массиве
            for (int x = 0; x < mixedArr.length; x++) { //проход x 2го массива при i из 1го
                if (arr[i] == mixedArr[x]) { // сравнение чисел первого и второго массива
                    findNumber = arr[i]; // если равно - переписываем findNumber
                    break; // и сразу выходим из этой итерации
                }
                else findNumber=0; // если они не равны возвращаем 0
            }
            if (findNumber==0){ // если ни один не равняется
                lostNumber=arr[i]; //
            }
        }
        return lostNumber;
    }

    public static int findDeletedNumber1(int[] arr, int[] mixedArr) {
        return IntStream.of(arr).sum() - IntStream.of(mixedArr).sum();
    }
    }
