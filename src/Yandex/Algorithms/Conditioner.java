package Yandex.Algorithms;

/*
В офисе, где работает программист Петр, установили кондиционер нового типа. Этот кондиционер отличается особой простотой
 в управлении. У кондиционера есть всего лишь два управляемых параметра: желаемая температура и режим работы.

Кондиционер может работать в следующих четырех режимах:

«freeze» — охлаждение. В этом режиме кондиционер может только уменьшать температуру. Если температура в комнате и так
 не больше желаемой, то он выключается.
«heat» — нагрев. В этом режиме кондиционер может только увеличивать температуру. Если температура в комнате и так
не меньше желаемой, то он выключается.
«auto» — автоматический режим. В этом режиме кондиционер может как увеличивать, так и уменьшать температуру в комнате
до желаемой.
«fan» — вентиляция. В этом режиме кондиционер осуществляет только вентиляцию воздуха и не изменяет температуру
в комнате.
Кондиционер достаточно мощный, поэтому при настройке на правильный режим работы он за час доводит температуру в комнате
 до желаемой.

Требуется написать программу, которая по заданной температуре в комнате troom, установленным на кондиционере желаемой
температуре tcond и режиму работы определяет температуру, которая установится в комнате через час.

Формат ввода
Первая строка входного файла содержит два целых числа troom, и tcond, разделенных ровно одним пробелом
(–50 ≤ troom ≤ 50, –50 ≤ tcond ≤ 50).

Вторая строка содержит одно слово, записанное строчными буквами латинского алфавита — режим работы кондиционера.

Формат вывода
Выходной файл должен содержать одно целое число — температуру, которая установится в комнате через час.
 */

import java.util.Scanner;

public class Conditioner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte tRoom = scanner.nextByte();
        byte tCond = scanner.nextByte();
        scanner.nextLine();
        String mode = scanner.nextLine().trim();


        System.out.println(start(tRoom, tCond, mode));

        scanner.close();
    }

    public static byte start(byte tRoom, byte tCond, String mode) {

        Mode selectedMode = Mode.valueOf(mode.toUpperCase());

        return switch (selectedMode) {
            case FREEZE -> tCond <= tRoom ? tCond : tRoom;
            case HEAT -> tCond >= tRoom ? tCond : tRoom;
            case AUTO -> tCond;
            case FAN -> tRoom;
        };
    }


    public enum Mode {
        FREEZE("Cooling"),
        HEAT("Heating"),
        AUTO("Automatic"),
        FAN("Ventilation");

        private String description;

        Mode(String description) {
            this.description = description;
        }

    }
}
