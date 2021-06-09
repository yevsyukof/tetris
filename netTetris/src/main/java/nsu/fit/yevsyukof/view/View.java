package nsu.fit.yevsyukof.view;

import nsu.fit.yevsyukof.model.Model;
import nsu.fit.yevsyukof.model.ModelStates;
import nsu.fit.yevsyukof.utils.Observer;
import nsu.fit.yevsyukof.view.panels.CellsFieldPanel;
import nsu.fit.yevsyukof.view.panels.StatisticPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.EventListener;

public class View implements Observer, Runnable { // все манипуляции с отрисовкой будем производить через этот класс

    private final JFrame mainWindow;

    private final CellsFieldPanel cellsFieldPanel;

    private JMenuBar menuBar;

    private final StatisticPanel statisticPanel;


    public View(Model model, EventListener eventListener) {
        mainWindow = new JFrame("a.Tetris");
        mainWindow.setSize(GameConstants.MAIN_WINDOW_WIDTH, GameConstants.MAIN_WINDOW_HEIGHT);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null); // размещает главное окно в центре
        mainWindow.addKeyListener((KeyListener) eventListener);

        cellsFieldPanel = new CellsFieldPanel(model);
        statisticPanel = new StatisticPanel(model);

        createMenuBar(eventListener);
    }

    private void createMenuBar(EventListener eventListener) {
        menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(GameConstants.MENU_BAR_WIDTH, GameConstants.MENU_BAR_HEIGHT));

        JMenuItem exitButton = new JMenuItem("Exit");
        JMenuItem aboutButton = new JMenuItem("About");
        JMenuItem newGameButton = new JMenuItem("New Game");
        JMenuItem highScoresButton = new JMenuItem("High Scores");
        JMenuItem pauseButton = new JMenuItem("Pause");
        JMenuItem continueButton = new JMenuItem("Continue");

        exitButton.addActionListener((ActionListener) eventListener);
        aboutButton.addActionListener((ActionListener) eventListener);
        newGameButton.addActionListener((ActionListener) eventListener);
        highScoresButton.addActionListener((ActionListener) eventListener);
        pauseButton.addActionListener((ActionListener) eventListener);
        continueButton.addActionListener((ActionListener) eventListener);

        menuBar.add(exitButton);
        menuBar.add(aboutButton);
        menuBar.add(newGameButton);
        menuBar.add(highScoresButton);
        menuBar.add(pauseButton);
        menuBar.add(continueButton);
    }

    @Override
    public void handleEvent(ModelStates curModelState) { // TODO
        switch (curModelState) {
            case END -> JOptionPane.showMessageDialog(null, "End of game");
            case IN_PROCESS, PAUSE -> { }
        }
    }

    @Override
    public void run() {
        mainWindow.setJMenuBar(menuBar);
        mainWindow.add(cellsFieldPanel, BorderLayout.CENTER);
        mainWindow.add(statisticPanel, BorderLayout.EAST);

        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(statisticPanel.getPreferredSize());
        mainWindow.add(emptyPanel, BorderLayout.WEST);

        mainWindow.setResizable(false);
        mainWindow.setFocusable(true);
        mainWindow.setVisible(true);
    }

    public CellsFieldPanel getCellsFieldPanel() {
        return cellsFieldPanel;
    }

    public StatisticPanel getStatisticPanel() {
        return statisticPanel;
    }
}
