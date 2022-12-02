package labb1;

public class Dumper extends Trailer {
    private int platformAngle;
    private final int MIN_EXTENSION_ANGLE;
    private final int MAX_EXTENSOIN_ANGLE;
    private Double platformSpeed;
    private Loadable loadable;

    public Dumper(int maxLoad, int MIN_EXTENSION_ANGLE, int MAX_EXTENSOIN_ANGLE, double platformSpeed, double x,
            double y) {
        super(maxLoad);
        this.MIN_EXTENSION_ANGLE = MIN_EXTENSION_ANGLE;
        this.MAX_EXTENSOIN_ANGLE = MAX_EXTENSOIN_ANGLE;
        this.platformSpeed = 1.0;
        this.loadable = new Loadable(maxLoad, x, y);
    }

    // Specific method for raising the platsform of the truck
    // Increases platsform angle if its not at the max angle
    @Override
    public void extendPlatform() {
        platformAngle += platformSpeed;
        if (this.platformAngle >= MAX_EXTENSOIN_ANGLE) {
            this.platformAngle = MAX_EXTENSOIN_ANGLE;
        }

        super.setPlatformExtended();

    }

    // Specific method for lowering platsform
    // Decreases thje platsform angle if itn not at the min angle of zero
    @Override
    public void retractPlatform() {
        platformAngle -= platformSpeed;
        if (this.platformAngle <= MIN_EXTENSION_ANGLE) {
            this.platformAngle = MIN_EXTENSION_ANGLE;
        }

        super.setPlatformRetracted();

    }

    public void load(Movable thing) {
        loadable.load(thing);
    }

    public Movable unload() {
        return loadable.unload(null);
    }

    public int getPlatformAngle() {
        return platformAngle;
    }
}
