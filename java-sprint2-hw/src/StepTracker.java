import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Введён неправильный номер месяца!");
            return;
        }
        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Введён неправильный номер дня!");
            return;
        }
        System.out.println("Введите количество шагов");
        int amountSteps = scanner.nextInt();
        if (amountSteps < 0) {
            System.out.println("Количество шагов не может быть отприцательным числом!");
            return;
        }

        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = amountSteps;
    }

    void changeStepGoal() {
        System.out.println("Введите цель шагов на день");
        int goalSteps = scanner.nextInt();
        if (goalSteps <= 0) {
            System.out.println("Цель щагов не может быть отрицательной или равной 0!");
            return;
        }
    }

    void printStatistics() {
        System.out.println("Введите номер месяца");
        int monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Некорректный номер месяца.");
            return;
        }

        MonthData monthData = monthToData[monthNumber - 1];

        if (monthData == null) {
            System.out.println("Данные для этого месяца отсутствуют.");
            return;
        }

        int sumSteps = monthData.sumStepsFromMonth();

        System.out.println("Вывод общей статистики по дням: ");
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Сумма шагов за месяц: " + sumSteps);
        System.out.println("Вывод максимального пройденного количества шагов за месяц: " + monthData.maxSteps());
        System.out.println("Среднее пройденное количество шагов за месяц: " + monthData.sumStepsFromMonth() / 30);
        System.out.println("Пройденная дистанция за месяц в километрах: " + converter.convertToKm(sumSteps));
        System.out.println("Количество сожжённых килокалорий за месяц: " + converter.convertStepsToKilocalories(sumSteps));
        System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();
    }
}
