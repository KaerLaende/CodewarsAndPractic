package Yandex.Algorithms;

/*
Даны три натуральных числа. Возможно ли построить треугольник с такими сторонами.
Если это возможно, выведите строку YES, иначе выведите строку NO.
Треугольник — это три точки, не лежащие на одной прямой.
 */

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int third = scanner.nextInt();
        if (first + second > third && first + third > second && second + third > first) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
