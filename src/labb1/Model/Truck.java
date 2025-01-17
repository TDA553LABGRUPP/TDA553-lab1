package labb1.Model;

import java.awt.*;

/**
 * Abstract class of any Truck. Extends Vehicle. Truck must have a max load
 */
public abstract class Truck extends Vehicle {
    private Trailer trailer;

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
            int maxLoad, Trailer trailer) {
        super(2, color, enginePower, modelName, x, y, dirX, dirY);
        this.trailer = trailer;
    }// Constructor

    /**
     * Gas method for an Truck. Will only move if the platform is not extended
     * 
     * @param amount as a double
     */
    @Override
    public void gas(double amount) {
        if (trailer.getPlatformExtended()) {
            throw new IllegalArgumentException("Can not move while platform is extended");
        } else {
            super.gas(amount);
        }

    }// gas()

    /**
     * Extends platform is the speed is 0
     */
    public void extendPlatform() {
        if (this.getCurrentSpeedX() > 0 || this.getCurrentSpeedY() > 0) {
            throw new IllegalArgumentException("Cant open platform while driving");
        } else {
            trailer.extendPlatform();
        }

    }


    //Functions fo loading the truck uses loadable
    public void load(Movable movable) {
        if (trailer.getPlatformExtended()) {
            trailer.load(movable);
        } else {
            throw new IllegalStateException("Platform is not extended cant load object");
        }
    }

    public Movable unload(Movable movable) {
        if (trailer.getPlatformExtended()) {
            return trailer.unload(movable);
        } else {
            throw new IllegalStateException("Platform is not extended cant unload object");
        }
    }

    /**
     * Retracts the platform
     */
    public void retractPlatform() {
        trailer.retractPlatform();
    }// getTrailer()

    @Override
    public void move(){
        super.move();
        trailer.linkPosition(getX(),getY());
    }

    /**
     * Part of the class contract. SUbclass must implement speedFactor
     */
    @Override
    public abstract double speedFactor();
}
