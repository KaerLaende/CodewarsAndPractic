package Yandex.Algorithms;

import java.util.Scanner;

/*
Витя работает недалеко от одной из станций кольцевой линии Московского метро, а живет рядом с другой станцией той же
линии. Требуется выяснить, мимо какого наименьшего количества промежуточных станций необходимо проехать Вите по кольцу,
чтобы добраться с работы домой.

Формат ввода
Станции пронумерованы подряд натуральными числами 1, 2, 3, …, N (1-я станция – соседняя с N-й), N не превосходит 100.

Вводятся три числа: сначала N – общее количество станций кольцевой линии, а затем i и j – номера станции,
на которой Витя садится, и станции, на которой он должен выйти. Числа i и j не совпадают. Все числа разделены пробелом.

Формат вывода
Требуется выдать минимальное количество промежуточных станций (не считая станции посадки и высадки), которые необходимо
проехать Вите.
 */
public class RingMetro {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int job = scanner.nextInt();
        int home = scanner.nextInt();

        getAnswer2(N, job, home);
    }

    private static void getAnswer(int N, int job, int home) {
        int halfN = N / 2;
        int answer;
        int difference = Math.abs(job - home);
        if ( difference< halfN){
            answer=difference-1;
        }else {
            answer= (N - home)+ job -1;
        }
        System.out.println(answer);
    }

    private static void getAnswer2(int N, int job, int home) {
        int answer;
        int way = Math.abs(job - home)-1;
        int way2= N - way -2;
        answer= Math.min(way, way2);
        System.out.println(answer);
    }
}


