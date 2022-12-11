package labb1.Model;

/**
 * Class for Dumper. Extends Trailer. Composition and delegation on Loadable.
 */
public class Dumper extends Trailer {
    private int platformAngle;
    private final int MIN_EXTENSION_ANGLE = 0;
    private final int MAX_EXTENSOIN_ANGLE;
    private Double platformSpeed;
    private Loadable loadable; // Decleration of Loadable object


    /**
     * Constructor of Dumper
     * 
     * @param maxLoad             is the max load of what the dumper can load
     * @param MAX_EXTENSION_ANGLE is the maximum angle that the dumper can extend to
     * @param platformSpeed       is the speed which the platform extends or
     *                            retracts
     * @param x                   the x coordinate of the dumper
     * @param y                   the y coordinate of the dumper
     */
    public Dumper(int maxLoad, int MAX_EXTENSION_ANGLE, double platformSpeed, double x,
            double y) {
        super(maxLoad ,x , y);

        this.MAX_EXTENSOIN_ANGLE = MAX_EXTENSION_ANGLE;
        this.platformSpeed = platformSpeed;
        this.loadable = new Loadable(maxLoad, x, y); // Initializing a new Loadable object
    }

    /**
     * Extends the platform of the truck. Increases platsform angle if its not at
     * the max angle
     */
    @Override
    public void extendPlatform() {
        platformAngle += platformSpeed;
        if (this.platformAngle >= MAX_EXTENSOIN_ANGLE) {
            this.platformAngle = MAX_EXTENSOIN_ANGLE;
        }

        super.setPlatformExtended();

    }

    /**
     * Lowering the platform of the truck. Decreases the platoform angle if its not
     * at the min angle of 0
     */
    @Override
    public void retractPlatform() {
        platformAngle -= platformSpeed;
        if (this.platformAngle <= MIN_EXTENSION_ANGLE) {
            this.platformAngle = MIN_EXTENSION_ANGLE;
        }

        super.setPlatformRetracted();

    }

    /**
     * Load the platform with a movable object
     * 
     * @param a thing of type Movable
     */
    public void load(Movable thing) {
        loadable.load(thing);
    }

    /**
     * Unload the platform
     * 
     * @return item of type Movable
     */
    public Movable unload(Movable item) {
        return loadable.unload(item);
    }

    /**
     * Get the angle of the platform
     * 
     * @return the angle as an int
     */
    public int getPlatformAngle() {
        return platformAngle;
    }
}
