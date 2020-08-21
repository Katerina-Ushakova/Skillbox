import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> todoList = new ArrayList<>();
        System.out.println("Доступные команды:\n" +
                "add <Дело> - добавление задачи в конец списка\n" +
                "add <Номер> <Дело> - добавление задачи в указанное место списка\n" +
                "list - вывод всего списка\n" +
                "edit <Номер> <Дело> - замена дела под номером\n" +
                "delete <Номер> - удаление дела под номером\n" +
                "exit - выход из программы\n");

        Scanner actions = new Scanner(System.in);
        String text = " " ;

        while (text.length() != 0) {
            System.out.println("Введите команду");
            text = actions.nextLine();

            switch (text.split(" ")[0]) {
                case "list" : {
                    if (todoList.size() == 0) {
                        System.out.println("Список пуст!");
                        continue;
                    }
                    for (int i = 0; i < todoList.size(); i++) {
                        System.out.println("№" + i + ": " + todoList.get(i));
                    }
                    break;
                }

                case "delete" : {
                    String[] todo = text.split("\\s+");
                    int index = -1;

                    if (todo[1].matches("[0-9]+")) {
                        index = Integer.parseInt(todo[1]);
                        index = index >= todoList.size() ? todoList.size() - 1 : index;
                        todoList.remove(index);
                        System.out.println("Дело удалено!");
                    } else {
                        System.out.println("Не указан номер!");
                    }
                    break;
                }

                case "edit" : {
                    String[] todo = text.split("\\s+");
                    int index = -1;
                    text = "";

                    if (todo[1].matches("[0-9]+")) {
                        index = Integer.parseInt(todo[1]);
                        index = index >= todoList.size() ? todoList.size() - 1 : index;
                        for ( int i = 2; i < todo.length; i++ ) {
                            text = text + todo[i] + " ";
                        }
                        todoList.set(index, text);
                        System.out.println("Дело изменено!");
                    } else {
                        System.out.println("Неверный формат!");
                        continue;
                    }
                    break;
                }

                case "add" : {
                    String[] todo = text.split("\\s+");
                    int index = -1;
                    text = "";

                    if (todo[1].matches("[0-9]+")) {
                        index = Integer.parseInt(todo[1]);
                        index = index > todoList.size() ? todoList.size() : index;
                        for (int i = 2; i < todo.length; i++) {
                            text = text + todo[i] + " ";
                        }
                        todoList.add(index, text);
                        System.out.println("Дело добавлено!");
                    } else {
                        for (int i = 1; i < todo.length; i++) {
                            text = text + todo[i] + " ";
                        }
                        todoList.add(text);
                        System.out.println("Дело добавлено!");
                    }
                    break;
                }

                case "exit" : {
                    System.out.println("Пока!");
                    System.exit(0);
                }

                default: {
                   System.out.println("Неверный формат!");
                }
            }
        }














        /*while (text.length() != 0) {
            System.out.println("Введите команду");
            text = actions.nextLine();
            String[] todo = text.split("\\s+");
            int index = -1;

            //list
            if (todo[0].compareToIgnoreCase("list") == 0) {
                if (todoList.size() == 0) {
                    System.out.println("Список пуст!");
                    continue;
                }
                for (int i = 0; i < todoList.size(); i++) {
                    System.out.println("№" + i + ":" + todoList.get(i));
                }
            }

            //delete
            if (todo[0].compareToIgnoreCase("delete") == 0 && todo.length >= 2) {
                if (todo[1].matches("[0-9]+")) {
                    index = Integer.parseInt(todo[1]);
                    index = index >= todoList.size() ? todoList.size() - 1 : index;
                    todoList.remove(index);
                } else {
                    System.out.println("Не указан номер!");
                }
            }

            //edit
            if (todo[0].compareToIgnoreCase("edit") == 0 && todo.length >=3) {
                if (todo[1].matches("[0-9]+")) {
                    index = Integer.parseInt(todo[1]);
                    index = index >= todoList.size() ? todoList.size() - 1 : index;
                    todoList.set(index, todo[2]);
                } else {
                    System.out.println("Неверный формат!");
                    continue;
                }
            }

            //add c номером
            if (todo[0].compareToIgnoreCase("add") == 0 && todo.length > 2) {
                if (todo[1].matches("[0-9]+")) {
                    index = Integer.parseInt(todo[1]);
                    index = index > todoList.size() ? todoList.size() : index;
                    todoList.add(index, todo[2]);
                } else {
                    text = todo[1];
                    todoList.add(text);
                }
            } else {
                System.out.println("Неверный формат!");
            }
        }*/
    }
}

