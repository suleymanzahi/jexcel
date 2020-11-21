package gui;

import model.Sheet;
import util.XLException;

import java.awt.Color;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextField;

public class Editor extends JTextField implements Observer {

    private Sheet sheet;
    private CurrentLabel currentLabel;
    private StatusLabel statusLabel;

    public Editor(Sheet sheet, CurrentLabel currentLabel, StatusLabel sl) {
        sheet.addObserver(this);
        this.sheet = sheet;
        this.currentLabel = currentLabel;
        this.statusLabel = sl;
        setBackground(Color.WHITE);
        addActionListener(e -> {
                if (!getText().isEmpty()) {
                    try {
                        sheet.add(currentLabel.getText(),getText());

                    } catch (XLException | IOException | NullPointerException ex) {
                        //ex.printStackTrace();
                        sl.setText("Expression not allowed.");

                        //sheet.clear();
                    }
                }
        });


    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
