/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

/**
 *
 * @author peach
 */
public class JsonEncoder {

    public JsonEncoder() {
        // Create a JSON object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "John Doe");
        jsonObject.put("age", 30);

        // Create a JSON array
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("item1");
        jsonArray.add("item2");
        jsonArray.add("item3");

        jsonObject.put("items", jsonArray);

        // Choose file location using a file chooser dialog
        JFileChooser fileChooser = new JFileChooser();
        int userChoice = fileChooser.showSaveDialog(null);

        if (userChoice == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            // Ensure the file has .json extension
            if (!filePath.endsWith(".json")) {
                filePath += ".json";
            }

            File file = new File(filePath);

            // Check if the file already exists
            if (file.exists()) {
                System.out.println("File already exists at the specified location.");
            } else {
                // Write JSON object to the selected file
                try (FileWriter fileWriter = new FileWriter(file)) {
                    fileWriter.write(jsonObject.toJSONString());
                    System.out.println("Data exported successfully to: " + filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
