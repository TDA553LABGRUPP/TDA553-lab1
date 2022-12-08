package labb1;

import java.awt.*;

/**
 * Abstract class of any Truck. Extends Vehicle. Truck must have a max load
 */
public abstract class Truck extends Vehicle {

    /**
     * Constructor of Truck
     * 
     * @param color       is the color of the truck
     * @param enginePower is the engine power of the truck
     * @param modelName   is the model name of the truck
     * @param x           is the x coordinate of the truck
     * @param y           is the y coordinate of the truck
     * @param dirX        is the direction x of the truck
     * @param dirY        is the direction y of the truck
     * @param maxLoad     is the max load that the truck can take
     */
    public Truck(Color color, int enginePower, String modelName, double x, double y, double dirX, double dirY,
            int maxLoad) {
        super(2, color, enginePower, modelName, x, y, dirX, dirY);
    }// Constructor

    /**
     * Gas method for an Truck. Will only move if the platform is not extended
     * 
     * @param amount as a double
     */
    @Override
    public void gas(double amount) {
        if (this.getTrailer().getPlatformExtended()) {
            throw new IllegalArgumentException("Can not move while platform is extended");
        } else {
            super.gas(amount);
        }

    }// gas()

    /**
     * Extends platform is the speed is 0
     */
    public void extendPlatform() {
        if (this.getCurrentSpeedX() > 0 && this.getCurrentSpeedY() > 0) {
            throw new IllegalArgumentException("Cant open platform while driving");
        } else {
            this.getTrailer().extendPlatform();
        }

    }

    /**
     * Implemented by subclasses to get specific behavior inside different methods
     */
    public abstract Trailer getTrailer();

    /**
     * Retracts the platform
     */
    public void retractPlatform() {
        this.getTrailer().retractPlatform();
    }// getTrailer()

    /**
     * Part of the class contract. SUbclass must implement speedFactor
     */
    @Override
    public abstract double speedFactor();
}
