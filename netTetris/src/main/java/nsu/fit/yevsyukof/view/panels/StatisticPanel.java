package nsu.fit.yevsyukof.view.panels;

import nsu.fit.yevsyukof.model.Model;
import nsu.fit.yevsyukof.model.ModelStates;
import nsu.fit.yevsyukof.utils.Observer;
import nsu.fit.yevsyukof.view.GameConstants;

import javax.swing.*;
import java.awt.*;

public class StatisticPanel extends JPanel implements Observer {

    private final JLabel scores;

    private final Model model;

    public StatisticPanel(Model model) {
        super(new FlowLayout(FlowLayout.CENTER));

        this.model = model;

        this.setPreferredSize(
                new Dimension(GameConstants.STATISTIC_PANEL_WIDTH, GameConstants.STATISTIC_PANEL_HEIGHT));

        scores = new JLabel("Scores: " + model.getScores());
        this.add(scores);
    }

    @Override
    public void handleEvent(ModelStates curModelState) {
        switch (curModelState) {
            case IN_PROCESS -> scores.setText("Scores: " + model.getScores());
            case END, PAUSE -> {} // невозможный случай
        }
    }
}
