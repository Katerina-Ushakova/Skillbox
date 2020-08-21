package bank;

import java.util.Scanner;

public abstract class BankAbs {
    protected int money;
    Scanner scanner = new Scanner(System.in);

    public abstract void addMoney();

    public abstract void ridMoney();

    public abstract int getBalance();

}
