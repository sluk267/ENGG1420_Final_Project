/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess;

import java.util.ArrayList;

/**
 *
 * @author Paul's Laptop
 */
public class ContentFilter extends Filter {
    private String key;

    public ContentFilter(String type, String key) {
        super(type);
        this.key = key;
    }

    public ArrayList<Object> applyFilter(ArrayList<Object> entries) {
        ArrayList<Object> filteredEntries = new ArrayList<>();
        for (Object entry : entries) {
            if (entry.getContent().contains(key)) {
                filteredEntries.add(entry);
            }
        }
        return filteredEntries;
    }
}
