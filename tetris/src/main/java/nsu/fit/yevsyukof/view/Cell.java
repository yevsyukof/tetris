package nsu.fit.yevsyukof.view;

import javax.swing.*;

public class Cell extends JPanel {

    public Cell (int x, int y) {
        this.setSize(GameConstants.CELL_SIZE, GameConstants.CELL_SIZE);
        this.setBackground(GameConstants.EMPTY_CELL_COLOR);
    }
}
