import java.util.HashMap;

public class Statistics {
    public static void reconcileTheReports(MonthlyReport receivedMR, YearlyReport receivedYR) { // Метод, производящий сверку отчетов

        MonthlyReport mR = receivedMR;
        YearlyReport yR = receivedYR;

        if (mR.listOfMonths.keySet() == yR.yearData.keySet()) { // Сверяем ключи месяцев в отчете по месяцам и отчете за год
            for (int i : mR.listOfMonths.keySet()) {
                int monthProfit = 0;
                int monthExpense = 0;
                YearRow currentYearRow = yR.yearData.get(i);
                int yearMonthProfit = currentYearRow.profit;
                int yearMonthExpense = currentYearRow.expense;
                FullMonth currentMonth = mR.listOfMonths.get(i);
                for (int j = 0; j < currentMonth.monthData.size(); j++) {
                    MonthRow currentRow = currentMonth.monthData.get(j);
                    if (currentRow.isExpense) {
                        monthExpense += currentRow.quantity * currentRow.sumOfOne;
                    } else {
                        monthProfit += currentRow.quantity * currentRow.sumOfOne;
                    }
                }
                if (monthExpense != yearMonthExpense || monthProfit != yearMonthProfit) {
                    System.out.println("Найдено несоответствие данных в месяце №" + i);
                }
            }
        } else {
            System.out.println("Число месячных отчетов не совпадает с числом месяцев в годовом отчете.");
            System.out.println("Проверьте входные данные.");
        }



    }
}
