import java.util.Scanner;

public class Main {
    public static final int CONTEINER = 27;
    public static final int GRUZOVIK = 324;

    public static void main(String [] args) {
        System.out.println("Введите количество ящиков");
        Scanner kolBox = new Scanner(System.in);
        int  box = kolBox.nextInt();
        int gruzovik2 = 1;
        int conteiner2 = 1;
        int i;

        System.out.println("Грузовик 1: ");
        System.out.println(" Контейней 1: ");
        for (i = 1; i <= box; i++) {
            System.out.println("  Ящик " + i);
            if (i % GRUZOVIK == 0) {
                gruzovik2 +=1;
                System.out.println("Грузовик " + gruzovik2 +":");
            }
            if (i % CONTEINER == 0) {
                conteiner2 += 1;
                System.out.println(" Контейнер " + conteiner2 + ":");
            }
        }

    }
}

