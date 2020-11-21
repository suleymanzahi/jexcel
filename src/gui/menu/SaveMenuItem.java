package gui.menu;

import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import gui.StatusLabel;
import gui.XL;
import model.Sheet;
import util.XLPrintStream;

class SaveMenuItem extends OpenMenuItem {

    private Sheet sheet;
    public SaveMenuItem(XL xl, StatusLabel statusLabel, Sheet sheet) {
        super(xl, statusLabel, "Save");
        this.sheet = sheet;

    }

    protected void action(String path) throws FileNotFoundException {
        // TODO
        XLPrintStream ps = new XLPrintStream(path);
        ps.save(sheet.entries());
        System.out.println("Reached");
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}
