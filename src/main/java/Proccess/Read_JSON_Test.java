/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Read_JSON_Test {

    public static List<Entries> parseEntries(String filePath) throws IOException, JSONException {
        String jsonString = readFile(filePath);
        JSONArray jsonArray = new JSONArray(jsonString);

        List<Entries> entryList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            String type = jsonObject.getString("type");
            String name = jsonObject.getString("name");
            long length = jsonObject.getLong("length");

            if (type.equals("local")) {
                String path = jsonObject.getString("path");
                entryList.add(new LocalEntry(name, length, Paths.get(path)));
            } else if (type.equals("remote")) {
                String entryId = jsonObject.getString("entryId");
                String path = jsonObject.getString("path");
                entryList.add(new RemoteEntry(entryId, name, length, Paths.get(path)));
            }
        }

        return entryList;
    }

    private static String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes);
    }
}

