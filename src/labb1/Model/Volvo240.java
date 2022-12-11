package labb1.Model;

import java.awt.*;

/**
 * A class for type Volvo240. Has its own speed factor. Extends Car.
 */
public class Volvo240 extends Car {

    public final static double trimFactor = 1.25; // The amount of trim made to the car

    /**
     * The constructor of Volvo240. Sets the amonut of doors, engine power and model
     * name.
     * 
     * @param color is the of color the object
     * @param x     is the x coordinate of the object
     * @param y     is the y coordinate of the object
     * @param dirX  is the x direction of the object
     * @param dirY  is the y direction of the object
     */
    public Volvo240(Color color, double x, double y, double dirX, double dirY) {
        super(4, color, 100, "Volvo240", x, y, dirX, dirY);
    }


    //Volvo could have a turbo if it wanted to
    @Override
    public void setTurboOn() {
        throw new IllegalArgumentException("Volvo240 doesn't have a turbo");
    }

    @Override
    public void setTurboOff() {
        throw new IllegalArgumentException("Volvo240 doesn't have a turbo");
    }


    /**
     * Speed factor of Volvo240. Used when gasing.
     * 
     * @return the speed factor as a double based on the engine power and trim
     *         factor
     */
    @Override
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
}// Class
