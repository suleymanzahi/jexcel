package gui;

import model.Sheet;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

public class SheetPanel extends BorderPanel {

    public SheetPanel(int rows, int columns, CurrentLabel cl, Sheet sheet, Editor editor, StatusLabel sl) {
        add(WEST, new RowLabels(rows));
        add(CENTER, new SlotLabels(rows, columns, cl, sheet, editor, sl));
    }
}
