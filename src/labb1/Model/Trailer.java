package labb1.Model;

/**
 * Abstract superclass for Trailer
 */
public abstract class Trailer implements Positionable{
    private int maxLoad;
    private boolean platformExtended;
    private double x;
    private double y;

    /**
     * Constructor for Trailer
     * 
     * @param maxLoad the max load that can be loaded on the trailer
     *   @param x the x coordinate of the trailer
     * @param y the y coordinate of the trailer
     */
    public Trailer(int maxLoad,double x, double y) {
        this.maxLoad = maxLoad;
        this.x = x;
        this.y = y;

    }

    @Override
    public double getX(){
        return x;
    }
    @Override
    public double getY(){
        return y;
    }


    public void linkPosition(double x, double y){
        this.x = x;
        this.y= y;
    }
    /**
     * @return true if the platform is extended
     */
    public boolean getPlatformExtended() {
        return platformExtended;
    }

    /**
     * Sets platformExtended to true
     */
    public void setPlatformExtended() {
        this.platformExtended = true;
    }

    /**
     * Sets platformExtended to false
     */
    public void setPlatformRetracted() {
        this.platformExtended = false;
    }

    /**
     * 
     * @return the max load
     */
    public int getMaxLoad() {
        return maxLoad;
    }

        /**
     * Load the platform with a movable object
     * 
     * @param a thing of type Movable
     */
    public abstract void load(Movable thing);
    

    public abstract Movable unload(Movable item);
    /**
     * Non abstract subclasses need to implement this
     */
    public abstract void extendPlatform();

    /**
     * Non abstract subclasses need to implement this
     */
    public abstract void retractPlatform();

}
