public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.count += 7843;
        System.out.println("Число " + container.count);
        sumDigits(container.count);

    }

    public static Integer sumDigits(Integer number) {
        int sum = 0;
        String numberFormat = Integer.toString(number);

        for (var i = 0; i < numberFormat.length(); i++) {
            char numberChar = numberFormat.charAt(i);
            sum += Character.getNumericValue(numberChar);
        }
        System.out.println("Сумма цифр = " + sum);
        return sum;
    }


    /*public static Integer sumDigits(Integer number) {
        String textNumber = number.toString();
        int endSum = 0;
        for (int i = 0; i < textNumber.length(); i++) {
            char text = textNumber.charAt(i);
            endSum += Integer.parseInt(String.valueOf(text));
        }
        System.out.println("Сумма цифр = " + endSum);
        return number;
    }*/
}
