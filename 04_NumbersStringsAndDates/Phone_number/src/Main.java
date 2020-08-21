import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        System.out.println("Введите номер телефона ");
        String number = num.nextLine();
        String number2 = number.replaceAll("[^0-9]", "");
        System.out.println("7" + number2.substring(0 + 1));

    }
}
