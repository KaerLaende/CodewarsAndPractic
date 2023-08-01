package Tinkoff;

import java.util.Scanner;

/**
 * У Кати насыщенный день на работе. Ей надо передать n разных договоров коллегам. Все встре- чи происходят на разных этажах, а между этажами можно перемещаться только по лестничным пролетам — считается, что это улучшает физическую форму сотрудников. Прохождение каждого пролета занимает ровно ﻿
 * 1 минуту. Сейчас Катя на парковочном этаже, планирует свой маршрут. Коллег можно посетить в любом порядке, но один из них покинет офис через t минут. С парковочного этажа лестницы нет — только лифт, на котором можно подняться на любой этаж.
 * В итоге план Кати следующий:
 * Подняться на лифте на произвольный этаж. Считается, что лифт поднимается на любой этаж за 0 минут.
 * Передать всем коллегам договоры, перемещаясь между этажами по лестнице. Считается, что договоры на этаже передаются мгновенно.
 * В первые t минут передать договор тому коллеге, который планирует уйти.
 * Пройти минимальное количество лестничных пролетов.
 * Помогите Кате выполнить все пункты ее плана.
 *
 * Формат выходных данных
 *
 * Выведите одно число — минимально возможное число лестничных пролетов, которое понадобится пройти Кате.
 */
/*
Пример 1
ВВОД:
5  5
1  4  9  16  25
2
ВЫВОД - 24

Пример 2
ВВОД:
6  4
1  2  3  6  8  25
5
ВЫВОД - 31
 */
public class KateInFloor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int countOfEmployee = scanner.nextInt();
        int timeToLeave = scanner.nextInt();
        int[] floors = new int[countOfEmployee];
        for (int i = 0; i < floors.length; i++) {
            floors[i] = scanner.nextInt();
        }
        int leaversFloor = floors[scanner.nextInt() - 1];
        System.out.println(getStep(timeToLeave, floors, leaversFloor));
    }

    private static int getStep(int timeToLeave, int[] floors, int leaversFloor) {
        int step = 0;
        int start = 0;
        int highestFloor = floors[floors.length - 1];
        int totalDist =highestFloor - floors[0];
        if (timeToLeave < leaversFloor - floors[0] //Если не успевает пройти попорядку и успеть застать того кто уходит
                && timeToLeave < highestFloor - leaversFloor) { //и не успевает в обратном порядке с конца
            	start = leaversFloor; // тогда начинаем путь с этажа уходящего сотрудника
                if (start <= totalDist / 2) {
                    step = (start - floors[0]) + (totalDist);
                } else {
                    step = (highestFloor - start) + totalDist;
                }
            } else {//иначе идём по порядку начиная путь с 1го или последнего этажа
            step = totalDist;
            }
        return step;
    }
}
