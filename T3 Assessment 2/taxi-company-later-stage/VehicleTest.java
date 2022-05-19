import org.junit.jupiter.api.BeforeEach;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    Simulation simulation = new Simulation();
    private Vehicle taxi1;
    private TaxiCompany company;
    private Passenger passenger;
    Location location = new Location(0, 0);
    Location pickupLocation = new Location(0, 10);
    Location destinationLocation = new Location(10, 10);
    List<Vehicle> vehicles;

    @BeforeEach
    void setUp() {
        City city = new City();
        company = new TaxiCompany(city);
        passenger = new Passenger(pickupLocation, destinationLocation);
        vehicles = company.getVehicles();
        taxi1 = vehicles.get(0);
        taxi1.setLocation(location);
    }



    @org.junit.jupiter.api.Test
    void getPickupCount() {
        assertEquals(0, taxi1.getPickupCount());
        taxi1.setTargetLocation(pickupLocation);
        simulation.step();
        simulation.step();
        simulation.step();
        simulation.step();
        simulation.step();
        assertEquals(5, taxi1.getPickupCount());
    }

    @org.junit.jupiter.api.Test
    void getDestinationCount() {

        assertEquals(0, taxi1.getDestinationCount());
        taxi1.setLocation(location);
        taxi1.pickup(passenger);
        simulation.step();
        simulation.step();
        simulation.step();
        simulation.step();
        simulation.step();
        assertEquals(5, taxi1.getDestinationCount());
    }


    @org.junit.jupiter.api.Test
    void incrementPickupCount() {
        assertEquals(0,taxi1.getPickupCount());
        taxi1.incrementPickupCount();
        assertEquals(1,taxi1.getPickupCount());
    }

    @org.junit.jupiter.api.Test
    void incrementDestinationCount() {
        assertEquals(0,taxi1.getDestinationCount());
        taxi1.incrementDestinationCount();
        assertEquals(1,taxi1.getDestinationCount());
    }
}