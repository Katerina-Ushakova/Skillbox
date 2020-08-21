import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        double [] temp = new double[30];
        double average = 0;
        int count = 0;
        final double MIN_TEMP = 36.2;
        final double MAX_TEMP = 36.9;

        //Создание массива с температурами
        for (int i = 0; i < temp.length; i++ ) {
            double value =  Math.random() * 8 + 32;
            //double newValue = new BigDecimal(value).setScale(1, RoundingMode.UP).doubleValue();
            temp[i] = value;
            System.out.printf("%.02f; ", value);
            //количество здоровых пациентов
            if (value >= MIN_TEMP && value <= MAX_TEMP) {
                count++;
            }
        }
        //средняя температура по больнице
        if (temp.length > 0) {
            double sum = 0;
            for (int j = 0; j < temp.length; j++) {
                sum += temp[j];
            }
            average = sum / temp.length;
        }
        //double newAverage = new BigDecimal(average).setScale(1, RoundingMode.UP).doubleValue();
        System.out.printf("\n" + "Серняя температура = %.02f ", average);

        System.out.println("\n" + "Кол-во здоровых пациентов = " + count);
    }
}
