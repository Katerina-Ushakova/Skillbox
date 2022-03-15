import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Movements {
    protected String path;

    public Movements(String path) {
        this.path = path;
    }

    //Расходы
    public double getExpenseSum() {
        return loadMoveFromFile().stream()
                .mapToDouble(Operation::getExpense)
                .sum();
    }

    //Доходы
    public double getIncomeSum() {
        return loadMoveFromFile().stream()
                .mapToDouble(Operation::getIncome)
                .sum();
    }

    //Расход по организациям
    public void expenseByOrganization(){
        HashMap<String,Double> allExpense = new HashMap<>();
        loadMoveFromFile().forEach(f-> {
            if(f.getExpense() > 0) {
                double sum = allExpense.containsKey(f.getName()) ? allExpense.get(f.getName()) : 0;
                sum += f.getExpense();
                allExpense.put(f.getName(), sum);
            }
        });
        allExpense.forEach((k,v) -> System.out.println(k + " = " + v + " руб."));
    }

    public ArrayList<Operation> loadMoveFromFile(){
        ArrayList<Operation> move = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for(String line : lines) {
                String[] fragments = line.split("\\s{4,}");
                if (fragments.length > 1){
                    String[] newString = fragments[3].split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                    String name = fragments[1];
                    double income = stringToNumber(newString[newString.length - 2]);
                    double expense = stringToNumber(newString[newString.length - 1]);

                    move.add(new Operation(name, income, expense));
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return move;
    }

    public Double stringToNumber (String string) {
        double number = 0.0;
        try {
            if (string.contains("\"")) {
                String[] insideQuotes = string.split("\"");
                number = Double.parseDouble(insideQuotes[1].replace(",", "."));
            } else {
                number = Double.parseDouble(string);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return number;
    }

    public void printData() {
        System.out.println("Сумма доходов: " + getIncomeSum() + " руб");
        System.out.println("Сумма расходов: " +  getExpenseSum() + " руб");
        System.out.println("--------------------------------------------------");
        System.out.println("Суммы расходов по организациям:");
        expenseByOrganization();
        System.out.println("--------------------------------------------------");
    }
}

/*public class Movements {
    double expense;
    double income;
    private Map<String, Double> expenseList = new HashMap<>();
    public Movements(String pathMovementList){
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathMovementList));
            for(int i = 1; i < lines.size(); i++) {
                calculateData(lines.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void calculateData(String lines) {
        String[] fragment = lines.split(",", 8);
        double incomeTmp = Double.parseDouble(fragment[6]
                .replace("\"", "")
                .replace(",", "."));
        double expenseTmp = Double.parseDouble(fragment[7]
                .replace("\"", "")
                .replace(",", "."));
        if (incomeTmp == 0) calculateExpense(fragment[5], expenseTmp);
        else this.income += incomeTmp;
    }

    private void calculateExpense(String expenseName, double expense) {
        this.expense += expense;
        String[] transaction = expenseName.trim().split(" {3,}");
        String[] temp = transaction[1].split("/");
        String[] suppliesTemp = temp[temp.length - 1].split("\\\\");
        String supplies = suppliesTemp[suppliesTemp.length - 1];
        if (!expenseList.containsKey(supplies))
            expenseList.put(supplies, expense);
        else {
            double sum = expenseList.get(supplies);
            sum += expense;
            expenseList.put(supplies.trim(), sum);
        }
    }

    public double getExpenseSum() {
        return expense;
    }

    public double getIncomeSum() {
        return income;
    }

    public void printData() {
        System.out.println("Сумма доходов: " + getIncomeSum() + " руб");
        System.out.println("Сумма расходов: " +  getExpenseSum() + " руб");
        System.out.println("--------------------------------------------------");
        System.out.println("Суммы расходов по организациям:");
        for (String supplies : expenseList.keySet()) {
            System.out.println(supplies + " " + expenseList.get(supplies) + " руб");
        }
        System.out.println("--------------------------------------------------");
    }
}*/
