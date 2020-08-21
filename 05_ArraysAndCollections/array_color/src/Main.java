public class Main {

    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";
        String[] colorWord = text.split(",?\\s+");
        String temp;
        for (int i = 0; i< colorWord.length/2; i ++) {
            temp = colorWord[colorWord.length-i-1];
            colorWord[colorWord.length-i-1] = colorWord[i];
            colorWord[i] = temp;
        }
        for (int i = 0; i < colorWord.length; i++) {
        System.out.println(colorWord[i]);
        }


        /*String[] colorWord = text.split(",?\\s+");
        for (int i = colorWord.length - 1; i >= 0; i--) {
            System.out.println(colorWord[i]);
        }*/
    }
}