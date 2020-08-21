import bank.BankAbs;
import bank.CardAccount;
import bank.DepositAccount;
import bank.PaymentAccount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = " ";

        BankAbs accountP = new PaymentAccount();
        BankAbs accountD = new DepositAccount();
        BankAbs accountC = new CardAccount();

        for (;;) {
            System.out.println("Какой счет хотите использовать: расчетный, депозитный, карточный?");
            text = scanner.nextLine();

            if (text.equals("расчетный")) {
                System.out.println("Команды: \n" + "" +
                        "1 - Внести деньги\n" +
                        "2 - Снять деньги\n" +
                        "3 - Баланс\n" +
                        "4 - Выход");
                System.out.println("Введите номер команды");
                text = scanner.nextLine();
                switch (text) {
                    //Внесение денег (расчетный)
                    case "1": {
                        accountP.addMoney();
                        break;
                    }
                    //Снятие денег (расчетный)
                    case "2": {
                        accountP.ridMoney();
                        break;
                    }
                    //Баланс (расчетный)
                    case "3": {
                        System.out.println("Ваш баланс: " + accountP.getBalance());
                        break;
                    }
                    //Выход
                    case "4": {
                        System.out.println("Пока!");
                        System.exit(0);
                    }
                }
            }else if (text.equals("депозитный")) {
                    System.out.println("Команды: \n" + "" +
                            "1 - Внести деньги\n" +
                            "2 - Снять деньги\n" +
                            "3 - Баланс\n" +
                            "4 - Выход");
                    System.out.println("Введите номер команды");
                    text = scanner.nextLine();
                    switch (text) {
                        //Внесение денег (депозитный)
                        case "1": {
                            accountD.addMoney();
                            break;
                        }
                        // Снятие денег (депозитный)
                        case "2": {
                            accountD.ridMoney();
                            break;
                        }
                        // Баланс (депозитный)
                        case "3": {
                            System.out.println("Ваш баланс: " + accountD.getBalance());
                            break;
                        }
                        //Выход
                        case "4" : {
                            System.out.println("Пока!");
                            System.exit(0);
                        }
                    }
                }else if (text.equals("карточный")){
                    System.out.println("Команды: \n" + "" +
                            "1 - Внести деньги\n" +
                            "2 - Снять деньги\n" +
                            "3 - Баланс\n" +
                            "4 - Выход");
                    System.out.println("Введите номер команды");
                    text = scanner.nextLine();
                    switch (text) {
                        //Внесение денег (карточный)
                        case "1": {
                            accountC.addMoney();
                            break;
                        }
                        //Снятие денег (карточный)
                        case "2": {
                            accountC.ridMoney();
                            break;
                        }
                        //Баланс (карточный)
                        case "3": {
                            System.out.println("Ваш баланс: " + accountC.getBalance());
                            break;
                        }
                        //Выход
                        case "4" : {
                            System.out.println("Пока!");
                            System.exit(0);
                        }
                    }
                }
            }

        /*for (;;) {
            System.out.println("Введите номер команды");
            text = scanner.nextLine();

            switch (text) {
                //Внесение денег (расчетный)
                case "1.1" : {
                    accountP.addMoney();
                    break;
                }
                //Снятие денег (расчетный)
                case "2.1" : {
                    accountP.ridMoney();
                    break;
                }
                //Баланс (расчетный)
                case "3.1" : {
                    System.out.println("Ваш баланс: " + accountP.getBalance());
                    break;
                }

                //Внесение денег (депозитный)
                case "1.2" : {
                    accountD.addMoney();
                    break;
                }
                // Снятие денег (депозитный)
                case "2.2" : {
                    accountD.ridMoney();
                    break;
                }
                // Баланс (депозитный)
                case "3.2" : {
                    System.out.println("Ваш баланс: " + accountD.getBalance());
                    break;
                }

                //Внесение денег (карточный)
                case "1.3" : {
                    accountC.addMoney();
                    break;
                }
                //Снятие денег (карточный)
                case "2.3" : {
                    accountC.ridMoney();
                    break;
                }
                //Баланс (карточный)
                case "3.3" : {
                    System.out.println("Ваш баланс: " + accountC.getBalance());
                    break;
                }

                //Выход
                case "4" : {
                    System.out.println("Пока!");
                    System.exit(0);
                }
            }
        }


        //Расчетный
        /*for(;;) {
            System.out.println("Введите номер команды");
            text = scanner.nextLine();

            switch (text) {
                //Внесение денег
                case "1" : {
                    accountP.addMoney();
                    break;
                }
                //Снятие денег
                case "2" : {
                    accountP.ridMoney();
                    break;
                }
                //Баланс
                case "3" : {
                    System.out.println("Ваш баланс: " + accountP.getBalance());
                    break;
                }
                case "4" : {
                    System.out.println("Пока!");
                    System.exit(0);
                }

            }
        }

        //Депозитный
        DepositAccount accountD = new DepositAccount();
        for (;;) {
            System.out.println("Введите номер команды");
            text = scanner.nextLine();

            switch (text) {
                //Внесение денег
                case "1" : {
                    accountD.addMoney();
                    break;
                }
                // Снятие денег
                case "2" : {
                    accountD.ridMoney();
                    break;
                }
                // Баланс
                case "3" : {
                    System.out.println("Ваш баланс: " + accountD.getBalance());
                    break;
                }
                case "4" : {
                    System.out.println("Пока!");
                    System.exit(0);
                }
            }
        }

        //Карточный
        CardAccount accountC = new CardAccount();
        for (;;) {
            System.out.println("Введите номер команды");
            text = scanner.nextLine();

            switch (text) {
                //Внесение денег
                case "1" : {
                    accountC.addMoney();
                    break;
                }
                //Снятие денег
                case "2" : {
                    accountC.ridMoney();
                    break;
                }
                //Баланс
                case "3" : {
                    System.out.println("Ваш баланс: " + accountC.getBalance());
                    break;
                }
                case "4" : {
                    System.out.println("Пока!");
                    System.exit(0);
                }
            }
        }*/
    }
}
