package nsu.fit.yevsyukof.view.panels;

import nsu.fit.yevsyukof.view.GameConstants;

import javax.swing.*;

public class CellPanel extends JPanel {

    public CellPanel() {
        this.setSize(GameConstants.CELL_SIZE, GameConstants.CELL_SIZE);
        this.setBackground(GameConstants.EMPTY_CELL_COLOR);
    }
}
