import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        int max = 0;
        int number;

        while (i < n) {
            number = scanner.nextInt();
            if (number % 4 == 0) {
                if (number >= max) {
                    max = number;
                }
            }
            i++;
        }
        System.out.println(max);
    }
}