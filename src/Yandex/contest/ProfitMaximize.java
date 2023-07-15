package Yandex.contest;


import java.util.Arrays;

import java.util.Scanner;
/*
    Объявление: если у вас есть жалобы / претензии / вопросы насчет задач, то советуем для начала ознакомиться с расширенной
 инструкцией, содержащей в том числе ответы на самые частые вопросы.
    Начало условия: Кузя изучает биографии самых известных трейдеров на бирже. Недавно Кузя прочитал историю о том, как,
 совершив всего четыре сделки (две покупки и две продажи) акций на бирже, трейдер смог превратить один рубль в целое состояние.
    Кузя лучше всех знает, что такой удачи не бывает, а значит у трейдера была инсайдерская информация о ценах на ближайшие дни.
«Да если бы у меня была инсайдерская информация, я бы еще больше денег за четыре сделки получил!» — заявил Кузя перед
своим преподавателем экономики. Преподаватель экономики не растерялся и выдал Кузе данные о ценах акций фирмы Тындекс
за тот период.
    Для простоты вычислений преподаватель предложил считать, что можно покупать и продавать любую дробную часть акции.
Например, если акция стоит 2 рубля, а у вас в наличии 3 рубля, то вы можете купить 1.5 акции.
Преподаватель ожидает, что Кузя вычислит наибольшее количество денег, которые можно получить из 1 рубля на старте,
совершив не более четырех сделок.
 */


/*
Ввод
6
1 4 2 3 3 5
Вывод
2
1 2
3 6
 */

public class ProfitMaximize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfDays = scanner.nextInt();
        int[] prices = new int[numberOfDays + 1];
        for (int i = 1; i <= numberOfDays; i++) {
            prices[i] = scanner.nextInt();
        }

        /*
    Двумерный массив testResults используется для хранения максимальных значений прибыли для каждого дня и каждого
состояния (0 - не владеем акциями, 1 - владеем одной акцией, 2 - продали одну акцию, 3 - владеем двумя акциями,
4 - продали две акции).
    Двумерный массив previousResults используется для хранения информации о предыдущем состоянии, которое привело к текущему
максимальному значению прибыли.
Оба массива используются для определения оптимальной стратегии покупки и продажи акций, чтобы максимизировать прибыль.
         */


        int[][] testResults = new int[numberOfDays + 1][5];
        int[][] previousResults = new int[numberOfDays + 1][5];
        Arrays.fill(testResults[0], Integer.MIN_VALUE);
        testResults[0][0] = 0;
        for (int i = 1; i <= numberOfDays; i++) {
            for (int j = 0; j <= 4; j++) {
                testResults[i][j] = testResults[i - 1][j];
                previousResults[i][j] = previousResults[i - 1][j];
                if (j > 0 && j % 2 == 1 && testResults[i - 1][j - 1] != Integer.MIN_VALUE && testResults[i - 1][j - 1] - prices[i] > testResults[i][j]) {
                    testResults[i][j] = testResults[i - 1][j - 1] - prices[i];
                    previousResults[i][j] = i;
                }
                if (j > 0 && j % 2 == 0 && testResults[i - 1][j - 1] != Integer.MIN_VALUE && testResults[i - 1][j - 1] + prices[i] > testResults[i][j]) {
                    testResults[i][j] = testResults[i - 1][j - 1] + prices[i];
                    previousResults[i][j] = i;
                }
            }
        }
        int maxJ = 0;
        for (int j = 0; j <= 4; j++) {
            if (testResults[numberOfDays][j] > testResults[numberOfDays][maxJ]) {
                maxJ = j;
            }
        }
        System.out.println(maxJ / 2);
        int i = numberOfDays;
        int[] buy = new int[2];
        int[] sell = new int[2];
        while (i > 0) {
            if (previousResults[i][maxJ] != previousResults[i - 1][maxJ]) {
                if (maxJ % 2 == 1) {
                    buy[(maxJ - 1) / 2] = previousResults[i][maxJ];
                } else {
                    sell[maxJ / 2 - 1] = previousResults[i][maxJ];
                }
                maxJ--;
            }
            i--;
        }
        for (i = 0; i < 2; i++) {
            if (buy[i] > 0 && sell[i] > 0) {
                System.out.println(buy[i] + " " + sell[i]);
            }
        }
    }
}
