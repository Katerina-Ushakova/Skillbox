import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height1 = scanner.nextInt();
        int height2 = scanner.nextInt();
        int height3 = scanner.nextInt();
        boolean result = false;
        if (((height1 <= height2) && (height2 <= height3)) || (height1 >= height2) && (height2 >= height3) ) {
            result = true;
        }
        System.out.println(result);
    }
}