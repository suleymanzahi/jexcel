package gui.menu;

import gui.CurrentLabel;
import gui.CurrentSlotLabel;
import gui.StatusLabel;
import model.Sheet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JMenuItem;

class ClearMenuItem extends JMenuItem implements ActionListener {

    private Sheet sheet;
    private CurrentLabel cl;
    private StatusLabel sl;

    public ClearMenuItem(Sheet sheet, CurrentLabel cl, StatusLabel sl) {
        super("Clear");
        addActionListener(this);
        this.sheet=sheet;
        this.cl = cl;
        this.sl = sl;
    }

    public void actionPerformed(ActionEvent e) {
        // TODO

        try {
            sheet.clearSlot(cl.getText());
        } catch (Exception exception) {
            sl.setText("Can not clear this slot.");
        }

    }
}
