package labb1.Model;

/**
 * Class of the type CarRepairShop. Can unload and unload a car. Uses
 * composition and delegation for Loadable.
 */
public class CarRepairShop {
    private Loadable loadable; // Declaration of the Loadable type
    private String name;

    /**
     * Constructor of the CarRepairShop. Initializing a new Loadable object
     * 
     * @param x            is the x coordinate of CarRepairShop
     * @param y            is the y coordinate of
     * @param max_capacity is the max capacity that the CarRepairShop, how many cars
     *                     the shop can take in
     * @param name         is the name of CarRepairShop
     */
    public CarRepairShop(double x, double y, int max_capacity, String name) {
        this.loadable = new Loadable(max_capacity, x, y);
        this.name = name;
    }

    /**
     * Load a car using a method load() in Loadable through delegation. Load only if
     * car is in proximity and the amount of cars that is loaded is less than max
     * capacity.
     * 
     * @param car of type Car
     */
    public void load(Car car) {
        loadable.load(car);
    }


    /**
     * Unload car if the CarRepairShop has it loaded.
     * 
     * @param car of type Car
     * @return car of type Car
     */
    public Movable unload(Car car) {
        return loadable.unload(car);
    }

    /**
     * 
     * @return the name of the CarRepairShop
     */
    public String getName() {
        return name;
    }
}
