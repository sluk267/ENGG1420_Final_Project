/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess_TEST;

/**
 *
 * @author Paul's Laptop
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LocalEntry extends Entry {
    private File file;

    public LocalEntry(String path) {
        super(path);
        this.file = new File(path);
    }

    @Override
    public boolean isDirectory() {
        return file.isDirectory();
    }

    public long getSize() {
        return file.length();
    }

    public List<Entry> getEntries(){
        List<Entry> entries = new ArrayList<>();
        if (isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File file : files) {
                    entries.add(new LocalEntry(file.getPath()) {
                        @Override
                        public long getLength() {
                            throw new UnsupportedOperationException("Not supported yet.");
                        }
                    });
                }
            }
        }
        return entries;
    }

    @Override
    public String getName() {
        return file.getName();
    }

    @Override
    public String toString() {
        return file.getPath();
    }
}

