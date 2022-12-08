package labb1;

import java.awt.*;

/**
 * Class for CarTransporters. Extends Truck. CarTransporter has a Flatbed so it
 * composition and delegation on Flatbed to get that classes functionality.
 */
public class CarTransporter extends Truck {

    private Flatbed trailer; // Decleration of a Flatbed object, trailer.

    /**
     * Constructor of CarTransporter.
     * 
     * @param color       is the color of the CarTransporter
     * @param x           is the x coordinate of the CarTransporter
     * @param y           is the y coordinate of the CarTransporter
     * @param dirX        is the x direction of the CarTransporter
     * @param dirY        is the y direction of the CarTransporter
     * @param maxNrOfCars is the number of cars tha the CarTransporter can store on
     *                    its flatbed
     */
    public CarTransporter(Color color, double x, double y, double dirX, double dirY, int maxNrOfCars) {

        super(color, 500, "Ford", x, y, dirX, dirY, 100);

        this.trailer = new Flatbed(100, maxNrOfCars, x, y); // Initializing a new Flatbed object to use for delegation
    }

    /**
     * Get the trailer of the CarTransporter
     */
    @Override
    public Flatbed getTrailer() {
        return trailer;
    }

    /**
     * The speed factor for CarTransporter. Depends only on engine power.
     * 
     * @return the speed factor
     */
    @Override
    public double speedFactor() {
        return enginePower * 0.01;
    }

    /**
     * Load the flatbed with a car through delegation of Flatbed, which in turn uses
     * delegation on Loadable.
     * 
     * @param car of type Car
     */
    public void load(Car car) {
        trailer.load(car);
    }

    /**
     * Unload the flatbed through delegation of Flatbed, which in turn uses
     * delegation on Loadable.
     * 
     * @return a car that has been loaded.
     */
    public Movable unload() {
        return trailer.unload();
    }

}// Class