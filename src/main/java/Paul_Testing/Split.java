/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paul_Testing;

/**
 *
 * @author Paul's Laptop
 */
import java.io.*;
import java.util.*;

  public class Split extends ProcessingElement {

    @Override
    public List<Entry> process_input(Entry input) throws IOException {
        List<Entry> output = new ArrayList<Entry>();
        
        BufferedReader reader = new BufferedReader(new FileReader(input.getPath()));
        String line;
        int count = 1;
        
        while ((line = reader.readLine()) != null) {
            String filename = input.getPath() + "_" + count;
            File splitFile = new File(filename);
            FileWriter writer = new FileWriter(splitFile);
            writer.write(line);
            writer.close();
            
            LocalEntry splitEntry = new LocalEntry(filename, true);
            output.add(splitEntry);
            
            count++;
        }
        
        reader.close();
        return output;
    }

    @Override
    public void process_output(Entry output, InputStream data) throws IOException {
        throw new UnsupportedOperationException("Split does not support process_output method");
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
