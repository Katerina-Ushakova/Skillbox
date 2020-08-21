import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите данные ");
        String fio = in.nextLine();
        String surname = ""; //фамилия
        String name = ""; //имя
        String middleName = ""; //отчество
        String space = " "; //считывающийся символ
        int len = fio.length();
        int newLen = fio.replaceAll(space, "").length();
        int spaceTotal = (len - newLen); //считаются пробелы
        String num = "";
        if (spaceTotal > 4) {
            System.out.println("Данные указаны неверно. Введите ФИО верно");
        } else if (spaceTotal == 0 || spaceTotal == 1) {
            System.out.println("Данные указаны неверно. Введите ФИО верно");
        } else if (!fio.matches("^[А-Я][а-я]*([-][А-Я][а-я]*)?\\s[А-Я][а-я]*\\s[А-Я][а-я]*([-][А-Я][а-я]*)?\\s[а-я]*$")) {
            System.out.println("Данные указаны неверно. Введите ФИО верно");
        } else {
            int indexF = fio.indexOf(' ');
            surname = fio.substring(0, indexF);
            System.out.println("Фамилия: " + surname);
            String fio1 = fio.substring(indexF +1);
            int indexN = fio1.indexOf(' ');
            name = fio1.substring(0, indexN);
            System.out.println("Имя: " + name);
            middleName = fio1.substring(indexN + 1);
            System.out.println("Отчество: " + middleName);

// [\\p{L}| ]+
           /* //фамилия
            int indexF = fio.indexOf(' ');
            String f = fio.substring(0, indexF);
            surname = f.trim();
            System.out.println("Фамилия: " + surname);

            //имя
            String n = fio.substring(indexF, fio.lastIndexOf(' '));
            name = n.trim();
            System.out.println("Имя: " + name);

            //отчество
            int indexM = fio.lastIndexOf(' ');
            String m = fio.substring(indexM + 1);
            middleName = m.trim();
            System.out.println("Отчество: " + middleName);*/
        }
    }
}
