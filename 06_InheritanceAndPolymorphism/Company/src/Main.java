import Employees.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Company leo = new Company("Leo");

        List<Employee> notHiredEmployees = new ArrayList<>();

        //найм операторов
        for (int i = 0; i <= 180; i++) {
            notHiredEmployees.add(new Operator());
        }
        //найм менеджеров
        for (int i = 0; i <= 80; i++) {
            notHiredEmployees.add(new Manager());
        }
        //найм топ менеджеров
        for (int i = 0; i <=10; i++) {
            notHiredEmployees.add(new TopManager());
        }

        leo.setCompanyIncome(70000000);
        leo.hireAll(notHiredEmployees);
        leo.getTopSalaryStaff(15);
        leo.getLowestSalaryStaff(30);
        System.out.println("Доход компании ДО увольнения сотрудников = " + leo.getCompanyIncome());
        leo.printCompanyList();
        leo.fireHalf();
        System.out.println("Доход компании ПОСЛЕ увольнения сотрудников = " + leo.getCompanyIncome());
        leo.printCompanyList();
        leo.getTopSalaryStaff(15);
        leo.getLowestSalaryStaff(30);
    }
}