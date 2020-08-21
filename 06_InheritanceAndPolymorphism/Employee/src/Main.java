import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Company google = new Company("Google");
        System.out.println("Введите доход компании:");
        Scanner scanner = new Scanner(System.in);
        int income = scanner.nextInt();
        google.setIncome(income);
        System.out.println("Доход компании = " + google.getIncome());

        for (int i = 1; i < 10; i++) {
            //Operator
            Operator operator = new Operator();
            //operator.setId(i);
            operator.getName();
            google.hire(operator);
            operator.setCompany(google);
            System.out.println("Зарплата оператора " + operator.getName() + " = " + operator.getMonthSalary());
        }
        for (int i = 1; i < 10; i++) {
            //Manager
            Manager manager = new Manager();
            //manager.setId(i);
            google.hire(manager);
            manager.setCompany(google);
            System.out.println("Зарплата менеджера " + manager.getName() + " = " + manager.getMonthSalary());
        }
        for (int i = 1; i < 10; i++) {
            // TopManager
            TopManager topManager = new TopManager();
            //topManager.setId(i);
            google.hire(topManager);
            topManager.setCompany(google);
            System.out.println("Зарплата топ-менеджера " + topManager.getName() + " = " + topManager.getMonthSalary());
        }


    }
}
