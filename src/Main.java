import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int year = 2021;
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();

        while (true) {
            printMenu();
            String userInput = scanner.nextLine();

            if (userInput.equals("1")) {
                monthlyReport.readAllMonthReports(year);
                System.out.println("Данные доступных месячных отчетов успешно считаны.");
                System.out.println("--------------------------------------------------");
            } else if (userInput.equals("2")) {
                yearlyReport.readYearReport(year);
                System.out.println("Данные годового отчета успешно считаны.");
                System.out.println("---------------------------------------");
            } else if (userInput.equals("3")) {
                if (monthlyReport.listOfMonths.size() == 0 || yearlyReport.yearData.size() == 0){
                    System.out.println("Сперва нужно считать данные годового и месячных отчетов.");
                    System.out.println("Также убедитесь, что файлы не пусты.");
                    System.out.println("------------------------------------");
                } else {
                    Statistics.reconcileTheReports(monthlyReport, yearlyReport);
                }
            } else if (userInput.equals("4")) {
                if (monthlyReport.listOfMonths.size() != 0) {
                    Statistics.makeMonthlyReport(monthlyReport);
                    System.out.println("Вывод информации о всех месячных отчетах завершен.");
                    System.out.println("--------------------------------------------------");
                } else {
                    System.out.println("Сперва нужно считать данные месячных отчетов.");
                    System.out.println("Также убедитесь, что файлы не пусты.");
                    System.out.println("------------------------------------");
                }

            } else if (userInput.equals("5")) {
                if (yearlyReport.yearData.size() != 0) {
                    Statistics.makeYearlyReport(yearlyReport, year);
                    System.out.println("Вывод информации о годовом отчете завершен.");
                    System.out.println("-------------------------------------------");
                } else {
                    System.out.println("Сперва нужно считать данные годового отчета.");
                    System.out.println("Также убедитесь, что файл не пуст.");
                    System.out.println("----------------------------------");
                }
            } else if (userInput.equals("1111")) {
                System.out.println("Завершение работы приложения.");
                return;
            } else {
                System.out.println("Неизвестная команда. Попробуйте еще раз.");
                System.out.println("----------------------------------------");
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

