package leetcode;

import java.util.Arrays;

/**
 * Вам дано большое целое число , представленное в виде массива целых чисел digits, где каждое число digits[i]является цифрой целого числа.
 * Цифры упорядочены от наиболее значащего к наименее значащему в порядке слева направо. Большое целое число не содержит начальных символов
 */
/*
Ввод: цифры = [1,2,3]
 Вывод: [1,2,4]
 Объяснение: Массив представляет целое число 123.
Увеличение на единицу дает 123 + 1 = 124.
Таким образом, результат должен быть [1,2,4].
Пример 2:

Ввод: цифры = [4,3,2,1]
 Вывод: [4,3,2,2]
 Объяснение: Массив представляет целое число 4321.
Увеличение на единицу дает 4321 + 1 = 4322.
Таким образом, результат должен быть [4,3,2,2].
Пример 3:

Ввод: цифры = [9]
 Вывод: [1,0]
 Объяснение: Массив представляет целое число 9.
Увеличение на единицу дает 9 + 1 = 10.
Таким образом, результат должен быть [1,0].
 */


public class PlusOne {
    public static int[] plusOne(int[] digits) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int number: digits){
            stringBuilder.append(number);
        }
        String str = String.valueOf(stringBuilder);
		long answer = Long.parseLong(stringBuilder.toString())+1;
        String answerStr= String.valueOf(answer);
        int[] answerInts = new int[answerStr.length()];
        for (int i = 0; i < answerInts.length; i++) {
            answerInts[i]= Character.getNumericValue(answerStr.charAt(i));
        }
            return answerInts;
        }
    public static int[] plusOne1(int[] digits) {
        for (int length = digits.length-1; length >= 0; length--) {
            while (digits[length]==9){
                digits[length]=0;
                if (length==0){
                    int[] answerInts =new int[digits.length+1];
                    answerInts[0]=1;
                    return answerInts;
                }
                length--;
            }
            digits[length]++;
            break;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] ints = {9,9,9,1};
        System.out.println(Arrays.toString(plusOne1(ints)));
    }

    }
