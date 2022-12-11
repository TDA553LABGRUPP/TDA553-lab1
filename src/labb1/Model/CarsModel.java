package labb1.Model;

import java.util.ArrayList;
import java.util.List;

import labb1.View.GraphicsDependencies;
import labb1.View.Observer;

/**
 * This is the big model class that helps initialize all the car and helps to run all the different model methos calls for all the vehicles.
 * 
 * The model also keeps time and notifies the observers
 */
public class CarsModel {
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    ArrayList<Car> cars;
    ArrayList<Truck> trucks;
    List<Observer> observers = new ArrayList<Observer>();

    public CarsModel(ArrayList<Truck> trucks, ArrayList<Car> cars) {
        this.trucks = trucks;
        this.cars = cars;
        this.vehicles.addAll(cars);
        this.vehicles.addAll(trucks);
    }

    public void start() {
       
        while (true) {

            update();

            //TODO make this into a separate method
            try {
                Thread.sleep(GraphicsDependencies.getFrameTime());
            } catch (InterruptedException e) {
                System.out.println("Clock Interrupted");
                System.out.println(e);
            }
        }
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void update() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getCurrentSpeedX() > 0 || vehicle.getCurrentSpeedY() > 0){
                vehicle.move();
                notifyObservers();
            }
        }
      
    }

    public ArrayList<Vehicle> getVehicles() {
        //Defensive copying
        ArrayList<Vehicle> copy = new ArrayList<Vehicle>(this.vehicles);

        return copy;
    }

    // Calls the gas method for each car once
    public void gas(double amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : vehicles) {
            car.gas(gas);
        }
    }

    public void brake(double amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : vehicles) {
            car.brake(gas);
        }
    }


    public void stopEngine() {
        for (Vehicle car : vehicles) {
            car.stopEngine();
        }
    }

    public void startEngine() {
        for (Vehicle car : vehicles) {
            car.startEngine();
        }
    }


    public void turnOnTurbo(){
        for (Vehicle car : vehicles){
            try{
                car.setTurboOn();
            }catch (IllegalArgumentException e){
                System.out.println(e);
            }
        }
    }

    public void turnOffTurbo(){
        for (Vehicle car : vehicles){
            try{
                car.setTurboOff();
            }catch (IllegalArgumentException e){
                System.out.println(e);
            }
        }
    }

    public void lowerBed(){
        for (Truck truck : trucks){
            truck.extendPlatform();
        }
    }

    public void raiseBed(){
        for (Truck truck : trucks){
            truck.retractPlatform();
        }
    }

    //TODO make more method listeners from the controller

}

