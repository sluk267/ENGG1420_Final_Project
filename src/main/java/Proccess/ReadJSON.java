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
    public JSONObject NameFilterObject;
    public JSONObject ContentFilterObject;
    public JSONObject CountFilterObject;
    public JSONObject RenameObject;
    public JSONObject SplitObject;
    public JSONObject PrintObject;
    public JSONArray processingElements;

    //opening the JSON file and storing it under the name fileInput 
    private final JSONParser parser = new JSONParser();
    private final Object fileInput; 

    ReadJSON(String path) throws IOException, ParseException{
        this.JSONFILEpath = path;
        this.fileInput = parser.parse(new FileReader(JSONFILEpath));
        JSONObject jsonObject = (JSONObject)fileInput;
        this.processingElements = (JSONArray)jsonObject.get("processing_elements");
        JSONArray inputEntries = (JSONArray)((JSONObject)processingElements.get(0)).get("input_entries");
        
        for(int i = 0; i<inputEntries.size(); i++){
            JSONObject temp = (JSONObject)inputEntries.get(i);
            if(temp.get("type") == "local"){
                entryList.add(new Entries("local", (String)temp.get("path")));
            }else if(temp.get("type") == "remote"){
                entryList.add(new Entries("remote", (String)temp.get("repositoryID"), (String)temp.get("entryID")));
            }
        }
        for(int i = 0; i < processingElements.size(); i++){
            if("List".equals((((JSONObject)processingElements.get(i)).get("type")))){
                this.ListObject = (JSONObject)processingElements.get(i);
            }else if("LengthFilter".equals(((JSONObject)processingElements.get(i)).get("type"))){
                this.LengthFilterObject = (JSONObject)processingElements.get(i);
            }else if("NameFilter".equals(((JSONObject)processingElements.get(i)).get("type"))){
                this.NameFilterObject = (JSONObject)processingElements.get(i);
            }else if("ContentFilter".equals(((JSONObject)processingElements.get(i)).get("type"))){
                this.ContentFilterObject = (JSONObject)processingElements.get(i);               
            }else if("CountFilter".equals(((JSONObject)processingElements.get(i)).get("type"))){
                this.CountFilterObject = (JSONObject)processingElements.get(i);       
            }else if("Rename".equals(((JSONObject)processingElements.get(i)).get("type"))){
                this.RenameObject = (JSONObject)processingElements.get(i);       
            }else if("Split".equals(((JSONObject)processingElements.get(i)).get("type"))){
                this.SplitObject = (JSONObject)processingElements.get(i);      
            }else if("Print".equals(((JSONObject)processingElements.get(i)).get("type"))){
                this.PrintObject = (JSONObject)processingElements.get(i);       
            }
        }
 
    }



}