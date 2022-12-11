package labb1.Model;

/**
 * Class for all Helpers
 */
public class Helpers {
    /**
     * The inBounds method is used for checking if a certain amount is inbetween,
     * less than or greater than a given interval.
     * 
     * @param UpperLimit is the upper bound of the interval
     * @param LowerLimit is the lower bound of the interval
     * @param amount     is the double to see if it is inside the interval
     * @return result as an integer. 0 if [lowerLimit, upperLimit], -1 if <
     *         lowerLimit > and 1 if > upperLimit
     */
    public static int inBounds(double upperLimit, double lowerLimit, double amount) {
        int result = 0;
        if (amount > upperLimit) {
            return result + 1;
        } else if (amount < lowerLimit) {
            return result - 1;
        }
        return result;
    }// inBounds()
}
