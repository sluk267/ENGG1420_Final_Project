/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paul_Testing;

/**
 *
 * @author Paul's Laptop
 */
import java.util.List;

public class List extends ProcessingElement {
    private List<Entry> entries;

    public List(List<Entry> entries) {
        this.entries = entries;
    }

    public List<Entry> process_input() {
        return entries;
    }

    @Override
    public void processInput(Entry input) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void processOutput(Entry output) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
