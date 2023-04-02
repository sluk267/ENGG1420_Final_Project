/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Proccess;

/**
 *
 * @author andrea
 * 
 */

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ListProcessingElement {
    private ArrayList<String> processList;
    
    //creating constructor 
    public ListProcessingElement(ArrayList<String> processList){
    this.processList = processList;
    }
    
    public static ArrayList<String> ProcessList(ArrayList<String> inputList, int Max) throws IOException{
        ArrayList<String> outputList = new ArrayList<String>();
        
        //looping through entries in inputList to check if each one is a directory
        for(String entry : inputList){
            File file = new File(entry);
            if(file.isDirectory()){
                //calling listProcessing method to get the list of entries in the directory
                ArrayList<String> directoryList = listProcessing(file);
                
                //add all the entries or the maximum number of entries from the directory
                int numEntries = Math.min(directoryList.size(), Max);
                for(int i = 0; i < numEntries; i++){
                    outputList.add(directoryList.get(i));
                }
            }
        }
        return outputList;
    }
    
    //returns directoryList with all directories and sub directoies
    private static ArrayList<String> listProcessing(File directory) throws IOException{
        ArrayList<String> directoryList = new ArrayList<String>();
        
        //iterating through all of the entires to check is each one is a directory.
        for(File file : directory.listFiles()){
            if(file.isDirectory()){
                //calls listProcessing on the sub directory and adds the entries in the sub directory to direcroyList
                directoryList.addAll(listProcessing(file));
            }
            else{
                //if not a directory, the absolute path gets add tp the directoeyList
                directoryList.add(file.getAbsolutePath());
            }
        }
        return directoryList;
    }
    
    public static void main(String[] args)throws IOException {
       //inputting the maximum number of entries 
        int Max;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the maximum number of entries to be outputted: ");
        Max = scanner.nextInt();
        
        //List<String> input = Arrays.asList();
        
        ArrayList<String> input = new ArrayList<>(); //figure out how to input the dircetoies 
        
        ArrayList<String> output = ProcessList(input,Max);
        
        System.out.println(output);
    }
}
