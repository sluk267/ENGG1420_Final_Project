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

    //opening the JSON file and storing it under the name fileInput 
    private final JSONParser parser = new JSONParser();
    private Object fileInput; 

    ReadJSON(String path){
        this.JSONFILEpath = path;
        this.fileInput = parser.parse(new FileReader(JSONFILEpath));
        JSONObject jsonObject = (JSONObject)fileInput;
        JSONArray inputEntries = (JSONArray)jsonObject.get("input_entries");
        for(int i = 0; i<inputEntries.size(); i++){
            JSONObject temp = (JSONObject)inputEntries.get(i);
            if(temp.get("type") == "local"){
                entryList.add(new Entries("local", (String)temp.get("path")));
            }else if(temp.get("type") == "remote"){
                entryList.add(new Entries("remote", (String)temp.get("repositoryID"), (String)temp.get("entryID")));
            }
        }
    }



}