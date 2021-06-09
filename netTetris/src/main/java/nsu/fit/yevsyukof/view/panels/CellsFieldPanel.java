package nsu.fit.yevsyukof.view.panels;


import nsu.fit.yevsyukof.model.Model;
import nsu.fit.yevsyukof.model.ModelStates;
import nsu.fit.yevsyukof.utils.Observer;
import nsu.fit.yevsyukof.view.GameConstants;

import javax.swing.*;
import java.awt.*;

public class CellsFieldPanel extends JPanel implements Observer {

    private final CellPanel[][] cellsField;

    private final Model model;

    public CellsFieldPanel(Model model) {
        super(new GridLayout(
                GameConstants.CELLS_FIELD_HEIGHT, GameConstants.CELLS_FIELD_WIDTH, 1, 1));
        // задали концепцию добавления элементов на эту панель - таблица из ячеек c отступами 1 и 1

        this.model = model;

        this.setSize(GameConstants.CELLS_FIELD_WIDTH * GameConstants.CELL_SIZE,
                GameConstants.CELLS_FIELD_HEIGHT * GameConstants.CELL_SIZE);
        // установлили размер панели

        cellsField = new CellPanel[GameConstants.CELLS_FIELD_HEIGHT][GameConstants.CELLS_FIELD_WIDTH];
        addCellsPanelsAtFieldPanel();
    }

    private void addCellsPanelsAtFieldPanel() {
        for (int x = 0; x < GameConstants.CELLS_FIELD_HEIGHT; ++x) {
            for (int y = 0; y < GameConstants.CELLS_FIELD_WIDTH; ++y) {
                cellsField[x][y] = new CellPanel();
                this.add(cellsField[x][y]);
            }
        }
    }

    private Color interpretColor(int colorCode) {
        switch (colorCode) {
            case GameConstants.I_CODE -> {return Color.cyan;}
            case GameConstants.J_CODE -> {return Color.blue;}
            case GameConstants.L_CODE -> {return Color.orange;}
            case GameConstants.O_CODE -> {return Color.yellow;}
            case GameConstants.S_CODE -> {return Color.green;}
            case GameConstants.T_CODE -> {return Color.magenta;}
            case GameConstants.Z_CODE -> {return Color.red;}
            default -> {return GameConstants.EMPTY_CELL_COLOR;}
        }
    }

    public void updateCellsField(int[][] gameField) {
        for (int x = 4; x < GameConstants.GAME_FIELD_HEIGHT; ++x) {
            for (int y = 0; y < GameConstants.GAME_FIELD_WIDTH; ++y) {
                cellsField[x - 4][y].setBackground(interpretColor(gameField[x][y]));
            }
        }
    }

    @Override
    public void handleEvent(ModelStates curModelState) {
        switch (curModelState) {
            case IN_PROCESS, END -> updateCellsField(model.getGameField());
            case PAUSE -> { } // невозможный случай
        }
    }
}
