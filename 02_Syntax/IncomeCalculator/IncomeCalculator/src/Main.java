import java.util.Scanner;

public class Main
{
    private static int minIncome = 200000; //минимальный доход
    private static int maxIncome = 900000; //максимальный доход

    private static int officeRentCharge = 140000; //плата за аренду офиса
    private static int telephonyCharge = 12000; //плата за тлф
    private static int internetAccessCharge = 7200; //плота за интерет

    private static int assistantSalary = 45000; //зарплата ассистента
    private static int financeManagerSalary = 90000; //зарплата финансового менеджера

    private static double mainTaxPercent = 0.24; //основной налоговый процент
    private static double managerPercent = 0.15; // менеджер процент

    private static double minInvestmentsAmount = 100000; //минимальная сумма инвестиции
    public static void main(String[] args)
    {
        double minIncome =    (minInvestmentsAmount / (1 - mainTaxPercent) + calculateFixedCharges()) / (1 - managerPercent);
        System.out.println("Минимальная сумма дохода: " + minIncome);

        while(true)
        {
            System.out.println("Введите сумму доходов компании за месяц " +
                "(от 200 до 900 тысяч рублей): ");
            int income = (new Scanner(System.in)).nextInt(); //присваивает введеное зачение

            if(!checkIncomeRange(income)) {
                continue;
            }

            double managerSalary = income * managerPercent; //рассчитывает зарплата менеджера
            double pureIncome = income - managerSalary -
                calculateFixedCharges(); //рассчитывает чистый доход
            double taxAmount = mainTaxPercent * pureIncome; //рассчитывает сумма налога
            double pureIncomeAfterTax = pureIncome - taxAmount; //рассчитывает чистый доход после налообложения

            boolean canMakeInvestments = pureIncomeAfterTax >=
                minInvestmentsAmount; //можете делать инвестиции
            //вывод данных на экран
            System.out.println("Зарплата менеджера: " + managerSalary);
            System.out.println("Общая сумма налогов: " +
                (taxAmount > 0 ? taxAmount : 0));
            System.out.println("Компания может инвестировать: " +
                (canMakeInvestments ? "да" : "нет"));
            if(pureIncome < 0) {
                System.out.println("Бюджет в минусе! Нужно срочно зарабатывать!");
            }
        }
    }

    private static boolean checkIncomeRange(int income)
    {
        if(income < minIncome)
        {
            System.out.println("Доход меньше нижней границы");
            return false;
        }
        if(income > maxIncome)
        {
            System.out.println("Доход выше верхней границы");
            return false;
        }
        return true;
    }

    private static int calculateFixedCharges()
    {
        return officeRentCharge +
                telephonyCharge +
                internetAccessCharge +
                assistantSalary +
                financeManagerSalary;
    }
}
