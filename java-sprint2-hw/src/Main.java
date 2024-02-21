import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            if(choice < 0 || choice > 3) {
                System.out.println("Введите правильный пункт!");
                System.out.println("");
            } else if (choice == 1) {
                stepTracker.addNewNumberStepsPerDay();
                System.out.println("");
            } else if (choice == 2) {
                stepTracker.changeStepGoal();
                System.out.println("");
            } else if (choice == 3) {
                stepTracker.printStatistics();
                System.out.println("");
            }
        }
    }

    static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1.Ввести количество шагов за определённый день.");
        System.out.println("2.Изменить цель по количеству шагов в день.");
        System.out.println("3.Напечатать статистику за определённый месяц.");
        System.out.println("0.Выйти из приложения");
    }
}