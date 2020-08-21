package Client;

public class LegalPerson extends Client {

    public LegalPerson() {
        money = money;
    }

    //Баланс
    public int getBalance() {
        return money;
    }

    //Внесение денег
    public void addMoney() {
        System.out.println("Введите сумму, которую хотите внести");
        int addMoney = scanner.nextInt();
        money = money + addMoney;
        System.out.println("Сумма внесена!");
    }

    //Снятие денег
    public void ridMoney() {
        System.out.println("Введите сумму, которую хотите снять");
        int ridMoney = scanner.nextInt();
        if (money != 0) {
            if(money >= ridMoney) {
                money = money - ridMoney - (ridMoney / 100);
                System.out.println("Заберите деньги!");
            }else {
                System.out.println("Недостаточно средств!");
            }
        }else {
            System.out.println("Баланс равен 0!");
        }
    }
}
