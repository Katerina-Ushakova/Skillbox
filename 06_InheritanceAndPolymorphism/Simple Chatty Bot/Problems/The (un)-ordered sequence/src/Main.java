import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        int num2 = scanner.nextInt();

        if(num2 == 0)
            System.out.println("true");
        else while (num2 != 0) {
            if (num == num2) {
                while (num == num2) {
                    num = num2;
                    num2 = scanner.nextInt();
                }
                if (num2 == 0) {
                    System.out.println("true");
                    break;
                }
            }
            if (num > num2) {
                while (scanner.hasNextInt() && num >= num2) {
                    num = num2;
                    num2 = scanner.nextInt();
                    if (num2 == 0) {
                        System.out.println("true");
                        break;
                    }
                }
                if (num2 != 0) {
                    System.out.println("false");
                    num2 = 0;
                }
            } else if (num < num2) {
                while (scanner.hasNextInt() && num <= num2) {
                    num = num2;
                    num2 = scanner.nextInt();
                    if (num2 == 0) {
                        System.out.println("true");
                        break;
                    }else if(num > num2){
                        System.out.println("false");
                        num2 = 0;
                    }
                }
            }
        }

    }
}