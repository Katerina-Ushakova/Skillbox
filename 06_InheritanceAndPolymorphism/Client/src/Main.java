import Client.Client;
import Client.NaturalPerson;
import Client.LegalPerson;
import Client.IndividualPerson;
import Client.ClientTypes;

import java.util.*;

import static Client.ClientTypes.*;

public class Main {
    public static ClientTypes types;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = " ";
        final int[] natural = {4747, 4748, 4749};
        final int[] legal = {3737, 3738, 3739};
        final int[] individual = {2728, 2727, 2729};

        NaturalPerson naturalP = new NaturalPerson();
        Client legalP = new LegalPerson();
        Client individualP = new IndividualPerson();

        for (; ; ) {
        System.out.println("Введите номер счета");

        text = scanner.nextLine();
        int kod = Integer.parseInt(text);

        for (int i = 0; i < natural.length; i++) {
            if(natural[i] == kod) {
                types = ClientTypes.NATURAL;
            }
        }
        for (int i = 0; i < legal.length; i++) {
            if(legal[i] == kod) {
                types = ClientTypes.LEGAL;
            }
        }
        for (int i = 0; i < individual.length; i++) {
            if(individual[i] == kod) {
                types = ClientTypes.INDIVIDUAL_ENTREPRENEUR;
            }
        }

            switch (types) {

                case NATURAL: {
                    System.out.println("Счет физического лица");
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
                            naturalP.addMoney();
                            break;
                        }
                        //Снятие денег (расчетный)
                        case "2": {
                            naturalP.ridMoney();
                            break;
                        }
                        //Баланс (расчетный)
                        case "3": {
                            System.out.println("Ваш баланс: " + naturalP.getBalance());
                            break;
                        }
                        //Выход
                        case "4": {
                            System.out.println("Пока!");
                            System.exit(0);
                        }
                    }
                    break;
                }
                case LEGAL: {
                    System.out.println("Счет юридического лица");
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
                            legalP.addMoney();
                            break;
                        }
                        //Снятие денег (расчетный)
                        case "2": {
                            legalP.ridMoney();
                            break;
                        }
                        //Баланс (расчетный)
                        case "3": {
                            System.out.println("Ваш баланс: " + legalP.getBalance());
                            break;
                        }
                        //Выход
                        case "4": {
                            System.out.println("Пока!");
                            System.exit(0);
                        }
                    }
                    break;
                }
                case INDIVIDUAL_ENTREPRENEUR: {
                    System.out.println("Счет ИП");
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
                            individualP.addMoney();
                            break;
                        }
                        //Снятие денег (расчетный)
                        case "2": {
                            individualP.ridMoney();
                            break;
                        }
                        //Баланс (расчетный)
                        case "3": {
                            System.out.println("Ваш баланс: " + individualP.getBalance());
                            break;
                        }
                        //Выход
                        case "4": {
                            System.out.println("Пока!");
                            System.exit(0);
                        }
                    }
                }
            }


        }
    }
}