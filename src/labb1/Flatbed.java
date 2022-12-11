package labb1;

/**
 * Class for Flatbed. Extends trailer. Composition and delegation on Loadable.
 */
public class Flatbed extends Trailer {
    private final int MAX_NUMBER_OF_CARS;
    private Loadable loadable; // Decleration of Loadable object

    /**
     * Constructor of Flatbed
     * 
     * @param maxLoad            is the max load of the trailer
     * @param MAX_NUMBER_OF_CARS is max number of cars that the platform can load
     * @param x                  is the x coordinate of the flatbed
     * @param y                  is the y coordinate of the flatbed
     */
    public Flatbed(int maxLoad, int MAX_NUMBER_OF_CARS, double x, double y) {
        super(maxLoad);
        this.MAX_NUMBER_OF_CARS = MAX_NUMBER_OF_CARS;
        this.loadable = new Loadable(MAX_NUMBER_OF_CARS, x, y); // Initializing a new Loadable object
    }

    /**
     * Raises the platform of the truck. Puts the platform down so cars can get onto
     * the flatbed
     */
    @Override
    public void extendPlatform() {
        super.setPlatformExtended();

    }

    /**
     * Lowers the platform of the truck. Puts the platform up so that the truck can
     * move
     */
    @Override
    public void retractPlatform() {
        if (super.getPlatformExtended()) {
            super.setPlatformRetracted();
        } else {
            throw new IllegalArgumentException("Platform is already up");
        }
    }

    /**
     * Load the truck with a car
     * 
     * @param car as type Car
     */
    public void load(Movable car) {
        if (car instanceof Car){
            loadable.load(car);
        }else{
            throw new IllegalArgumentException("Input needs to be a car");
        }       
    }

    /**
     * Unload the truck
     * 
     * @return a movable
     */
    public Movable unload(Movable item) {
        return loadable.unload(item);
    }
}
