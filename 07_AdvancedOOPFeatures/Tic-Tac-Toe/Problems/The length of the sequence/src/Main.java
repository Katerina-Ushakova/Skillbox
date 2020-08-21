import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        for (;;) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            } else {
                count += 1;
            }
        }
        System.out.println(count);
    }
}