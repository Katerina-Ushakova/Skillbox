import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String newText = text.replace('a', 'b').replace('A', 'B');
        System.out.println(newText);
    }
}