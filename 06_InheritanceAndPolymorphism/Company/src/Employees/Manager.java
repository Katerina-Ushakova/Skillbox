package Employees;

public class Manager implements Employee {
    private double managerIncome;
    private double fixedSalary;
    private double monthSalary;
    private Company managerCompany;
    final double BONUS = 5; // %

    public Manager() {
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
        managerIncome = Math.random() * (25000) + 35000;
    }

    @Override
    public double getEmployeeIncome() {
        return managerIncome;
    }

    @Override
    public void setCompany(Company company) {
        this.managerCompany = company;
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
        return "Менеджер. " + "Имя: " + getName() + ", зарплата: " + getMonthSalary() + ".";
    }
}

