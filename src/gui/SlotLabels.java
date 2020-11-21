package gui;

import model.Sheet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.*;

public class SlotLabels extends GridPanel implements Observer {

    private List<SlotLabel> labelList;
    private CurrentSlotLabel currentSlotLabel;
    private Sheet sheet;
    private Editor editor;
    private StatusLabel sl;

    public SlotLabels(int rows, int cols, CurrentLabel currentLabel, Sheet sheet, Editor editor, StatusLabel sl) {
        super(rows + 1, cols);
        this.sheet = sheet;
        this.editor = editor;
        this.sl = sl;

        sheet.addObserver(this);
        labelList = new ArrayList<SlotLabel>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY, SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
                String address = String.valueOf(ch) + row;
                SlotLabel label = new SlotLabel(address);
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        SlotLabel s = (SlotLabel) e.getSource();
                        currentSlotLabel.repaint();
                        currentSlotLabel.setLabel(s);
                        currentLabel.setText(s.getAddress());
                        editor.setText("");
                        sl.setText("");
                        editor.setText(sheet.getEditorString(s.getAddress()));
                    }
                });
                add(label);
                labelList.add(label);
            }
        }
        currentSlotLabel = new CurrentSlotLabel(labelList.get(0));
    }


    @Override
    public void update(Observable o, Object arg) {
        Set<Map.Entry<String, String>> set = sheet.stringEntries();
        System.out.println(set);
        labelList.forEach(e -> e.setText("                    "));
        for (Map.Entry<String, String> e : set) {
            for (SlotLabel sl : labelList) {
                if (sl.getAddress().equals(e.getKey())) {
                    sl.setText(e.getValue());
                }
            }

        }
    }
}

