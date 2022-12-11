package labb1;

import java.awt.*;

/**
 * Class for Scania
 */
public class Scania extends Truck {
    // private Dumper trailer; // the trailer that is to be attached to the truck
    /**
     * Constructor for Scania
     * 
     * @param color is the color of the truck
     * @param x     is the x coordinate of the truck
     * @param y     is the y coordinate of the truck
     * @param dirX  is the direction x of the truck
     * @param dirY  is sthe direction y of the truck
     */
    public Scania(Color color, double x, double y, double dirX, double dirY, Trailer trailer) {
        super(color, 770, "Scania", x, y, dirX, dirY, 300, trailer);
        // Attaching the trailer
        // this.trailer = = new Dumper(300, 0, 70, speedFactor(), x, y);

    }// Constructor

    /**
     * The speed factor of Scania. Depends on engine power of Scania
     */
    @Override
    public double speedFactor() {
        return enginePower * 0.01;
    }// speedFactor()

    // /**
    //  * Loads Scanias trailer with a Movable item
    //  * 
    //  * @param thing as a Movable
    //  */
    // public void load(Movable thing) {
    //     trailer.load(thing);
    // }

}// Class
