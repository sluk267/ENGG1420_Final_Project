/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess_TEST;

/**
 *
 * @author Paul's Laptop
 */
import java.util.ArrayList;
import java.util.List;

public abstract class ListPE extends ProcessingElement {
    private List<Entry> entries = new ArrayList<>();
    private int max;

    public ListPE() {
        this.max = max;
    }

    @Override
    public List<Entry> getInputEntries() {
        return entries;
    }

    @Override
    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    public int getValue() {
        return max;
    }

    public List<Entry> process(List<Entry> entries) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
