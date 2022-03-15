import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalNumber = 0;
        double sum = 0.0;
        double average = 0.0;
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        for (int i = a; i <= b; i++) {
            if (i % 3 == 0) {
                totalNumber++;
                sum = sum + i;
                average = sum / totalNumber;
            }
        }
        System.out.println(average);
    }
}