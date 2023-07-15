package Yandex.contest;

import java.util.*;
/*
Прример ввода:
1.
Ввод
3 5 2
5 10 6
Вывод:
2
1 3
2.
Ввод
5 19 32
36 10 72 4 50
Вывод
2
2 4
 */


public class IceSculpture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int idealWeight = scanner.nextInt();
        int remainingTime = scanner.nextInt();

        Map<Integer, Integer> sculpturesMap = new HashMap<>();

        Integer[] sculptures = new Integer[number];

        for (int i = 0; i < number; i++) {
            sculptures[i] = scanner.nextInt();
            sculpturesMap.put(i, sculptures[i]);
        }

        Arrays.sort(sculptures, Comparator.comparingInt(a -> Math.abs(a - idealWeight)));

        int totalWeightDifference = 0;
        int currentIndex = 0;
        List<Integer> indexesToFix = new ArrayList<>();

        while (totalWeightDifference <= remainingTime && currentIndex < number) {
            int weightDifference = Math.abs(sculptures[currentIndex] - idealWeight);
            if (totalWeightDifference + weightDifference <= remainingTime) {
                int originalIndex = sculpturesMap.get(currentIndex);
                indexesToFix.add(originalIndex);
                totalWeightDifference += weightDifference;
            }
            currentIndex++;
        }

        System.out.println(indexesToFix.size());
        for (int index : indexesToFix) {
            System.out.print((index + 1) + " ");
        }
    }
}



