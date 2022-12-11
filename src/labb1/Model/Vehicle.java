package labb1.Model;

import java.awt.*;

// To-Do
// Add turning radius, a variable that change how fast the car turns

//Vehicle  superclass for all vehicles

/**
 * Abstract superclass for all vehicles. Vehicles should have a position
 * and be able to move.
 */
public abstract class Vehicle implements Movable {
    private int nrDoors; // Amount of doors
    private Color color; // Color of the vehicle
    protected double enginePower; // Vehicles engine power used to calculate speed
    private String modelName; // THe name of the vehicle
    private double currentSpeedX; // Current speed for moving
    private double currentSpeedY;// --||--
    private double x; // x coordinate
    private double y; // y coordinate
    private double[] direction; // x and y list for the direction that the car is supposed to move in
    private boolean engineStarted = false; // Whether the vehicle is started or not

    /**
     * Constructor of Vehicle
     * 
     * @param nrDoors     the amount of doors on the vehicle
     * @param color       the color of the vehicle
     * @param enginePower the engine power of the vehicle
     * @param modelName   the model name of the vehicle
     * @param x           position x
     * @param y           position y
     * @param dirX        direction in the x-axis
     * @param dirY        direction in the y-axis
     */

    public Vehicle(int nrDoors, Color color, double enginePower, String modelName, double x, double y, double dirX,
            double dirY) {// TODO: Set x and y as 0 in the beginning this.x = 0, this.y=0 and remove from
                          // parameters? Maybe do the same with dirx and diry?
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        this.direction = new double[] { dirX, dirY };
        stopEngine();
    }// Constructor

    public double getDirectionX() {
        return direction[0];
    }

    public double getDirectionY() {
        return direction[1];
    }

    /**
     * 
     * @return the number of doors on the vehicle
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * 
     * @return the engine power of the vehicle
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * 
     * @return the speed in the x-axis
     */
    public double getCurrentSpeedX() {
        return currentSpeedX;
    }

    /**
     * 
     * @return the speed in the y-axis
     */
    public double getCurrentSpeedY() {
        return currentSpeedY;
    }

    /**
     * Get the x coordinate of the vehicle
     * 
     * @return x coordinate
     */
    @Override
    public double getX() {
        return x;
    }

    /**
     * Get the y coordinate of the vehicle
     * 
     * @return y cooridnate
     */
    @Override
    public double getY() {
        return y;
    }

    /**
     * @return the color of the vehicle
     */
    public Color getColor() {
        return color;
    }

    /**
     * 
     * @return the model name of the vehicle
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Set the color of the vehicle
     * 
     * @param clr is the RGB color to add to the vehicle
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * Used when testing
     * 
     * @param speed
     */
    private void setCurrentSpeedX(double speed) {
        this.currentSpeedX = speed;
    }

    /**
     * Used when testing
     * 
     * @param speed
     */
    private void setCurrentSpeedY(double speed) {
        this.currentSpeedY = speed;
    }

    /**
     * Starts the engine of the vehicle and increasing the speed
     */
    public void startEngine() {
        engineStarted = true;
    }

    /**
     * Stops the engine of the vehicle by setting the speed to 0
     */
    public void stopEngine() {
        this.currentSpeedX = 0;
        this.currentSpeedY = 0;
        engineStarted = false;
    }

    /**
     * Moves the car in the x or y direction based on the speed in their axis
     */
    @Override
    public void move() {
        if (engineStarted){
            x += currentSpeedX;
            y += currentSpeedY;
        }
        
    }

    /**
     * Turns the vehicle to the left by decreasing the x vector
     */
    
    public void turnLeft() {
        System.out.println("turning: " + this);
        decreaseDirectionX(0.1);
    }

    /**
     * Turns the vehicle to the right by increasing the x vector
     */

    public void turnRight() {
        increaseDirectionX(0.1);

    }

    /**
     * Increase the x direction vector. The vector will be between [-1, 1]
     * 
     * @param amount is a positive double
     */
    // increases variabe x direction vector
    private void increaseDirectionX(double amount) {
        double increment = this.direction[0] + amount;
        if (Helpers.inBounds(1.0, -1.0, increment) == 0) {
            this.direction[0] = increment;
        }
    } // increaseDirectionX()

    /**
     * Decrease the x direction vector. The vector will be between [-1, 1]
     * 
     * @param amount is a positive double
     */
    private void decreaseDirectionX(double amount) {
        double increment = this.direction[0] - amount;
        if (Helpers.inBounds(1.0, -1.0, increment) == 0) {
            this.direction[0] = increment;
        }
    }// decreaseDirectionX()

    /**
     * The gas method will increment the speed
     * 
     * @param amount is a positive double that should be between [0, 1]
     */
    public void gas(double amount) {
        if (Helpers.inBounds(1.0, 0.0, amount) == 0) {
            incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Amount needs to be between 0 and 1");
        }
    } // gas()

    /**
     * The brake method will decrement the speed
     * 
     * @param amount is a positive double that should be between [0, 1]
     */
    public void brake(double amount) {
        if (Helpers.inBounds(1.0, 0.0, amount) == 0) {
            decrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("amount needs to be between 0 and 1");
        }
    }// brake()

    /**
     * Calculate the speed based on if the speed to change is in the correct bounds
     * and sets the speed accordingly
     * 
     * @param speedToChange is the current speed +/- speedFactor() * amount
     * @return the parameter speedToChange, will be [0, enginePower]
     */
    private double calculateSpeed(double speedToChange) {
        if (Helpers.inBounds(enginePower, 0.0, speedToChange) == -1) {
            speedToChange = 0;
        } else if (Helpers.inBounds(enginePower, 0, speedToChange) == 1) {
            speedToChange = enginePower;
        }
        return speedToChange;
    }// calculateSpeed()

    /**
     * Increments the speed in both the x and y direction (if dir != 0), but will
     * always be between [0, enginePower]
     * 
     * @param amount is a postive double
     */
    private void incrementSpeed(double amount) {
        currentSpeedX = calculateSpeed(getCurrentSpeedX() + speedFactor() * amount) * this.direction[0];
        currentSpeedY = calculateSpeed(getCurrentSpeedY() + speedFactor() * amount) * this.direction[1];
    }// incrementSpeed()

    /**
     * Decrements the speed in both the x and y direction (if dir != 0), but it will
     * always be between [0, enginePower]
     * 
     * @param amount is a postive double
     */
    private void decrementSpeed(double amount) {
        currentSpeedX = calculateSpeed(getCurrentSpeedX() - speedFactor() * amount) * this.direction[0];
        currentSpeedY = calculateSpeed(getCurrentSpeedY() - speedFactor() * amount) * this.direction[1];
    }// decrementSpeed()

    /**
     * Abstract method that the non-abstract subclasses should implement
     * 
     * @return the speed factor which the movement depends on
     */
    public abstract double speedFactor();

    public abstract void setTurboOn();

    public abstract void setTurboOff();
}// Class
