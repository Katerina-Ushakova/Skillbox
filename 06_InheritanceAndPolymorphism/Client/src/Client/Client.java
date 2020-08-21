package Client;

import java.util.Scanner;

public abstract class Client {
    protected int money;
    Scanner scanner = new Scanner(System.in);

    public abstract void addMoney();
    public abstract void ridMoney();
    public abstract int getBalance();
}
