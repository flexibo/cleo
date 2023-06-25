/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;


/**
 *
 * @author peach
 */
public class JsonDecoder {
    public JsonDecoder() {
        JSONParser jsonParser = new JSONParser();

        // Choose the JSON file using a file chooser dialog
        JFileChooser fileChooser = new JFileChooser();
        int userChoice = fileChooser.showOpenDialog(null);

        if (userChoice == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            try (FileReader reader = new FileReader(filePath)) {
                // Parse JSON file
                Object obj = jsonParser.parse(reader);

                if (obj instanceof JSONObject jsonObject) {
// Handle JSON object
                    String name = (String) jsonObject.get("name");
                    long age = (Long) jsonObject.get("age");
                    JSONArray items = (JSONArray) jsonObject.get("items");

                    System.out.println("Name: " + name);
                    System.out.println("Age: " + age);
                    System.out.println("Items: " + items);
                } else if (obj instanceof JSONArray jsonArray) {
// Handle JSON array
                    System.out.println("Array: " + jsonArray);
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
    }
    
}
