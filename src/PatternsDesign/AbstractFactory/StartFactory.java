package PatternsDesign.AbstractFactory;



import java.util.Scanner;
/**
 *           ПАТТЕРН Абстрактная ФАБРИКА
 */

/**
 * Предоставляет интерфейс для создания семейств связанных между собой
 * или зависимых объектов без указания их конкретных классов
 *
 * ЦЕЛЬ: создание интерфейса для создания множеств связаных или взаимозависимых обьектов
 *
 * ПРИМЕР:
 * система не должна зависить от метода создания, компановки и представления входящих в неё обьектов;
 * входящие взаимосвязанные обьекты должны использоваться вместе;
 * система должна конфигурироваться одним из множества  обьектов, из которых она состоит;
 * необходимо предоставить множество обьектов, раскрывая только их интерфейсы но не реализацию.
 *
 */



public class StartFactory {

    public static void main(String[] args) {
      PhpDeveloper phpDeveloper = new PhpDeveloper();
      ManualTester manualTester = new ManualTester();
      ProjectManager projectManager = new ProjectManager();

      phpDeveloper.writeCode();
      manualTester.testCode();
      projectManager.testCode();

    }
}
