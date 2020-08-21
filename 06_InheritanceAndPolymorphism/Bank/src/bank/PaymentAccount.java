package bank;

public class PaymentAccount extends BankAbs{

    public PaymentAccount() {
        money = money;

    }
    //Внесение денег
    public void addMoney() {
        System.out.println("Введите сумму, которую хотите внести");
        int addMoney = scanner.nextInt();
        money = money + addMoney;
        System.out.println("Сумма внесена!");
    }

    //Баланс
    public int getBalance() {
       return money;
    }

    //Снятие денег
    public void ridMoney() {
        System.out.println("Введите сумму, которую хотите снять");
        int ridMoney = scanner.nextInt();
        if (money != 0) {
            if (money >= ridMoney) {
                money = money - ridMoney;
                System.out.println("Заберите деньги!");
            }
            else {
                System.out.println("Недостаточно средств!");
            }
        } else {
            System.out.println("Баланс равен 0!");
        }
    }
}
