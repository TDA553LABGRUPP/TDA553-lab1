package labb1;

import java.awt.*;

//Class for scanias
public class Scania extends Truck {

    public Scania(Color color, double x, double y, double dirX, double dirY) {
        super(color, 770, "Scania", x, y, dirX, dirY, new Dumper(300, 0, 70, 1, 1), 300, 0, 70);
    }// Constructor

    @Override
    public double speedFactor() {
        return enginePower * 0.01;
    }// speedFactor()

}// Class
