import javax.xml.namespace.QName;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Loader {
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        System.out.println(text);
        String name = "";
        int wage = 0;
        String [] words = text.split("[^0-9]+");
        for (int i = 1; i < words.length; i++) {
            if (i == 1) {
                name = "Васи";
            } else if (i == 2) {
                name = "Коли";
                    } else {
                name = "Маши";
            }
            System.out.println("Сумма заработка " + name + " = " + words[i]);
        }
        for (String each: text.split("[^0-9]+")) {
            if (each.length() > 0) {
                wage +=Integer.parseInt(each);
            }
        }
        System.out.println("Общая сумма заработка = " + wage);
    }
}


        /*int indexV = text.indexOf("л");
        String textV = text.substring(indexV + 1);
        String textV2 = textV.trim();
        int indexV2 = textV2.indexOf(' ');
        String textV3 = textV2.substring(0,indexV2);
        String textV4 = textV3.trim();
        int num1 = Integer.parseInt(textV4);

        int indexM = text.lastIndexOf('-');
        String textM = text.substring(indexM +1);
        String textM2 = textM.trim();
        int indexM2 = textM2.indexOf('р');
        String textM3 = textM2.substring(0, indexM2);
        String textM4 = textM3.trim();
        int num2 = Integer.parseInt(textM4);

        int num3 = num1 + num2;
        System.out.println("Сумма заработка = " + num3);*/

