import com.skillbox.airport.Airport;

public class Main {
    public static void main (String[] args)
    {
        Airport airport = Airport.getInstance();
        airport.getTerminals();
        int aircraftAmount = airport.getAllAircrafts().size(); //записываем значение длины списка в отдельную переменную
        System.out.println("Количество самолетов =" + aircraftAmount);
    }
}
