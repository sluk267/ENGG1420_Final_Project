/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess_TEST;

import java.io.File;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Paul's Laptop
 */
public abstract class Entry {
    
    private String name;
    private String path;


    public Entry(String name, String path) {
        this.name = name;
        this.path = path;
    }
    
    

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }
    
    public String getType() {
        return "Entry";
    }

    public boolean isFile() {
        File f = new File(path);
        return f.isFile();
    }

    public boolean isDirectory() {
        File f = new File(path);
        return f.isDirectory();
    }

    public long getLength() {
        File f = new File(path);
        return f.length();
    }

    public void addEntry(Entry entry) {
        // Do nothing since this method is only applicable to ListPE
    }

    public List<Entry> getInputEntries() {
        return Collections.emptyList();
    }

    public List<parameter> getParameters() {
        return Collections.emptyList();
    }
}
