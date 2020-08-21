package Employees;

import java.util.HashSet;
import java.util.Set;

public interface Employee {
    double SALARY_MIN = 100000.0;
    double SALARY_MAX = 200000.0;

    String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    java.util.Random rand = new java.util.Random();
    Set<String> identifiers = new HashSet<>();

    double getMonthSalary();
    double getEmployeeIncome();
    void setEmployeeIncome();
    void setCompany (Company company);
    String getName();
}
