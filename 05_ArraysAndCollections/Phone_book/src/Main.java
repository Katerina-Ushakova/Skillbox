import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeMap <String, String> phoneBook = new TreeMap<>();
        System.out.println("Команда <LIST> выводит весь список");
        String name = " ";
        Scanner scanner = new Scanner(System.in);
        for (;;) {
            System.out.println("Введите Имя / Номер телефона / Команду");
            String phoneName = scanner.nextLine();
            String[] phoneArray = phoneName.split("\\s+");

            //list
            if (phoneArray[0].compareToIgnoreCase("list") == 0) {
                if (phoneBook.size() == 0) {
                    System.out.println("Список пуст!");
                    continue;
                } else {
                    listBook(phoneBook);
                }
            }

            //ввод только номера
            if (phoneArray[0].matches("[+0-9]+")) { //&& phoneArray.length == 1) {
                String phone = phoneName.replaceAll("[^0-9]", "").substring(0 + 1);
                if (phoneBook.containsValue(phone)) {
                    for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                        if (entry.getValue().equals(phone)) {
                            System.out.println("Данные: \n" + entry.getKey() + " - " + phone);
                        }
                    }
                } else {
                    Scanner scannerName = new Scanner(System.in);
                    System.out.println("Введите имя");
                    name = scannerName.nextLine();
                    phoneBook.put(name, phone);
                }
            }

            //ввод только имени
            if (phoneArray[0].matches("[А-Яа-я]+(\\s[А-Яа-я]+)?") && phoneArray.length >= 1) {
                if (phoneBook.containsKey(phoneName)) {
                    System.out.println("Данные: \n" + phoneName + " - " + phoneBook.get(phoneName));
                } else {
                    Scanner scannerName = new Scanner(System.in);
                    System.out.println("Введите номер телефона");
                    String number = scannerName.nextLine();
                    String phone = number.replaceAll("[^0-9]", "").substring(0 + 1);
                    phoneBook.put(phoneName, phone);
                }
            }
        }
    }

    //команда list
    public static void listBook(Map<String, String> map) {
        System.out.println("\tСписок контактов:");
        for (String name : map.keySet()) {
            System.out.println(name + " - " + map.get(name));
        }
    }
}
