import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //Создание "красивых" номеров
        String[] letters = new String[]{"А", "Б", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        for (int k = 1; k < 200; k++) {
            for (int i = 0; i < letters.length; i++) {
                for (int j = 1; j < 10; j++) {
                    String letter = letters[i];
                    String num = String.format("%s%d%d%d%s%s", letter, j, j, j, letter, letter);
                    String kod = Integer.toString(k);
                    String number = num + kod;
                    list.add(number);
                }
            }
        }

        HashSet<String> setHash = new HashSet<>();
        setHash.addAll(list);

        TreeSet<String> setTree = new TreeSet<>();
        setTree.addAll(list);

        //Сканер
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер");
        String text = scanner.nextLine();

        for (;;) {

            //Перебор
            System.out.print("Поиск перебором: ");
            long start = System.nanoTime();
            System.out.print(list.contains(text) ? "номер найден, " : "номер не найден, ");
            long duration = System.nanoTime() - start;
            System.out.print("поиск занял " + duration + "нс");

            //Бинарный поиск
            System.out.print("\nБинарный поиск: ");
            start = System.nanoTime();
            int index = Collections.binarySearch(list, text);
            System.out.print(index > 0 ? "номер найден, " : "номер не найден, ");
            duration = System.nanoTime() - start;
            System.out.print("поиск занял " + duration + "нс");

            //Hash поиск
            System.out.print("\nПоиск в HashSet: ");
            start = System.nanoTime();
            System.out.print(setHash.contains(text) ? "номер найден, " : "номер не найден, ");
            duration = System.nanoTime() - start;
            System.out.print("поиск занял " + duration + "нс");

            //Tree поиск
            System.out.print("\nПоиск в TreeSet: ");
            start = System.nanoTime();
            System.out.print(setTree.contains(text) ? "номер найден, " : "номер не найден, ");
            duration = System.nanoTime() - start;
            System.out.print("поиск занял " + duration + "нс");

            break;
        /*//Вывод "красивых" номеров
        for (int l = 0; l < list.size(); l++) {
            System.out.println(list.get(l));
        }*/
        }

    }
}
