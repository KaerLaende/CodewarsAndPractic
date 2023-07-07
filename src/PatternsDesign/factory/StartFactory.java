package PatternsDesign.factory;

import java.util.Scanner;
/**
 *             ПАТТЕРН ФАБРИКА
 */

/**
 * Создание интерфейса, который создает обьект (фабрика).
 * А экземпляр какого класса он создаст зависит от класса который имплементирует этот интерфейс!
 * НУЖЕН: ДЛЯ делигирования создания экземпляров другому классу.
 * Например если заранее не известно, экземпляры какого класса придется создавать.
 */

public class StartFactory {
    static DeveloperFactory createDeveloperBySpecialty(String string) {
        if (string.equalsIgnoreCase("java")) {
            return new JavaDeveloperFactory();
        } else if (string.equalsIgnoreCase("c++")) {
            return new JavaDeveloperFactory();
        } else {
            throw new RuntimeException(string + " is unknown speciality!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Plz write a speciality?");
        String answer;
        // Вводные данные через консоль
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                answer = scanner.nextLine();
            } while (answer == null || answer.isEmpty() || answer.isBlank());
            DeveloperFactory developerFactory = createDeveloperBySpecialty(answer);
            Developer developer = developerFactory.createDeveloper();
            developer.writeCode();
        }
    }
}
