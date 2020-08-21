import java.nio.charset.IllegalCharsetNameException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        System.out.println("Введите длину массива");
        s = scanner.nextLine();
        int size = Integer.parseInt(s);

        int i = size;
        int j = size;
        String[][] theCross = new String[i][j];

        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                if (i == j || (size == i + j + 1)) {
                    theCross[i][j] = "X" ;
                } else {
                    theCross[i][j] = " " ;
                }
                System.out.print(theCross[i][j]);
            }
            System.out.print("\n");
        }
    }
}
