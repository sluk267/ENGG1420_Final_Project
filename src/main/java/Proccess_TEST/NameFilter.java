/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess_TEST;

/**
 *
 * @author Paul's Laptop
 
import java.util.List;
import java.util.stream.Collectors;

public class NameFilter {
    public static List<String> filterNamesByLength(List<String> names, int length) {
        return names.stream()
                    .filter(name -> name.length() >= length)
                    .collect(Collectors.toList());
    }
}
*/

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class NameFilter extends ProcessingElement {
    private List<Entry> inputEntries;
    private List<Entry> outputEntries;

    public NameFilter() {
        this.inputEntries = new ArrayList<>();
        this.outputEntries = new ArrayList<>();
    }

    public void addEntry(Entry entry) {
        this.inputEntries.add(entry);
    }

    public List<String> filterNamesByLength(int length) {
        List<String> filteredNames = new ArrayList<>();

        for (Entry entry : inputEntries) {
            if (entry.isFile() && entry.getName().length() >= length) {
                filteredNames.add(entry.getName());
                outputEntries.add(entry);
            }
        }

        return filteredNames;
    }
    
    public List<Entry> proccess(List<Entry> inputEntries, List<Parameter> parameters) {
    // Get the value of the "Name" parameter
    String nameValue = null;
    for (Parameter parameter : parameters) {
        if (parameter.getName().equals("Name")) {
            nameValue = parameter.getValue();
            break;
        }
    }
    // If the "Name" parameter is not found, return an empty list
    if (nameValue == null) {
        return Collections.emptyList();
    }
    // Filter the input entries by name
    List<Entry> filteredEntries = new ArrayList<>();
    for (Entry entry : inputEntries) {
        if (entry.getName().equals(nameValue)) {
            filteredEntries.add(entry);
        }
    }
    return filteredEntries;
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
        return "NameFilter";
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
