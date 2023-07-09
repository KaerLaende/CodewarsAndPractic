package Yandex.Algorithms;
/*
 деревне Интернетовка все дома расположены вдоль одной улицы по одну сторону от нее. По другую сторону от этой улицы
 пока ничего нет, но скоро все будет – школы, магазины, кинотеатры и т.д.

Для начала в этой деревне решили построить школу. Место для строительства школы решили выбрать так, чтобы суммарное
 расстояние, которое проезжают ученики от своих домов до школы, было минимально.

План деревни можно представить в виде прямой, в некоторых целочисленных точках которой находятся дома учеников.
 Школу также разрешается строить только в целочисленной точке этой прямой (в том числе разрешается строить школу в
  точке, где расположен один из домов – ведь школа будет расположена с другой стороны улицы).

Напишите программу, которая по известным координатам домов учеников поможет определить координаты места строительства школы.
 */

import java.util.Scanner;

public class BuildSchool {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();
        String[] numbersAsString = input.split(" ");
        int[] numbers = new int[numbersAsString.length];

        for (int i = 0; i < numbersAsString.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i]);
        }

        System.out.println(numbers[numbers.length / 2]);
    }
}
