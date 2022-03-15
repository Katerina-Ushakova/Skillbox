import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        int night = day - 1;
        int costFood = scanner.nextInt();
        int costFlight = scanner.nextInt();
        int costOneNight = scanner.nextInt();
        int sumMoney = costFlight * 2 + costFood * day + costOneNight * night;
        System.out.println(sumMoney);
    }
}