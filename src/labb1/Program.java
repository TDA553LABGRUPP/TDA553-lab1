package labb1;

import labb1.Controller.CarController;
import labb1.Model.Car;
import labb1.Model.CarsModel;
import labb1.Model.Saab95;
import labb1.Model.Scania;
import labb1.Model.Truck;
import labb1.Model.Volvo240;
import labb1.View.CarView;

import java.awt.*;
import java.util.ArrayList;



 /**
  * This is the application file that starts up the application
  */
public class Program {
    public static void main(String[] args) {

        ArrayList<Car> cars = new ArrayList<Car>();
        ArrayList<Truck> trucks = new ArrayList<Truck>();

        // TODO Make factory?
        Volvo240 volvo = new Volvo240(Color.red, 0, 50, 0, 1);
        Saab95 saab = new Saab95(Color.red, 100, 50, 0, 1);
        Scania scania = new Scania(Color.green, 200, 50, 0, 1);

        cars.add(volvo);
        cars.add(saab);
        trucks.add(scania);

        CarsModel model = new CarsModel(trucks, cars);
        CarView frame = new CarView("carView", model);
        CarController cc = new CarController(model, frame);

        model.addObserver(frame);
        model.start();
    }
}
