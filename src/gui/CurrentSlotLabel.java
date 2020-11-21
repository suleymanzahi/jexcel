package gui;

import java.awt.*;

public class CurrentSlotLabel {

    private SlotLabel label;

    public CurrentSlotLabel(SlotLabel label) {
        this.label = label;
        label.setBackground(Color.YELLOW);
    }

    public void setLabel(SlotLabel label) {
        this.label = label;
        label.setBackground(Color.YELLOW);
    }

    public void repaint() {
        label.setBackground(Color.WHITE);
    }

}
