package Yandex.contest;
/*
Начало условия: Кузя снова не успел сдать реферат по языковым разнообразиям в срок. «Наверное, у меня какая-то
неоптимальная клавиатура...» — подумал Кузя и решил изобрести самую оптимальную клавиатуру для набора одним пальцем.
Кузя решил, что его клавиатура будет содержать
N
 рядов с клавишами (разные ряды могут содержать разные количества клавиш). Все клавиши на клавиатуре будут уникальными.
Чтобы оценить качество клавиатуры для набора определённого текста, Кузя ввёл понятие «разнорядности»:

 */
import java.util.HashMap;
import java.util.Scanner;

public class Keyboard {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfKeys = scanner.nextInt();


        int[] keysForMap = new int[numberOfKeys];

        for (int i = 0; i < numberOfKeys; i++) {
            keysForMap[i] = scanner.nextInt();
        }

        HashMap<Integer, Integer> keyboard = new HashMap<>();

        for (int i = 0; i < numberOfKeys; i++) {
            int symbol = keysForMap[i];
            int row = scanner.nextInt();
            keyboard.put(symbol, row);
        }

        int numberOfText = scanner.nextInt();
        int[] text = new int[numberOfText];

        for (int i = 0; i < numberOfText; i++) {
            text[i] = scanner.nextInt();
        }

        int rowChanges = 0;
        int currentRow = keyboard.get(text[0]);

        for (int i = 1; i < numberOfText; i++) {
            int nextRow = keyboard.get(text[i]);
            if (nextRow != currentRow) {
                rowChanges++;
                currentRow = nextRow;
            }
        }
        System.out.println(rowChanges);
    }
}

