package nsu.fit.yevsyukof.view;


import javax.swing.*;
import java.awt.*;

public class CellsField extends JPanel {

    private Cell[][] cellsField;

    public CellsField() {
        initCells();
    }

    private void initCells() {
        this.setSize(GameConstants.CELLS_FIELD_WIDTH * GameConstants.CELL_SIZE,
                GameConstants.CELLS_FIELD_HEIGHT * GameConstants.CELL_SIZE);
        // установлили размер панели
        this.setLayout(new GridLayout(
                GameConstants.CELLS_FIELD_HEIGHT, GameConstants.CELLS_FIELD_WIDTH, 1, 1));
        // задали концепцию добавления элементов на эту панель - таблица из ячеек c отступами 1 и 1

        cellsField = new Cell[GameConstants.CELLS_FIELD_HEIGHT][GameConstants.CELLS_FIELD_WIDTH];
        for (int x = 0; x < GameConstants.CELLS_FIELD_HEIGHT; ++x) {
            for (int y = 0; y < GameConstants.CELLS_FIELD_WIDTH; ++y) {
                cellsField[x][y] = new Cell(x, y);
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
}
