package labb1;

/**
 * Abstract superclass for Trailer
 */
public abstract class Trailer {
    private int maxLoad;
    private boolean platformExtended;
    private int platformAngle;

    /**
     * Constructor for Trailer
     * 
     * @param maxLoad the max load that can be loaded on the trailer
     */
    public Trailer(int maxLoad) {
        this.maxLoad = maxLoad;

    }

    /**
     * @return true if the platform is extended
     */
    public Boolean getPlatformExtended() {
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
     * Non abstract subclasses need to implement this
     */
    public abstract void extendPlatform();

    /**
     * Non abstract subclasses need to implement this
     */
    public abstract void retractPlatform();

}
