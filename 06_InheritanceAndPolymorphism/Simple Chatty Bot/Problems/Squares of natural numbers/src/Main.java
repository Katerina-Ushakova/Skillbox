import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        int square = 0;
        int n = 1;

        while (square <= value) {
            square = n * n;
            n++;
            if (square <= value) {
                System.out.println(square);
            }
        }
    }
}