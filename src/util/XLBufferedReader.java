package util;

import model.Sheet;
import model.Slot;
import model.SlotFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

// TODO move to another package
public class XLBufferedReader extends BufferedReader {



    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    // TODO Change Object to something appropriate
    public void load(Map<String, String> map) {
        try {
            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=');
                String addr = string.substring(0,i);
                String slot = string.substring(i+1);
                map.put(addr,slot);
                // TODO
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}
