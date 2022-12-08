package labb1.View;

import javax.swing.*;

import labb1.Model.CarsModel;

import java.awt.*;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller
 * in it's state.
 * It communicates with the Controller by calling methods of it when an action
 * fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame implements Observer {

    // to controller

    private static final int X = GraphicsDependencies.getX();
    private static final int Y = GraphicsDependencies.getY();
    //
    CarsModel model;
    DrawPanel drawPanel;

    // Constructor
    public CarView(String framename, CarsModel model) {
        this.model = model;
        this.drawPanel = new DrawPanel(model, X, Y - 240);
        initComponents(framename);
    }

    @Override
    public void update() {
        drawPanel.update();

    }

    public Dimension getPreferredButtonSize() {
        return new Dimension(X / 5 - 15, 200);
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        // Make the frame pack all it's components by respecting the sizes if possible.
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // TODO change these statics to getters
        this.setLocation(dim.width / 2 - this.X / 2, dim.height / 2 - this.Y / 2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(drawPanel);
    }
}