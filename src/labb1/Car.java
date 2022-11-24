package labb1;
import java.awt.*;

public abstract class Car {
    Vehicle vehicle;
    double speedFactor;
    public Car(int nrDoors, Color color, double enginePower, String modelName, double  x, double y, double dirX, double dirY){
       this.vehicle = new Vehicle(nrDoors, color, enginePower, modelName,   x,  y, dirX,  dirY, speedFactor());     
    }

    public abstract double speedFactor() ;


    //imported methods from delegation
    public double getEnginePower(){
        return vehicle.getEnginePower();
    }

    public void gas(double amount){
        vehicle.gas(amount);
    }


    public double getCurrentSpeedX(){
        return vehicle.getCurrentSpeedX();
    }

    public double getCurrentSpeedY(){
        return vehicle.getCurrentSpeedY();
    }

    public double getX(){
        return vehicle.getX();
    }

    public double getY(){
        return vehicle.getY();
    }

    public void move(){
        vehicle.move();
    }

    public void brake(double amount){
        
    }
    @Override
    public String toString(){
        String rgbPrint = vehicle.getColor().toString().substring(14);
        String printVehicle = "" + vehicle.getModelName()+ ": " + "Doors: " + vehicle.getNrDoors() + ", Color: " + rgbPrint + ", Engine power: " + vehicle.getEnginePower() + ", Position: (" + (int) vehicle.getX() + "," + (int) vehicle.getY() + ")";
        return printVehicle;
    } //Car object as a visible car object
}

