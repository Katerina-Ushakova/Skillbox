package bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

    public class DepositAccount extends BankAbs {
    protected LocalDate dateAdd;
    protected LocalDate dateRid;

    public DepositAccount() {
        money = money;

    }

    //Баланс
    public int getBalance() {
        return money;
    }

    //Внесение денег со читыванием времени
    public void addMoney() {
        System.out.println("Введите сумму, которую хотите внести");
        int addMoney = scanner.nextInt();
        dateAdd = LocalDate.now();
        money = money + addMoney;
        System.out.println("Сумма внесена " + dateAdd.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }

    //Снятие денег не раньше, чем через месяц
    public void ridMoney() {
        dateRid = LocalDate.now();
        if (dateAdd.getMonthValue() - dateRid.getMonthValue() >= 1) {
            System.out.println("Введите сумму, которую хотите снять");

            int ridMoney = scanner.nextInt();
            money = money - ridMoney;
            System.out.println("Заберите деньги!");
        } else {
            System.out.println("Нельзя снимать деньги, месяц не прошел!\n" +
                    "Деньги вносили " + dateAdd.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                    "\nСегодня " + dateRid.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        }
    }
}


