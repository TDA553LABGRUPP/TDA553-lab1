import javax.swing.*;
import java.awt.*;

import labb1.Car;
import labb1.Saab95;
import labb1.Scania;
import labb1.Truck;
import labb1.Vehicle;
import labb1.Volvo240;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

//this does a bit too much for a controller
public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the
    // statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();
    ArrayList<Saab95> turbocars = new ArrayList<>();
    ArrayList<Truck> trucks = new ArrayList<>();

    // methods:

    // Shoudld be in separate method
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Volvo240 volvo = new Volvo240(Color.red, 0, 50, 0, 1);
        Saab95 saab = new Saab95(Color.red, 100, 50, 0, 1);
        Scania scania = new Scania(Color.green, 200, 50, 0, 1);

        // Maybs make an add thing in the class that adds and storts the different cars
        // into different arrays for different purposes????
        cc.cars.add(volvo);

        cc.cars.add(saab);
        cc.turbocars.add(saab);

        cc.cars.add(scania);
        cc.trucks.add(scania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /*
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                // This shouldnt be here
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    void stopEngine() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
    }

    void startEngine() {
        for (Vehicle car : cars) {
            car.startEngine();
        }
    }

    // really ugly and doesnt follow open closed principle. Remake?? Might need
    // refactoring or maybe not
    void turnOnTurbo() {
        int i = 0;
        for (Saab95 car : turbocars) {
            car.setTurboOn();
        }
    }

    // this ones really ugly too
    void turnOffTurbo() {
        int i = 0;
        for (Saab95 car : turbocars) {
            car.setTurboOff();
        }
    }

    void lowerBed() {
        for (Truck truck : trucks) {
            truck.extendPlatform();
        }
    }

    void raiseBed() {
        for (Truck truck : trucks) {
            truck.retractPlatform();
        }
    }

}
