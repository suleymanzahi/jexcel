package gui.menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import javax.swing.JFileChooser;

import gui.StatusLabel;
import gui.XL;
import model.Sheet;
import util.XLBufferedReader;
import util.XLException;

class LoadMenuItem extends OpenMenuItem {
    private Sheet sheet;

    public LoadMenuItem(XL xl, StatusLabel statusLabel, Sheet sheet) {
        super(xl, statusLabel, "Load");
        this.sheet = sheet;
    }

    protected void action(String path) throws FileNotFoundException {
        // TODO
        sheet.clear();
        Map<String, String> map = new TreeMap<>();
        XLBufferedReader br = new XLBufferedReader(path);
        br.load(map);
        ArrayList<String> keys = new ArrayList<>(map.keySet());
        keys.sort((o1, o2) -> {
            int firstCharCompare = Character.compare(o1.charAt(0), o2.charAt(0));
            if (firstCharCompare != 0) {
                return firstCharCompare;
            }

            int num1 = Integer.parseInt(o1.substring(1));
            int num2 = Integer.parseInt(o2.substring(1));
            return Integer.compare(num1, num2);
        });
        keys.forEach(k -> {
            try {
                sheet.add(k,map.get(k));
            } catch (NullPointerException | XLException | IOException e) {
                //e.printStackTrace();
            }
        });
    }


    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}
