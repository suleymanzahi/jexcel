package gui;

import model.Sheet;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class StatusLabel extends ColoredLabel implements Observer {

    public StatusLabel(Sheet sheet) {
        super("", Color.WHITE);
        sheet.addObserver(this);
    }

    public void update(Observable observable, Object object) {
        String s = (String) object;
        this.setText(s);
    }
}
