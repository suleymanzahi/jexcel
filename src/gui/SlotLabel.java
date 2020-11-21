package gui;

import java.awt.Color;

public class SlotLabel extends ColoredLabel {

    private String address;

    public SlotLabel(String address) {
        super("                    ", Color.WHITE, LEFT);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

}
