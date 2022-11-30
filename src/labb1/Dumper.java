package labb1;

public class Dumper extends Trailer {
    private int platformAngle;
    private final int MIN_EXTENSION_ANGLE;
    private final int MAX_EXTENSOIN_ANGLE;
    private Boolean platformStopped;
    Loadable loadable;

    public Dumper(int maxLoad, int MIN_EXTENSION_ANGLE, int MAX_EXTENSOIN_ANGLE, double x, double y) {
        super(maxLoad, x, y);
        this.MIN_EXTENSION_ANGLE = MIN_EXTENSION_ANGLE;
        this.MAX_EXTENSOIN_ANGLE = MAX_EXTENSOIN_ANGLE;
        this.platformStopped = false;
        loadable = new Loadable(maxLoad, x, y);
    }

    // Specific method for raising the platsform of the truck
    // Increases platsform angle if its not at the max angle
    @Override
    public void extendPlatform() {

        if (this.platformAngle >= MAX_EXTENSOIN_ANGLE) {
            this.platformAngle = MAX_EXTENSOIN_ANGLE;
        }
        while (platformAngle < MAX_EXTENSOIN_ANGLE && !platformStopped) {
            this.platformAngle++;

            // temp
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

        }

        super.setPlatformExtended();
        this.platformStopped = false;

    }

    // Specific method for lowering platsform
    // Decreases thje platsform angle if itn not at the min angle of zero
    @Override
    public void retractPlatform() {
        if (this.platformAngle <= MIN_EXTENSION_ANGLE) {
            this.platformAngle = MIN_EXTENSION_ANGLE;
        }

        while (platformAngle < MAX_EXTENSOIN_ANGLE && !platformStopped) {
            this.platformAngle--;
            // temp
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }

        super.setPlatformRetracted();
        this.platformStopped = false;
    }

    public void stopPlatform() {
        this.platformStopped = true;
    }
}
