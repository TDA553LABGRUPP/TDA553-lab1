package labb1.viewAndController;

import java.awt.*;

import javax.swing.*;

import labb1.Vehicle;

import java.util.ArrayList;

// This panel represent the animated part of the view with the car images.
//TODO reformatting

public class DrawPanel extends JPanel implements Observer {

    CarsModel model;
    AssetHandler handler = new AssetHandler();
    ArrayList<Point> points = new ArrayList<Point>();

    public DrawPanel(CarsModel model, int x, int y) {
        this.model = model;
        addImages();
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        update();
    }

    private void addImages() {
        for (Vehicle vehicle : model.getVehicles()) {

            handler.addNamedImageToDict(vehicle.getModelName());
            System.out.println("added" + vehicle.getModelName());
        }
    }

    @Override
    public void update() {
        redrawPoints();
        repaint();

    }

    public void refresh() {
        points = new ArrayList<Point>();
        handler.refresh();
    }

    private void bindImages(Vehicle vehicle, Point point) {
        handler.bindPointToNamedImage(vehicle.getModelName(), point);
    }

    private void redrawPoints() {
        refresh();
        for (Vehicle vehicle : model.getVehicles()) {

            int x = (int) Math.round(vehicle.getY());
            int y = (int) Math.round(vehicle.getX());
            Point point = new Point(x, y);
            points.add(point);
            bindImages(vehicle, point);
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself

    @Override
    protected void paintComponent(Graphics g) {
        int i = 0;
        super.paintComponent(g);
        for (Point pt : points) {
            g.drawImage(handler.getAssetFromPoint(pt), pt.x, pt.y, null);
        }
        // see javadoc for more info on the parameters
    }
}
