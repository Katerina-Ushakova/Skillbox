import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = 0;
        for (;;) {
            int number = scanner.nextInt();
            if (number >= max) {
                max = number;
            }
            if (number == 0) {
                System.out.println(max);
                break;
            }
        }
    }
}