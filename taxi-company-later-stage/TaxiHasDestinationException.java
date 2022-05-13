public class TaxiHasDestinationException extends RuntimeException{
    private final Vehicle vehicle;

    public TaxiHasDestinationException(Vehicle vehicle){
        super(vehicle.toString() + " already has a target destination, but has been scheduled for another pickup");
        this.vehicle = vehicle;
    }

}
