package labb1.Model;

import java.awt.*;

/**
 * Superclass for all Cars. Extends Vehicle. A car has to fulfill the contract
 * of both a vehicle and movable
 * car adds a special print method for cars and adds to the polymorphism
 */
public abstract class Car extends Vehicle {

    /**
     * Constuctor of the Car class
     * 
     * @param nrDoors     the amount of doors of the car
     * @param color       the color of the car
     * @param enginePower the cars engine power
     * @param modelName   the cars model name
     * @param x           the x coordinate of the car
     * @param y           the y coordinate of the car
     * @param dirX        the x direction of the car
     * @param dirY        the y direction of the car
     */
    public Car(int nrDoors, Color color, int enginePower, String modelName, double x, double y, double dirX,
            double dirY) {
        super(nrDoors, color, enginePower, modelName, x, y, dirX, dirY);
    }// Constructor

    /**
     * Abstract method that the non-abstract subclasses should implement
     * 
     * @return the speed factor which the movement depends on
     */
    @Override
    public abstract double speedFactor();

    /**
     * Overrides toString() so that you can print a car object and see all its
     * parameters as a string
     * 
     * @return all the parameters of a car object
     */
    @Override
    public String toString() {
        String rgbPrint = this.getColor().toString().substring(14);
        String printVehicle = "" + this.getModelName() + ": " + "Doors: " + this.getNrDoors() + ", Color: " + rgbPrint
                + ", Engine power: " + this.getEnginePower() + ", Position: (" + (int) this.getX() + ","
                + (int) this.getY() + ")";
        return printVehicle;
    } // toString()
} // Class
