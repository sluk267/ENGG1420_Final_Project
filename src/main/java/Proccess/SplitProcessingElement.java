/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Proccess;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;
import java.io.IOException;

/**
 * This class defines a file splitting operation that can take an ArrayList of input file names and
 * a maximum number of lines per output file, and split each input file into parts of the specified
 * length, writing the resulting parts to separate output files.
 */
public class SplitProcessingElement {

    // Declare instance variables to hold the input file names and the maximum number of lines per output file
    private ArrayList<String> inputList; 
    private int lines;
            
    // Constructor to initialize the instance variables
    public SplitProcessingElement(ArrayList<String> inputList, int lines){
        this.inputList = inputList;
        this.lines = lines;
    }
    
    /**
     * This method takes the input file names and maximum number of lines per output file specified
     * in the constructor, and splits each input file into parts of the specified length, writing
     * the resulting parts to separate output files.
     * @return An ArrayList of Strings representing the names of the output files created.
     * @throws IOException if an I/O error occurs.
     */
    public ArrayList<String> FileSeparater() throws IOException{
        ArrayList<String> outputFiles = new ArrayList<String>();
        
        // Loop through each input file specified in the inputList
        for (String file : inputList) {
            
            // Create a new File object to represent the input file, and a BufferedReader to read from it
            File inputFile = new File(file);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            
            // Initialize some variables to keep track of the current line number and output file part number
            String line;
            int lineNumber = 1;
            int partNumber = 1;
            
            // Create a new BufferedWriter object to write to the first output file part
            BufferedWriter writer = new BufferedWriter(new FileWriter(getPartFileName(inputFile, partNumber)));

            // Loop through each line of the input file and write it to the current output file part
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();

                // If the current output file part has reached the maximum number of lines, close it
                // and start writing to a new output file part with the next part number
                if (lineNumber == lines) {
                    writer.close();
                    outputFiles.add(getPartFileName(inputFile, partNumber));
                    partNumber++;
                    writer = new BufferedWriter(new FileWriter(getPartFileName(inputFile, partNumber)));
                    lineNumber = 0;
                }

                lineNumber++;
            }

            // Close the final output file part and the BufferedReader
            writer.close();
            reader.close();
            
            // If the final output file part has any content, add it to the list of output files
            if (lineNumber > 1) { // Only add file if it has content
                outputFiles.add(getPartFileName(inputFile, partNumber));
            }
        }
        
        // Return the list of output files
        return outputFiles;        
    }
    
    
    /**
     * This is a private helper method that takes an input file and a part number, and returns
     * the name of the output file for that part.
     * @param inputFile The input file being split.
     * @param partNumber The part number of the output file.
     * @return A String representing the name of the output file.
     */
    private static String getPartFileName(File inputFile, int partNumber) {
        // Get the name of the input file without and with its extension
        String fileNameWithoutExtension = inputFile.getName().substring(0, inputFile.getName().lastIndexOf('.'));
        String fileExtension = inputFile.getName().substring(inputFile.getName().lastIndexOf('.'));
        return fileNameWithoutExtension + "part" + partNumber + fileExtension;
    }
    
}