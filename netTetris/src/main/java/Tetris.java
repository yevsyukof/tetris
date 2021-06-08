import controller.Controller;
import model.Model;
import view.GameConstants;
import view.View;

import javax.swing.*;

public class Tetris implements Runnable {

    private static Tetris instance;

    private static Controller controller;
    private static View gui;
    private static Model model;
    private static Timer timer;

    private Tetris() {
        model = new Model();
        controller = new Controller(model);
        gui = new View(model, controller);
    }

    public static Tetris getInstance() {
        if (instance == null) {
            instance = new Tetris();
        }
        return instance;
    }

    @Override
    public void run() {
        model.addObserver(gui);

        javax.swing.SwingUtilities.invokeLater(gui);

        model.initNewModel();
        timer = new Timer(GameConstants.TIMER_DELAY, e -> controller.handleTimerRequest());
        timer.start();
    }
}
