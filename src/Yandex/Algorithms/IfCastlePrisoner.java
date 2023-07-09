package Yandex.Algorithms;
/*
За многие годы заточения узник замка Иф проделал в стене прямоугольное отверстие размером D × E. Замок Иф сложен
из кирпичей, размером A × B × C. Определите, сможет ли узник выбрасывать кирпичи в море через это отверстие,
если стороны кирпича должны быть параллельны сторонам отверстия.
 */

import java.util.Scanner;


public class IfCastlePrisoner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();

        if ((a <= d && b <= e) ||
                (a <= d && c <= e) ||
                (b <= d && a <= e) ||
                (b <= d && c <= e) ||
                (c <= d && a <= e) ||
                (c <= d && b <= e)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
