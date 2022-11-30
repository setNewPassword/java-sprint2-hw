import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class YearlyReport {
    // Класс для создания объекта, который хранит ArrayList с объектами-строками из годового отчета
    HashMap<Integer, YearRow> yearData;

    public YearlyReport() {
        yearData = new HashMap<>();
    }

    List<String> readFileContents(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл " + e.getMessage() +". Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }

    void readYearReport(int inputYear) {

        List<String> rowsOfYearReport = readFileContents("resources/y." + inputYear + ".csv");

        for (int j = 1; j < rowsOfYearReport.size() - 1; j = j + 2) { //Будем анализировать по две строки сразу, поэтому счетчик +2
            String[] lineContent1 = rowsOfYearReport.get(j).split(","); // Разбираем первую строку на переменные
            int monthNumber1 = Integer.parseInt(lineContent1[0]);
            int amount1 = Integer.parseInt(lineContent1[1]);
            boolean isExpense1 = Boolean.parseBoolean(lineContent1[2]);

            String[] lineContent2 = rowsOfYearReport.get(j+1).split(","); // Разбираем вторую строку на переменные
            int monthNumber2 = Integer.parseInt(lineContent2[0]);
            int amount2 = Integer.parseInt(lineContent2[1]);
            boolean isExpense2 = Boolean.parseBoolean(lineContent2[2]);

            int expense = 0;
            int profit = 0;

            if (monthNumber1 == monthNumber2 && isExpense1 && !isExpense2) {
                expense = amount1;
                profit = amount2;
            } else if (monthNumber1 == monthNumber2 && !isExpense1 && isExpense2) {
                expense = amount2;
                profit = amount1;
            } else {
                System.out.println("В годовом отчете какая-то путаница, проверьте входящие данные.");
                System.out.println("--------------------------------------------------------------");
            }

            YearRow yearRow = new YearRow(expense, profit);
            yearData.put(monthNumber1, yearRow);
        }

    }



}


class YearRow {

    // Класс для создания объекта, который хранит одну строку из годового отчета

    int expense;
    int profit;

    public YearRow(int expense, int profit) {   // Объект будет содержать данные из двух строк годового отчета, относящихся к одному месяцу
        this.expense = expense;                 // поле для расходов
        this.profit = profit;                   // поле для доходов
    }


}
