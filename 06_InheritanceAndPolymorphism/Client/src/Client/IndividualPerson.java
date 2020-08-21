package Client;

public class IndividualPerson extends Client {
    public IndividualPerson(){
        money = money;
    }

    //Баланс
    public int getBalance() {
        return 0;
    }

    //Внесение денег
    public void addMoney() {
        System.out.println("Введите сумму, которую хотите внести");
        int addMoney = scanner.nextInt();
        if (addMoney >= 1000) {
            money = money + addMoney - (addMoney / 200);
            System.out.println("Сумма внесена! Комиссия составила " + (addMoney / 200));
        }else {
            money = money + addMoney - (addMoney / 100);
            System.out.println("Сумма внесена!Комиссия составила " + (addMoney / 100));
        }
    }

    //Снятие денег
    public void ridMoney() {
        System.out.println("Введите сумму, которую хотите снять");
        int ridMoney = scanner.nextInt();
        if (money != 0 ) {
            if (money > ridMoney) {
                money = money - ridMoney;
                System.out.println("Заберите деньги!");
            }else {
                System.out.println("Недостаточно средств!");
            }
        }else {
            System.out.println("Баланс равен 0!");
        }
    }


}
