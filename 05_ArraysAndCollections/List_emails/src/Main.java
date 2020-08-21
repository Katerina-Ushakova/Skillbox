import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<String> email = new TreeSet<>();
        System.out.println("Доступные команды:\n" +
                "<ADD> <Email> - добавление email в список;\n" +
                "<LIST> - вывод всего списка\n");

        Scanner actions = new Scanner(System.in);
        String text = " ";
        while (text.length() != 0) {
            System.out.println("Введите команду");
            text = actions.nextLine();
            String[] arrayEmail = text.split("\\s+");
            //list
            if (arrayEmail[0].compareToIgnoreCase("list") == 0) {
                System.out.println("Список Email:");
                if (email.size() == 0) {
                    System.out.println("Список пуст!");
                    continue;
                }
                for (String listEmail : email) {
                    System.out.println(listEmail);
                }
            }

            //add
            if (arrayEmail[0].compareToIgnoreCase("add") == 0 && arrayEmail.length ==2)  {
                if (arrayEmail[1].matches("^([A-Za-z0-9_-]+\\.)*[A-Za-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*$")){
                    text = arrayEmail[1];
                    email.add(text);
                    System.out.println("Email добавлен!");
                }
                else {
                    System.out.println("Неверный формат!");
                }
            }
        }
    }
}
