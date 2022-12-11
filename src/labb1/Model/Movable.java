package labb1.Model;

/**
 * Superclass contract for any movable object
 */
public interface Movable extends Positionable {

    /**
     * Moves the object
     */
    void move();


    /**
     * Get the object's x value
     */
    @Override
    double getX();

    /**
     * Get the object's y value
     */
    @Override
    double getY();
}
