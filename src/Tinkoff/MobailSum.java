package Tinkoff;

import java.util.Scanner;

/**
 * Костя подключен к мобильному оператору «Мобайл». Абонентская плата Кости составляет  A рублей в месяц. За эту стоимость Костя получает B
	мегабайт интернет-трафика. Если Костя выйдет за лимит трафика, то каждый следующий мегабайт будет стоить ему C  рублей.
 * Костя планирует потратить  D мегабайт интернет-трафика в следующий месяц. Помогите ему сосчитать, во сколько рублей ему обойдется интернет.

 Вводится 4 целых положительных числа  A,B,C,D(1≤A,B,C,D≤100) — стоимость тарифа Кости, размер тарифа Кости,
 стоимость каждого лишнего мегабайта, размер интернет-трафика Кости в следующем месяце.
 Числа во входном файле разделены пробелами


 */


/*Ввод:					Вывод
100  10  12  15			160
 */
public class MobailSum {
    public static int getMobailSum(int A, int B, int C, int D){
        int sum =A;
        if(D>B) {
            sum += (D - B) * C;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int D = scanner.nextInt();
        System.out.println(getMobailSum(A,B,C,D));
    }
}
