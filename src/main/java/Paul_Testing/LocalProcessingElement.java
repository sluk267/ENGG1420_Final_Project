/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paul_Testing;

/**
 *
 * @author Paul's Laptop
 */
public class LocalProcessingElement extends ProcessingElement {
    private LocalEntry input;
    private LocalEntry output;

    @Override
    public void process_input(Entry entry) {
        if (entry instanceof LocalEntry) {
            LocalEntry localEntry = (LocalEntry) entry;
            // process local input file
            // e.g. read file contents into a string
            String contents = readFile(localEntry.getPath());
            input = localEntry;
            input.setContents(contents);
        } else {
            throw new IllegalArgumentException("Entry must be a LocalEntry");
        }
    }

    @Override
    public void process_output(Entry entry) {
        if (entry instanceof LocalEntry) {
            LocalEntry localEntry = (LocalEntry) entry;
            // process local output file
            // e.g. write string contents to file
            writeFile(localEntry.getPath(), output.getContents());
            output = localEntry;
        } else {
            throw new IllegalArgumentException("Entry must be a LocalEntry");
        }
    }

    // helper methods for reading and writing files
    private String readFile(String path) {
        // implementation details
        return "";
    }

    private void writeFile(String path, String contents) {
        // implementation details
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
