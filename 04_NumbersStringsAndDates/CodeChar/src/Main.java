public class Main {
    public static void main(String[] args) {
        System.out.println("Латинский алфовит");
        for (char i = 'a'; i <= 'z'; i++) {
            int code =  i;
            System.out.println("Код буквы " + i + ": " + code);
        }

        System.out.println("Русский алфовит");
        for (char j = 'а'; j <= 'я'; j++) {
            int code1 = j;
            System.out.println("Код буквы " + j + ": " + code1);

        }
    }
}
