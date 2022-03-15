import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int group1 = scanner.nextInt();
        int group2 = scanner.nextInt();
        int group3 = scanner.nextInt();

        int sum1 = (group1 + 1) / 2;
        int sum2 = (group2 + 1) / 2;
        int sum3 = (group3 + 1) / 2;
        int table = sum1 + sum2 + sum3;

        System.out.println(table);
    }
}