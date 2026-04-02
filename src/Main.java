import com.flightinfo.controller.FlightController;
import com.flightinfo.repository.FlightRepository;
import com.flightinfo.repository.InMemoryFlightRepository;
import com.flightinfo.service.FlightService;

public class Main {
    public static void main(String[] args) {
        FlightRepository repository = new InMemoryFlightRepository();
        FlightService flightService = new FlightService(repository);
        FlightController controller = new FlightController(flightService);

        controller.start();
    }
}
