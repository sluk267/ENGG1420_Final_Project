/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess;

/**
 *
 * @author Reanna
 */
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class ReadJSON {
    //constructor to take JSOn file input
    private String JSONFILEpath = "";   
    public List<Entries> entryList;
    public JSONObject ListObject;
    public JSONObject LengthFilterObject;
    public JSONObject RenameObject;
    public JSONObject SplitObject;
    public JSONObject PrintObject;

    //opening the JSON file and storing it under the name fileInput 
    private final JSONParser parser = new JSONParser();
    private final Object fileInput; 

    ReadJSON(String path) throws IOException, ParseException{
        this.JSONFILEpath = path;
        this.fileInput = parser.parse(new FileReader(JSONFILEpath));
        JSONObject jsonObject = (JSONObject)fileInput;
        JSONArray processingElements = (JSONArray)jsonObject.get("processing_elements");
        JSONArray inputEntries = (JSONArray)((JSONObject)processingElements.get(0)).get("input_entries");
        
        for(int i = 0; i<inputEntries.size(); i++){
            JSONObject temp = (JSONObject)inputEntries.get(i);
            if(temp.get("type") == "local"){
                entryList.add(new Entries("local", (String)temp.get("path")));
            }else if(temp.get("type") == "remote"){
                entryList.add(new Entries("remote", (String)temp.get("repositoryID"), (String)temp.get("entryID")));
            }
        }
        this.LengthFilterObject = (JSONObject)processingElements.get(1);
        this.ListObject = (JSONObject)processingElements.get(0);
        this.RenameObject = (JSONObject)processingElements.get(2);
        this.SplitObject = (JSONObject)processingElements.get(3);
        this.PrintObject = (JSONObject)processingElements.get(4);
    }



}