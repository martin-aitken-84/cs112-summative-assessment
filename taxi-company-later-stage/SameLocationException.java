public class SameLocationException extends RuntimeException{
    private Location destination;
    private Location pickup;

    public SameLocationException(Location destination, Location pickup){
        super("Pickup destination: " + pickup.toString() + "is the same as arrival destination: " + destination.toString());
        this.destination = destination;
        this.pickup = pickup;
    }

    public Location getDestination() {
        return destination;
    }


    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public Location getPickup() {
        return pickup;
    }

    public void setPickup(Location pickup) {
        this.pickup = pickup;
    }
}
