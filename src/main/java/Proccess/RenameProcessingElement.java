package Proccess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * rename
 */
public class RenameProcessingElement {
    private static final String StringUtils = null;
    private ArrayList<String> inputList; 
    private ArrayList<String> suffixList;
    
    public RenameProcessingElement(ArrayList<String> inputList, ArrayList<String> suffixList){
        this.inputList = inputList;
        this.suffixList = suffixList;
    }

    public static ArrayList<String> renameFile() throws IOException {

        Iterator i = inputList.iterator();

        while (i.hasNext()) {
            String newPath = StringUtils.substringBeforeLast(i.next(), ".") + suffixList + "." + StringUtils.substringAfterLast(i.next(), ".");
        }
        return inputList;
    }

    public static void main(String[] args) throws IOException {
        
        String input = "test.txt";
        String suffix = "1";
        ArrayList<String> newList = renameFile();
    }
}