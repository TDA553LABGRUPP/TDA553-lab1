package labb1.Model;

import java.awt.*;

/**
 * Class for CarTransporters. Extends Truck. CarTransporter has a Flatbed so it
 * composition and delegation on Flatbed to get that classes functionality.
 */
public class CarTransporter extends Truck {


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

        super(color, 500, "Ford", x, y, dirX, dirY, 100, new Flatbed(100, maxNrOfCars, x, y));

        // this.trailer = new Flatbed(100, maxNrOfCars, x, y); // Initializing a new Flatbed object to use for delegation
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

    //These are for if the car were to have a turbo ( yes trucks can have turbos)
    @Override
    public void setTurboOn() {
        throw new IllegalArgumentException("CarTransporter doesn't have a turbo");
    }

    @Override
    public void setTurboOff() {
        throw new IllegalArgumentException("CarTransporter doesn't have a turbo");
    }

}// Class