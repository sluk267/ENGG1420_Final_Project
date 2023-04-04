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

public abstract class LengthFilter extends ProcessingElement {
    private List<Entry> inputEntries;
    private List<Entry> outputEntries;
    private long length;
    private String operator;

    public LengthFilter(long length, String operator) {
        this.inputEntries = new ArrayList<>();
        this.outputEntries = new ArrayList<>();
        this.length = length;
        this.operator = operator;
    }

    @Override
    public void addEntry(Entry entry) {
        inputEntries.add(entry);
    }

    @Override
    public List<Entry> getInputEntries() {
        return inputEntries;
    }

    public List<Entry> getOutputEntries() {
        return outputEntries;
    }

    @Override
    public String getType() {
        return "LengthFilter";
    }

    public long getLength() {
        return length;
    }

    public String getOperator() {
        return operator;
    }

    public void filterByLength() {
        for (Entry entry : inputEntries) {
            if (entry.isFile() && checkLength(entry.getLength())) {
                outputEntries.add(entry);
            }
        }
    }

    private boolean checkLength(long fileLength) {
        switch (operator) {
            case "EQ":
                return fileLength == length;
            case "NEQ":
                return fileLength != length;
            case "GT":
                return fileLength > length;
            case "GTE":
                return fileLength >= length;
            case "LT":
                return fileLength < length;
            case "LTE":
                return fileLength <= length;
            default:
                return false;
        }
    }
}

