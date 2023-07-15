package CodeWars.kyu5;

import java.math.BigInteger;
import java.util.Objects;

/*
Ваша задача — написать функцию, которая увеличивает строку, чтобы создать новую строку.

Если строка уже заканчивается числом, число должно быть увеличено на 1.
Если строка не заканчивается цифрой. число 1 должно быть добавлено к новой строке.
Примеры:

foo -> foo1

foobar23 -> foobar24

foo0042 -> foo0043

foo9 -> foo10

foo099 -> foo100

Внимание: Если в числе есть ведущие нули, следует учитывать количество цифр.
 */
public class StringIncrementer {
    private  int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringIncrementer that = (StringIncrementer) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static String incrementString(String str) {
        if (str.matches(".*\\d$")) {
            // Получаем последнее число в строке
            String lastNumber = str.replaceAll("^.*?(\\d+)$", "$1");
            // Увеличиваем число на 1
            BigInteger increasedNumber = new BigInteger(lastNumber).add(BigInteger.ONE);
            // Получаем количество цифр в последнем числе
            int digitCount = lastNumber.length();
            // Форматируем увеличенное число, чтобы сохранить количество цифр
            String formattedNumber = String.format("%0" + digitCount + "d", increasedNumber);
            // Заменяем последнее число в строке на увеличенное число
            return str.replaceAll("\\d+$", formattedNumber);
        } else {
            // Если строка не заканчивается на число, добавляем 1 к новой строке
            return str + "1";
        }
    }


    public static void main(String[] args) {
        String word = "example123";
        System.out.println(incrementString(word));
    }

}


