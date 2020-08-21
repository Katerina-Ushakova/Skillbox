package Employees;

public class Operator implements Employee {

    private double fixedSalary;
    private double monthSalary;
    private Company operatorCompany;

    public Operator() {
        fixedSalary = 0.0;
    }

    @Override
    public String getName() {
        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                builder.append(letters.charAt(rand.nextInt(letters.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }

    @Override
    public double getEmployeeIncome() {
        return 0;
    }

    //случайный доход для компании (у операторов его нет)
    @Override
    public void setEmployeeIncome() {

    }

    @Override
    public void setCompany(Company company) {
        this.operatorCompany = company;
        if (!(company == null)) {
            fixedSalary = (SALARY_MIN + (Math.random() * (SALARY_MAX - SALARY_MIN)));
            monthSalary = fixedSalary;
        } else {
            monthSalary = 0.0;
        }
    }

    @Override
    public double getMonthSalary() {
        return monthSalary;
    }

    public String toString() {
        return "Оператор. Имя: " + getName() + ", зарплата: " + getMonthSalary() + ".";
    }
}
