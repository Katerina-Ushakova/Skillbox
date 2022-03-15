import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        HashMap<String, Account> accounts = new HashMap<>();
        List<Thread> threadList = new ArrayList<>();
        Random random = new Random();

        for( int i = 0; i < 1000; i ++) {
            long amountAccount = ThreadLocalRandom.current().nextLong(40000, 400000);
            accounts.put("" + i, new Account("" + i, amountAccount));
        }
        bank.setAccounts(accounts);
        int randomGetBalance = random.nextInt(accounts.size());
        System.out.println("Остаток по счету " + randomGetBalance + " : " + bank.getBalance(Integer.toString(randomGetBalance)));

        System.out.println("Сумма на счетах в банке : " + bank.getSumAllAccounts() + " рублей");
        printBalanceBankOnAccounts(bank);

        for (int i = 0; i < 1000; i++) {
            String fromAccNum = "" + random.nextInt(accounts.size());
            String toAccNum = "" + random.nextInt(accounts.size());
            long amountTransferred = ThreadLocalRandom.current().nextLong(30000, 52000);
            Thread thread = new Thread(() -> bank.transfer(fromAccNum, toAccNum,amountTransferred), i + "THREAD");
            thread.start();
            threadList.add(thread);
        }

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        bank.getSumAllAccounts();
        System.out.println("Остатот по счету " + randomGetBalance + " : " + bank.getBalance(Integer.toString(randomGetBalance)));


    }

    public static void printBalanceBankOnAccounts(Bank bank) {
        bank.getAccounts()
                .forEach((k, v) -> System.out.println("Баланс счёта " + v.getAccNumber() + " : " + v.getMoney() + " рублей"));
    }
}
