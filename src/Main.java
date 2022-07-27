import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        int userInput = 1;

        while (userInput != 0) {
            printMenu();
            userInput = scanner.nextInt();

            if (userInput == 1) {
                System.out.println("За какой месяц Вы хотите ввести количество шагов?");
                int month = scanner.nextInt();
                System.out.println("За какой день Вы хотите ввести количество шагов?");
                int day = scanner.nextInt();
                System.out.println("Введите количество шагов:");
                int steps = scanner.nextInt();
                stepTracker.saveSteps(month, day, steps);
                System.out.println("Значение сохранено!");
            }
           else if (userInput == 2) {
               System.out.println("За какой месяц напечатать статистику?");
               int month = scanner.nextInt();
               stepTracker.print(month);
            }
           else if (userInput == 3) {
                System.out.println("Введите новое целевое количество шагов: ");
                int target = scanner.nextInt();
                if (target > 0) {
                    stepTracker.setTargetSteps(target);
                    System.out.println("Значение " + target + " сохранено!");
                }
                else {
                    System.out.println("Введено некорректное значение.");
                }
            }
           else if (userInput == 0) {
                System.out.println("Программа завершена");
            }
           else {
               System.out.println("Неизвестная команда, повторите попытку.");
            }

        }

    }

    private static void printMenu() {
        System.out.println("""
                
                Что необходимо сделать?
                1 - Ввести количество шагов за определённый день
                2 - Напечатать статистику за определённый месяц
                3 - Изменить цель по количеству шагов в день
                0 - Выйти из приложения
                """);

    }
}