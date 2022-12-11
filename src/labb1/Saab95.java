package labb1;

import java.awt.*;

/**
 * A class for type Saab95. Has its own speed factor. Extends Car.
 */
public class Saab95 extends Car {

    // Turbo specific to the saab 95
    public boolean turboOn;

    /**
     * Constructor of Saab95
     * 
     * @param color is the color of the object
     * @param x     is the x coordinate of the object
     * @param y     is the y coordinate of the object
     * @param dirX  is the direction x of the object
     * @param dirY  is the direction y of the object
     */
    public Saab95(Color color, double x, double y, double dirX, double dirY) {
        super(2, color, 125, "Saab95", x, y, dirX, dirY);
        turboOn = false;
    }// Constructor

    /**
     * Copy constructor. Makes a saab out of any input vehicle
     * 
     * @param other the other vehicle to be copied and made into a saab.
     */
    public Saab95(Vehicle other) {
        super(2, other.getColor(), 125, "Saab95", other.getX(), other.getY(), other.getDirectionX(),
                other.getDirectionY());
        turboOn = false;
    }

    /**
     * Sets the boolean turboOn to true
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Sets the boolean turboOn to false
     */
    public void setTurboOff() {
        turboOn = false;
    }// setTurboOff()

    /**
     * The speed factor of Saab95. Used when gasing. Gets an increased speed factor
     * if the turbo is on
     * 
     * @return the speed factor based on the engine power and turbo
     */
    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn)
            turbo = 1.9;
        return enginePower * 0.01 * turbo;
    }// speedFactor()

}// Class
