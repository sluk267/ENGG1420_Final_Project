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
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONException;
import kong.unirest.json.JSONObject;
import org.json.*;

public class Scenario {
    private List<ProcessingElement> elements;
    
    public Scenario(String filename) throws IOException, JSONException {
        this.elements = new ArrayList<ProcessingElement>();
        
        // Read the scenario JSON file
        String json = "";
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            json += line;
        }
        reader.close();
        
        // Parse the scenario JSON file
        JSONArray arr = new JSONArray(json);
        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            String type = obj.getString("type");
            ProcessingElement element = null;
            if (type.equals("LocalEntry")) {
                element = new LocalEntry(obj.getString("path"));
            } else if (type.equals("RemoteEntry")) {
                element = new RemoteEntry(obj.getString("path"), obj.getBoolean("is_local"), 
                                          obj.getString("servicePrincipalKey"), 
                                          obj.getString("accessKeyBase64"), 
                                          obj.getString("repositoryId"));
            } else if (type.equals("NameFilter")) {
                element = new NameFilter(obj.getString("name"));
            } else if (type.equals("LengthFilter")) {
                element = new LengthFilter(obj.getInt("min_length"), obj.getInt("max_length"));
            } else if (type.equals("ContentFilter")) {
                element = new ContentFilter(obj.getString("keyword"));
            } else if (type.equals("CountFilter")) {
                element = new CountFilter(obj.getInt("max_count"));
            } else if (type.equals("Split")) {
                element = new Split();
            } else if (type.equals("List")) {
                element = new List();
            } else if (type.equals("Print")) {
                element = new Print();
            } else {
                throw new IllegalArgumentException("Unknown processing element type: " + type);
            }
            this.elements.add(element);
        }
    }
    
    public Entry run(LaserficheClient client, List<ProcessingElement> processingElements) throws IOException {
        // Run the processing elements in order
        Entry input = null;
        for (ProcessingElement element : this.elements) {
            element.process_input(input);
            input = element.process_output();
        }
        return input;
    }
}
