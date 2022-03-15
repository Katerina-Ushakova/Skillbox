import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a =0;
        int b = 0;
        int c = 0;
        for (int i = 1; i <= n; i++) {
            int number = scanner.nextInt();
            if (number == 0) {
                a = a + 1;
            } else if (number == 1) {
                b = b + 1;
            } else if (number == -1) {
                c = c + 1;
            }
        }
        System.out.println(a + " " + b + " " + c);
    }
}