package Employees;

public class TopManager implements Employee {
    private double topManagerIncome;
    private double fixedSalary;
    private double monthSalary;
    private Company topManagerCompany;
    final double BONUS = 150; // %

    public TopManager() {
        setEmployeeIncome();
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

    //случайный доход для компании
    @Override
    public void setEmployeeIncome() {
        topManagerIncome = Math.random() * (30000) + 40000;
    }

    @Override
    public double getEmployeeIncome() {
        return topManagerIncome;
    }

    @Override
    public void setCompany(Company company) {
        this.topManagerCompany = company;
        if (!(company == null)) {
            fixedSalary = (SALARY_MIN + (Math.random() * (SALARY_MAX - SALARY_MIN)));
            if (company.getCompanyIncome() > 10000000) {
                monthSalary = fixedSalary + (fixedSalary * BONUS) / 100;
            } else {
                monthSalary = fixedSalary;
            }
        } else {
            fixedSalary = 0.0;
            monthSalary = 0.0;
        }

    }

    @Override
    public double getMonthSalary() {
        return monthSalary;
    }

    public String toString() {
        return "Топ менеджер. " + "Имя: " + getName() + ", зарплата: " + getMonthSalary() + ".";
    }
}
