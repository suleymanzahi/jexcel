package gui.menu;

import model.Sheet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

class ClearAllMenuItem extends JMenuItem implements ActionListener {

    private Sheet sheet;

    public ClearAllMenuItem(Sheet sheet) {
        super("Clear all");
        this.sheet = sheet;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // TODO
        sheet.clear();

    }
}
