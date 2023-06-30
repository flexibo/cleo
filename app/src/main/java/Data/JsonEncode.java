/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author peach
 */
public class JsonEncode {

    public static JSONObject readJsonFromFile(String filepath) {
        try (FileReader reader = new FileReader(filepath)) {
            StringBuilder stringBuilder = new StringBuilder();
            int character;
            while ((character = reader.read()) != -1) {
                stringBuilder.append((char) character);
            }
            return new JSONObject(stringBuilder.toString());
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void saveJsonToFile(JSONObject json, String filepath) {
        try (FileWriter writer = new FileWriter(filepath)) {
            writer.write(json.toString());
            System.out.println("Saved file at filepath: " + filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
