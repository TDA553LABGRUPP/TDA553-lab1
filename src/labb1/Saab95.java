package labb1;

import java.awt.*;

public class Saab95 extends Car{

    public boolean turboOn;
    
    public Saab95(Color color,double x, double y, double dirX, double dirY){
        super(2, color, 125, "Saab95", x, y, dirX, dirY);
	    turboOn = false;  
    }
    
    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }
    
}
