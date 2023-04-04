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
import java.util.List;

public abstract class Print extends ProcessingElement {
    private String name;
    private List<Entry> input;

    public Print(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setInput(List<Entry> input) {
        this.input = input;
    }

    public List<Entry> getOutput() {
        return null;
    }

    public void print() {
        System.out.println("Printing files in " + name);
        for (Entry entry : input) {
            if (entry.isFile()) {
                File file = new File(entry.getPath());
                System.out.println(file.getName() + " (" + file.length() + " bytes)");
            }
        }
    }
}

