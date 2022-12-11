package labb1.Controller;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import labb1.Model.CarsModel;
import labb1.View.CarView;
import labb1.View.GraphicsDependencies;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state
 */

//this does a bit too much for a controller
public class CarController {

    private static final int X = GraphicsDependencies.getX();
    private static final int Y = GraphicsDependencies.getY();
    // The frame that represents this instance View of the MVC pattern

    private CarsModel model; // The big model file
    private CarView view; //The static view

    private JSpinner gasSpinner = new JSpinner(); //A spinner for number input
    private double gasAmount = 0; // TEMP Input value from spinner

    private JPanel controlPanel = new JPanel(); // A panel for packaging together controlls

    private JPanel gasPanel = new JPanel(); // A Panel for packagings the gas components
    private JLabel gasLabel = new JLabel("Amount of gas"); // Label above the gas spinner


    //Controll panel buttons
    private JButton gasButton = new JButton("Gas");
    private JButton brakeButton = new JButton("Brake");
    private JButton turboOnButton = new JButton("Saab Turbo on");
    private JButton turboOffButton = new JButton("Saab Turbo off");
    private JButton liftBedButton = new JButton("Scania Lift Bed");
    private JButton lowerBedButton = new JButton("Lower Lift Bed");

    //Big buttons
    private JButton startButton = new JButton("Start all cars");
    private JButton stopButton = new JButton("Stop all cars");

/**
 *  CarController
 * 
 * Init
 * 
 * @param model // The model
 * @param view // The view frame
 */
    public CarController(CarsModel model, CarView view) {
        this.model = model;
        this.view = view;
        initComponents();

    }//Constructor

    /**
     * initComponents
     * 
     * Initializing all the different controlling components
     */
    private void initComponents() {
        initGasPanel();
        initControlPanel();
        initStartButton();
        initStopButton();

        addListeners();
        view.pack();
    }

    /**
     * initSpinner
     * 
     * Initializing the spinner for controling gas amount
     */
    private void initSpinner() {
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, // initial value
                0, // min
                100, // max
                1);// step
        gasSpinner = new JSpinner(spinnerModel);
    }


    /**
     * initGasPanel
     * 
     * Initializing the gas panel and adding up its buttons
     */
    private void initGasPanel() {
        initSpinner();
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        view.add(gasPanel);
    }

    /**
     * initControlPanel
     * 
     * Initializing the control panel and adding the different buttons to it
     */
    private void initControlPanel() {
        controlPanel.setLayout(new GridLayout(2, 4));
        initPanelButtons();

        view.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);
    }

    /**
     * initPanelButtons
     * 
     * Initializing the buttons for the control panel
     */
    private void initPanelButtons() {
        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
    }

    /**
     * initStartButton
     * 
     * Initializing the start button that starts all the engines
     */
    private void initStartButton() {
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        view.add(startButton);
    }

    /**
     * initStopButton
     * 
     * Initializing the stop button that stops all the engines
     */
    private void initStopButton() {
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        view.add(stopButton);
    }

    /**
     * addListeners
     * 
     * Add the actions event listeners to all the different buttons and defines their method calls to the model
     */
    private void addListeners() {

        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });

        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gas(gasAmount);
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.brake(gasAmount);
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.stopEngine();
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.startEngine();

            }
        });

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.turnOnTurbo();
            }
        });
        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.turnOffTurbo();
            }
        });
        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.lowerBed();
            }

        });
        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.raiseBed();
            }
        });

    }

}

// --------------TODO add more of there method calls
