import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Run the simulation by asking a collection of actors to act.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class Simulation
{
    private final List<Actor> actors;
    private TaxiCompany company;
    private PassengerSource source;
    private int step;

    /**
     * Create the initial set of actors for the simulation.
     */
    public Simulation()
    {
        actors = new LinkedList<>();
        step = 0;
        City city = new City();
        this.company = new TaxiCompany(city);
        this.source = new PassengerSource(city, company);
        
        actors.addAll(company.getVehicles());
        actors.add(source);
        actors.add(new CityGUI(city));
    }
    
    /**
     * Run the simulation for a fixed number of steps.
     * Pause after each step to allow the GUI to keep up.
     */
    public void run(int steps)
    {
        for(int i = 0; i < steps; i++){
            step++;
            step();
        }
        System.out.println("Taxis: " + company.getVehicles().size());
        System.out.println();
        System.out.println("Missed Passengers: " + source.missedPickups());
        System.out.println("Average Idle: " + company.averageIdle());
        System.out.println("Total Idle: " + company.sumIdle());
    }

    /**
     * Take a single step of the simulation.
     */
    public void step()
    {
        for(Actor actor : actors) {
            actor.act();
        }
    }
    
    /**
     * Wait for a specified number of milliseconds before finishing.
     * This provides an easy way to cause a small delay.
     * @param milliseconds The number of milliseconds to wait.
     */
    private void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } 
        catch (InterruptedException e)
        {
            // ignore the exception
        }
    }
}
