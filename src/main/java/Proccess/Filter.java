/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess;

/**
 *
 * @author Paul's Laptop
 */
import java.util.ArrayList;
import java.util.List;




public class Filter {
    private String type;
    private String[] parameters;
    private String title;
    private String content;
    
    public class Entry { //lines 23-42 needs to implemnted elsewhere
        private String title;
        private String content;

        // Constructor
        public Entry(String title, String content) {
            this.title = title;
            this.content = content;
        }

        // Getter for title
        public String getTitle() {
            return this.title;
        }

        // Getter for content
        public String getContent() {
            return this.content;
        }
    }
    
    public Filter(String type, String[] parameters) {
        this.type = type;
        this.parameters = parameters;
    }
    
    
    public ArrayList<Object> apply(ArrayList<Object> entries) {
        ArrayList<Object> filteredEntries = new ArrayList<>();
        for (Object entry : entries) {
            if (matchesFilter(entry)) {
                filteredEntries.add(entry);
            }
        }
        return filteredEntries;
    }
    
    private boolean matchesFilter(Object entry) {
        // Implementation of filter logic based on type and parameters
        // This method will vary based on the type of filter being used
        // For simplicity, this example assumes a filter based on the entry's title
        if (type.equals("title_contains")) {
            String title = entry.getTitle().toLowerCase();
            for (String parameter : parameters) {
                if (!title.contains(parameter.toLowerCase())) {
                    return false;
                }
            }
            return true;
        } else {
            // Handle other filter types
            return false;
        }
    }
    

}