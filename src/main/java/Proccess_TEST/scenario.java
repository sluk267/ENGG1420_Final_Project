/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess_TEST;

/**
 *
 * @author Paul's Laptop
 */
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class scenario {
    private String name;
    private List<ProcessingElement> processing_elements;

    public String getName() {
        return name;
    }

    public List<ProcessingElement> getProcessingElements() {
        return processing_elements;
    }

    public static scenario fromJsonFile(String jsonFileLocation) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(jsonFileLocation), scenario.class);
    }

    public void execute() {
        for (ProcessingElement pe : processing_elements) {
            List<Entry> input_entries = pe.getInputEntries();
            for (Entry entry : input_entries) {
                if (entry.isFile()) {
                    pe.process(entry);
                }
            }
        }
    }
}
