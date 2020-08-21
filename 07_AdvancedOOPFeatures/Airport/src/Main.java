import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        airport.getAllAircrafts();
        airport.getTerminals()
                .forEach(flight -> flight.getFlights().stream()
                .filter(f -> f.getDate().getTime() - System.currentTimeMillis() <=7200000)
                .filter(f -> f.getDate().getTime() - System.currentTimeMillis() > 0)
                .filter(f -> f.getType() == Flight.Type.ARRIVAL)
                .forEach(System.out::println));
    }
}
