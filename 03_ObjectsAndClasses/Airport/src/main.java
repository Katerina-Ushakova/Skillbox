import com.skillbox.airport.Airport;

public class Main {
    public static void main (String[] args)
    {
        Airport airport = Airport.getInstance();
        airport.getTerminals();
        airport.getAllAircrafts();
        System.out.println(airport.getAllAircrafts());

    }
}
