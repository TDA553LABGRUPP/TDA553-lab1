package labb1;

import java.awt.*;

//*Abstract class for any truck. Truck must have a max load . */
public abstract class Truck{
    private int maxLoad;
    private Boolean platformExtended;
    private Vehicle vehicle;
    public Truck(Color color, double enginePower, String modelName, double  x, double y, double dirX, double dirY, int maxLoad){

        this.vehicle = new Vehicle(2, color, enginePower, modelName,   x,  y, dirX,  dirY, speedFactor());
        this.maxLoad = maxLoad;
        this.platformExtended = false;

    }

    // Returns max load var
    public int getMaxLoad(){
        return maxLoad;
    }

    public Boolean isPlatformExtended(){
        return platformExtended;
    }

    public void gas(double amount){
        if (isPlatformExtended()){
            throw new IllegalArgumentException("He your plattfroms extended");
        }else{
            vehicle.gas(amount);
        }
        
        }
    

    // Part of the class contract. SUbclass must implement speedFactor
    public abstract double speedFactor();
}
