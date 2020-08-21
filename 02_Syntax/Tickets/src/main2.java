public class main2 {
    public static void main(String[] args) {
        int ticket = 200000;
        while (ticket <= 240000) {
            if (ticket <= 210000) {
                System.out.println("Билет №" + ticket);
            }else if ((ticket >=220000 && ticket <=235000)) {
                System.out.println("Билет №" + ticket);
            }
            ticket++;
        }
    }
}


