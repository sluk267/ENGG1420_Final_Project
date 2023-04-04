/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess_TEST;

import java.lang.reflect.Parameter;

/**
 *
 * @author Paul's Laptop
 */
import java.util.List;

public abstract class ProcessingElement {
    private List<Entry> inputEntries;
    private List<Parameter> parameters;
    private String type;

    public List<Entry> getInputEntries() {
        return inputEntries;
    }

    public void setInputEntries(List<Entry> inputEntries) {
        this.inputEntries = inputEntries;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract void execute();

    public void addEntry(Entry entry) {
        inputEntries.add(entry);
    }

    void process(Entry entry) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}   

