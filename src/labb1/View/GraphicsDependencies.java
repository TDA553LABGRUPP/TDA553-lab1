package labb1.View;


/**
 * This class are to store and set dependencies for graphics and frame rates and such
 */
public class GraphicsDependencies {
    private static final int X = 800;
    private static final int Y = 800;
    private static final int frameRate = 60;
    private static final int frameTime = calculateMilisFromFrameRate(frameRate);

    public static int getX() {
        return X;
    }

    public static int getY() {
        return Y;
    }

    public static int getFrameTime(){
        return frameTime;
    }

    private static int calculateMilisFromFrameRate(int frameRate) {
        double millisDouble = 1000 / frameRate;
        int millisInt = (int) millisDouble;
        return millisInt;
    }

}
