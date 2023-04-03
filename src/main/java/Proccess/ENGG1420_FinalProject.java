/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Proccess;

import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.*;
import org.json.simple.parser.ParseException;

/**
 *
 * @author ryanv, Jacob
 */
public class ENGG1420_FinalProject {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException, ParseException {
        
        ReadJSON JSONReader = new ReadJSON("C:/Users/ryanv/Documents/Programing/Java/ENGG1420_Final_Project/src/main/java/Proccess/TestScenarioTwo.json");

        System.out.println(JSONReader.SplitObject.get("parameters"));
        
        
        // This code is used to test the Split Processing Element     
        /*
        ArrayList<String> FileTest = new ArrayList<String>();
        FileTest.add("C:/Users/ryanv/Documents/Programing/Java/ENGG1420_Final_Project/src/main/java/Proccess/RandomText/LoremIpsum1.txt");
        
        SplitProcessingElement myElement = new SplitProcessingElement(FileTest, 50);
        ArrayList<String> outputFiles = myElement.FileSeparater();
        
        for(String file : outputFiles){
            System.out.println(file);
        }*/
        
    }
}