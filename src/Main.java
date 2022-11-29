import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {

    public static void main(String[] args) throws IOException {
        int year = 2021;
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        while (true) {
            printMenu();





            if (scanner.hasNextInt()) {
                int userInput = scanner.nextInt();
                if (userInput == 1) {
                    monthlyReport.readAllMonthReports(year);
                    System.out.println("Данные доступных месячных отчетов успешно считаны.");
                } else if (userInput == 2) {
                    yearlyReport.readYearReport(year);
                    System.out.println("Данные годового отчета успешно считаны.");
                } else if (userInput == 3) {
                    Statistics.reconcileTheReports(monthlyReport, yearlyReport);
                    System.out.println("Сверка отчетов завершена.");
                } else if (userInput == 4) {
                    // do something
                    System.out.println("Вывод информации о всех месячных отчетах завершен.");
                } else if (userInput == 5) {
                    // do something
                    System.out.println("Вывод информации о годовом отчете завершен.");
                } else if (userInput == 1111) {
                    System.out.println("Завершение работы приложения.");
                    return;
                } else {
                    System.out.println("Неизвестная команда. Попробуйте еще раз.");
                }
            } else {
                System.out.println("Пожалуйста, вводите только натуральные числа.");

            }

        }
    }

    public static void printMenu() {
        System.out.println("ВЫБЕРИТЕ ДЕЙСТВИЕ:");
        System.out.println("1. Считать все месячные отчёты");
        System.out.println("2. Считать годовой отчёт");
        System.out.println("3. Сверить отчёты");
        System.out.println("4. Вывести информацию о всех месячных отчётах");
        System.out.println("5. Вывести информацию о годовом отчёте");
        System.out.println("---------------------------------------");
        System.out.println("Чтобы завершить работу приложения,");
        System.out.println("введите год коронации Генриха V,");
        System.out.println("как императора Священной Римской империи папой Паскалем II");
    }
}

