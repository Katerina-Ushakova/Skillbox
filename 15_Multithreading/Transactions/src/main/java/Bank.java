import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Random;

public class Bank {

    @Getter
    @Setter
    private Map<String, Account> accounts;
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        synchronized (fromAccountNum.compareTo(toAccountNum) > 0 ? fromAccountNum : toAccountNum) {
            synchronized (fromAccountNum.compareTo(toAccountNum) > 0 ? toAccountNum : fromAccountNum) {
                if (accounts.get(fromAccountNum).getMoney() - amount > 0) {
                    if (accounts.get(fromAccountNum).isWithoutBlockAcc() &&
                            accounts.get(toAccountNum).isWithoutBlockAcc()) {
                        accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
                        accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
                        System.out.println("Выполнена транзакция на сумму " + amount + " рублей, со счета "
                                + fromAccountNum + " на счет " + toAccountNum);

                        if (amount > 50000) {
                            try {
                                if (isFraud(fromAccountNum, toAccountNum, amount)) {
                                    accounts.get(fromAccountNum).setWithoutBlockAcc(false);
                                    accounts.get(toAccountNum).setWithoutBlockAcc(false);
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } else if (!accounts.get(fromAccountNum).isWithoutBlockAcc())
                        System.out.println("Счет " + fromAccountNum + " заблокирован!");
                    else if (!accounts.get(toAccountNum).isWithoutBlockAcc())
                        System.out.println("Счет " + toAccountNum + " заблокирован!");
                    else
                        System.out.println("На счете " + fromAccountNum + " недостаточно средств");

                }
            }
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        return  getAccounts()
                .values()
                .stream()
                .mapToLong(Account::getMoney)
                .sum();
    }
}
