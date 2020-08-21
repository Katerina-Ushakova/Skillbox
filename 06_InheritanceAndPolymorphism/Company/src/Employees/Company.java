package Employees;

import java.util.*;

public class Company {
    List<Employee> companyList = new ArrayList<>();
    int companyIncome;
    private String nameCompany;

    public Company(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    //найм сотрудника
    public void hire(Employee employee) {
    employee.setEmployeeIncome();
    employee.setCompany(this);
    setCompanyIncome((int) (getCompanyIncome() + employee.getEmployeeIncome()));
    companyList.add(employee);
    }

    //найм списка сотрудников
    public void hireAll(List<Employee> list) {
        int income = 0;
        for (Employee employee : list) {
            employee.setEmployeeIncome();
            employee.setCompany(this);
            income += employee.getEmployeeIncome();
        }
        setCompanyIncome(income + getCompanyIncome());
        companyList.addAll(list);
    }

    //увольнение случайного сотрудника
    public void  fire() {
        int firedEmployee = (int) (Math.random() * (companyList.size()));
        System.out.println("Зарплата уволенного: " + companyList.get(firedEmployee).getEmployeeIncome());
        setCompanyIncome((int) (getCompanyIncome() - companyList.get(firedEmployee).getEmployeeIncome()));
        companyList.remove(firedEmployee);
    }

    //увольнение 50% случайных сотрудников
    public void fireHalf() {
        int countEmployees = companyList.size();
        int countEmployeesIncome = 0;
        for (int i = 0; i < countEmployees / 2; i++) {
            int firedEmployee = (int) (Math.random() * (companyList.size()));
            countEmployeesIncome += companyList.get(firedEmployee).getEmployeeIncome();
            companyList.remove(firedEmployee);
        }
        System.out.println("Зарплаты уволенных сотрудников: " + countEmployeesIncome);
        setCompanyIncome(getCompanyIncome() - countEmployeesIncome);
    }

    //изначальный доход компании
    public void setCompanyIncome(int companyIncome) {
        this.companyIncome = companyIncome;
    }

    //получение дохода компании
    public int getCompanyIncome() {
        return companyIncome;
    }

    //список из самых высоких зарплат
    public void getTopSalaryStaff(int count) {
        if (count > companyList.size() || count <= 0) {
            System.out.println("Ошибка. Неправильный ввод!");
        } else {
            companyList.sort((o1, o2) -> Double.compare(o2.getMonthSalary(), o1.getMonthSalary()));
            System.out.println();
            System.out.println("======================");
            System.out.println("Список самых высоких зарплат: ");
            for (int i = 1; i <= count; i++) {
                System.out.println("№" + i + " " + companyList.get(i) + " Работает в компании: " + nameCompany);
            }
            System.out.println("======================");
            System.out.println();
        }
    }

    //список самых низкин зарплат
    public void getLowestSalaryStaff(int count) {
        if (count > companyList.size() || count <= 0) {
            System.out.println("Ошибка. Неверный ввод!");
        } else {
            companyList.sort(Comparator.comparingDouble(Employee::getMonthSalary));
            System.out.println();
            System.out.println("======================");
            System.out.println("Список самых низких зарплат: ");
            for (int i = 1; i <= count; i++) {
                System.out.println("№" + i + " " + companyList.get(i) + " Работает в компании: " + nameCompany);
            }
            System.out.println("======================");
            System.out.println();
        }
    }

    //количество сотрудников в компании
    public void printCompanyList() {
        System.out.println("Число сотрудников: " + companyList.size());
    }
}
