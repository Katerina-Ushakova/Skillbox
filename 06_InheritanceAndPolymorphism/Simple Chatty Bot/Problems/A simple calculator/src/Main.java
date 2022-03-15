import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long firstNumber = scanner.nextLong();
        String operation = scanner.next();
        long secondNumber = scanner.nextLong();
        long result;
        switch (operation) {
            case "+":
                result = firstNumber + secondNumber;
                System.out.println(result);
                break;
            case "-" :
                result = firstNumber - secondNumber;
                System.out.println(result);
                break;
            case "/" :
                if (secondNumber == 0) {
                    System.out.println("Division by 0!");
                } else {
                    result = firstNumber / secondNumber;
                    System.out.println(result);
                }
                break;
            case "*" :
                result = firstNumber * secondNumber;
                System.out.println(result);
                break;
            default :
                System.out.println("Unknown operator");
        }
    }
}