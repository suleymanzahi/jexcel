package model;

import expr.Environment;

import java.io.IOException;
import java.util.*;

public class Sheet extends Observable implements Environment {

    private Map<String, Slot> map;
    private SlotFactory sf;

    public Sheet() {
        map = new TreeMap<>();
        sf = new SlotFactory();
    }


    public boolean selfReference(String s1, String s2) {
        return s2.contains(s1.toLowerCase());
    }

    public boolean isCircular(String s2) {
        return (s2.length() == 2 && Character.isLetter(s2.charAt(0)) && !Character.isLetter(s2.charAt(1))) ||
                (s2.length() == 3 && Character.isLetter(s2.charAt(0)) && !Character.isLetter(s2.charAt(1)) && !Character.isLetter(s2.charAt(2)));
    }

    public void add(String address, String slot) throws IOException {
        Slot s;
        if (selfReference(address, slot) || isCircular(slot)) {
            Optional<Slot> slotValue = Optional.ofNullable(get(address));
            s = slotValue.orElseGet(() -> sf.slot());
        } else {
            s = sf.slot(slot, this);
        }
        map.put(address, s);
        setChanged();
        if (s instanceof SpecialSlot) {
            notifyObservers("Circular or self reference error detected.");
        }
        notifyObservers();

    }

    public Slot get(String s) {
        return map.get(s);
    }

    public String getEditorString(String address) {
        Optional<Slot> opt = Optional.ofNullable(get(address));
        if(opt.isPresent()) {
            return opt.get().editorString();
        } else {
            return "";
        }
    }

    public Set<Map.Entry<String, Slot>> entries() {
        return map.entrySet();
    }

    public Set<Map.Entry<String, String>> stringEntries() {
        Map<String, String> formattedMap = new TreeMap<>();
        for(Map.Entry<String, Slot> entry: map.entrySet()) {
            formattedMap.put(entry.getKey(),entry.getValue().toString());
        }
        return formattedMap.entrySet();

    }

    @Override
    public double value(String name) {
      return map.get(name).getValue();
    }

    public void clear() {
        map.clear();
        setChanged();
        notifyObservers();
    }

    public void clearSlot(String text) throws Exception {
        Slot storedSlot = map.get(text);
        map.remove(text);

        for (Map.Entry<String, Slot> entry : entries()) {
            try {
                Optional<String> attempt = Optional.ofNullable(entry.getValue().toString());
            } catch (Exception e) {
                map.put(text,storedSlot);
                throw new Exception();
            }
        }
        setChanged();
        notifyObservers();
    }
}

