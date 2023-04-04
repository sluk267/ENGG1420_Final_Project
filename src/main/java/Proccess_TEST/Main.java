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
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.lang.reflect.Parameter;
import java.util.Scanner;


/**
public class Main {

    public static void main(String[] args) throws IOException {

        // Get the JSON file location from the command line arguments
        if (args.length == 0) {
            System.err.println("No JSON file location provided.");
            return;
        }
        String jsonFileLocation = args[0];

        // Load the JSON file and parse it into a scenario object
        ObjectMapper objectMapper = new ObjectMapper();
        scenario Scenario = objectMapper.readValue(new File(jsonFileLocation), scenario.class);
        // Iterate over the processing elements in the scenario and execute them
        List<Entry> currentInputEntries = new ArrayList<>();
        for (ProcessingElement processingElement : Scenario.getProcessingElements()) {
            switch (processingElement.getType()) {
                case "List":
                    ListPE listPE = new ListPE() {};
                    for (Entry inputEntry : processingElement.getInputEntries()) {
                        if (inputEntry.getType().equals("local")) {
                            listPE.addEntry((Entry) Paths.get(inputEntry.getPath()));
                        }
                    }
                    for (Parameter parameter : processingElement.getParameters()) {
                        if (parameter.getName().equals("Max")) {
                            listPE.setMax(Integer.parseInt(parameter.getValue()));
                        }
                    }
                    currentInputEntries = listPE.process(currentInputEntries);
                    break;
                case "NameFilter":
                    NameFilter nameFilter = new NameFilter();
                    for (Entry inputEntry : currentInputEntries) {
                        if (inputEntry.isFile()) {
                            nameFilter.addEntry(inputEntry);
                        }
                    }
                    for (Parameter parameter : processingElement.getParameters()) {
                        if (parameter.getName().equals("Pattern")) {
                            nameFilter.setPattern(parameter.getValue());
                        }
                    }
                    currentInputEntries = nameFilter.process(currentInputEntries);
                    break;
                case "LengthFilter":
                    LengthFilter lengthFilter = new LengthFilter() {};
                    for (Entry inputEntry : currentInputEntries) {
                        if (inputEntry.isFile()) {
                            lengthFilter.addEntry(inputEntry);
                        }
                    }
                    for (Parameter parameter : processingElement.getParameters()) {
                        if (parameter.getName().equals("Length")) {
                            lengthFilter.setLength(Long.parseLong(parameter.getValue()));
                        } else if (parameter.getName().equals("Operator")) {
                            lengthFilter.setOperator(parameter.getValue());
                        }
                    }
                    currentInputEntries = lengthFilter.process(currentInputEntries);
                    break;
                case "Print":
                    Print print = new Print();
                    for (Entry inputEntry : currentInputEntries) {
                        print.addEntry(inputEntry);
                    }
                    print.process(currentInputEntries);
                    break;
                default:
                    System.err.println("Invalid processing element type: " + processingElement.getType());
                    return;
            }
        }
    }
}*/

public class Main {

    public static void main(String[] args) throws IOException {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the JSON file: ");
        String fileName = scanner.nextLine();

        // Load the JSON file and parse it into a scenario object
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File(fileName);
        if (!jsonFile.exists()) {
            System.err.println("The specified file does not exist.");
            return;
        }
        scenario Scenario = objectMapper.readValue(jsonFile, scenario.class);

        // Iterate over the processing elements in the scenario and execute them
        List<Entry> currentInputEntries = new ArrayList<>();
        for (ProcessingElement processingElement : Scenario.getProcessingElements()) {
            switch (processingElement.getType()) {
                case "List":
                    ListPE listPE = new ListPE() {};
                    for (Entry inputEntry : processingElement.getInputEntries()) {
                        if (inputEntry.getType().equals("local")) {
                            listPE.addEntry((Entry) Paths.get(inputEntry.getPath()));
                        }
                    }
                    for (Parameter parameter : processingElement.getParameters()) {
                        if (parameter.getName().equals("Max")) {
                            listPE.setMax(Integer.parseInt(parameter.getValue()));
                        }
                    }
                    currentInputEntries = listPE.process(currentInputEntries);
                    break;
                case "NameFilter":
                    NameFilter nameFilter = new NameFilter();
                    for (Entry inputEntry : currentInputEntries) {
                        if (inputEntry.isFile()) {
                            nameFilter.addEntry(inputEntry);
                        }
                    }
                    for (Parameter parameter : processingElement.getParameters()) {
                        if (parameter.getName().equals("Pattern")) {
                            nameFilter.setPattern(parameter.getValue());
                        }
                    }
                    currentInputEntries = nameFilter.process(currentInputEntries);
                    break;
                case "LengthFilter":
                    LengthFilter lengthFilter = new LengthFilter() {};
                    for (Entry inputEntry : currentInputEntries) {
                        if (inputEntry.isFile()) {
                            lengthFilter.addEntry(inputEntry);
                        }
                    }
                    for (Parameter parameter : processingElement.getParameters()) {
                        if (parameter.getName().equals("Length")) {
                            lengthFilter.setLength(Long.parseLong(parameter.getValue()));
                        } else if (parameter.getName().equals("Operator")) {
                            lengthFilter.setOperator(parameter.getValue());
                        }
                    }
                    currentInputEntries = lengthFilter.process(currentInputEntries);
                    break;
                case "Print":
                    Print print = new Print();
                    for (Entry inputEntry : currentInputEntries) {
                        print.addEntry(inputEntry);
                    }
                    print.process(currentInputEntries);
                    break;
                default:
                    System.err.println("Invalid processing element type: " + processingElement.getType());
                    return;
            }
        }
    }
}
