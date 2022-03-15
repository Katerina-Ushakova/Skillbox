import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        for (;;) {
            int value = scanner.nextInt();

            if (sum < 1000) {
                sum = sum + value;
            } else {
                sum = sum - 1000;
                System.out.println(sum);
                break;
            }

            if (value == 0) {
                System.out.println(sum);
                break;
            }
        }
    }
}