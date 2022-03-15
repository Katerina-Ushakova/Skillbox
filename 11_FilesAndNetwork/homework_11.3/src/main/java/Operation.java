public class Operation {
    public String name;
    public double income;
    public double expense;

    public Operation(String name, double income, double expense){
        this.name = name;
        this.income = income;
        this.expense = expense;
    }

    public String getName(){
        return name;
    }

    public double getIncome(){
        return income;
    }

    public double getExpense(){
        return expense;
    }
}
