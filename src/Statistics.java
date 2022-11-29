public class Statistics {
    public static void reconcileTheReports(MonthlyReport receivedMR, YearlyReport receivedYR) { // Метод, производящий сверку отчетов

        if (receivedMR.listOfMonths.keySet().equals(receivedYR.yearData.keySet())) { // Сверяем ключи месяцев в отчете по месяцам и отчете за год
            for (int i : receivedMR.listOfMonths.keySet()) {
                int monthProfit = 0;
                int monthExpense = 0;
                YearRow currentYearRow = receivedYR.yearData.get(i);
                int yearMonthProfit = currentYearRow.profit;
                int yearMonthExpense = currentYearRow.expense;
                FullMonth currentMonth = receivedMR.listOfMonths.get(i);
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
            System.out.println("Сверка отчетов завершена.");
            System.out.println("Данные в месячных отчетах соответствуют данным в годовом отчете.");
            System.out.println("----------------------------------------------------------------");
        } else {
            System.out.println("Число месячных отчетов не совпадает с числом месяцев в годовом отчете.");
            System.out.println("Проверьте входные данные.");
            System.out.println("-------------------------");
        }



    }

    public static void makeMonthlyReport (MonthlyReport mR) {
        System.out.println("Статистика по месяцам:");
        for (int i : mR.listOfMonths.keySet()) {
            FullMonth currentMonth = mR.listOfMonths.get(i);

            int maxExpense = 0;
            String maxExpenseName = "";
            int maxProfit = 0;
            String maxProfitName = "";

            if (i == 1) {
                System.out.println("Январь:");
            } else if (i == 2) {
                System.out.println("Февраль:");
            } else if (i == 3) {
                System.out.println("Март:");
            } else if (i == 4) {
                System.out.println("Апрель:");
            } else if (i == 5) {
                System.out.println("Май:");
            } else if (i == 6) {
                System.out.println("Июнь:");
            } else if (i == 7) {
                System.out.println("Июль:");
            } else if (i == 8) {
                System.out.println("Август:");
            } else if (i == 9) {
                System.out.println("Сентябрь:");
            } else if (i == 10) {
                System.out.println("Октябрь:");
            } else if (i == 11) {
                System.out.println("Ноябрь:");
            } else if (i == 12) {
                System.out.println("Декабрь:");
            } else {
                System.out.println("Дребедень какая-то (((");
            }
            for (MonthRow m : currentMonth.monthData) {
                if (m.isExpense){
                    if (maxExpense < (m.sumOfOne * m.quantity)) {
                        maxExpense = m.sumOfOne * m.quantity;
                        maxExpenseName = m.itemName;
                    }
                } else {
                    if (maxProfit < (m.sumOfOne * m.quantity)) {
                        maxProfit = (m.sumOfOne * m.quantity);
                        maxProfitName = m.itemName;
                    }
                }
            }
            System.out.println("Самая большая статья расходов: " + maxExpenseName);
            System.out.println("На это было потрачено " + maxExpense + " рублей.");
            System.out.println("Самая большая статья доходов: " + maxProfitName);
            System.out.println("На этом было заработано " + maxProfit + " рублей.");
            System.out.println("---------------------------------------------------");
        }
    }

    public static void makeYearlyReport(YearlyReport yR, int yearNumber) {

        System.out.println("Год " + yearNumber);
        System.out.println("Всего в отчете за этот год содержится информация о " + yR.yearData.size() + " месяцах.");
        for (int i : yR.yearData.keySet()) {
            if (i == 1) {
                System.out.println("Январь:");
            } else if (i == 2) {
                System.out.println("Февраль:");
            } else if (i == 3) {
                System.out.println("Март:");
            } else if (i == 4) {
                System.out.println("Апрель:");
            } else if (i == 5) {
                System.out.println("Май:");
            } else if (i == 6) {
                System.out.println("Июнь:");
            } else if (i == 7) {
                System.out.println("Июль:");
            } else if (i == 8) {
                System.out.println("Август:");
            } else if (i == 9) {
                System.out.println("Сентябрь:");
            } else if (i == 10) {
                System.out.println("Октябрь:");
            } else if (i == 11) {
                System.out.println("Ноябрь:");
            } else if (i == 12) {
                System.out.println("Декабрь:");
            } else {
                System.out.println("Дребедень какая-то (((");
            }
            int expense = yR.yearData.get(i).expense;
            int profit = yR.yearData.get(i).profit;
            System.out.println("Прибыль составила " + (profit - expense) + " рублей.");
        }

        int sumExpense = 0;
        int sumProfit = 0;
        for (int i : yR.yearData.keySet()) {
            sumExpense += yR.yearData.get(i).expense;
            sumProfit += yR.yearData.get(i).profit;
        }
        System.out.println("Средний месячный расход составил " + (sumExpense / yR.yearData.size()) + " рублей.");
        System.out.println("Средний месячный доход составил " + (sumProfit / yR.yearData.size()) + " рублей.");
        System.out.println("--------------------------------------------------------------------------------");

    }
}
