/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Model.Day;
import Model.MainTask;
import static Panel.ProgressPanel1.data;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author sidneylawther
 */
public class DurationData {
    private static ArrayList<Day> days;
    final private static String FILEPATH = "tasks.json";
    final private static String KEY = "Duration";
    
    public static ArrayList<Day> getDays() {
        loadDays();
        return days;
    }
    
    private static void loadDays() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
        gsonBuilder.excludeFieldsWithModifiers(Modifier.TRANSIENT, Modifier.STATIC, Modifier.VOLATILE);
        Gson gson = gsonBuilder.create();
        Type mainTaskListType = new TypeToken<ArrayList<Day>>() {}.getType();
        JSONObject json = JsonEncode.readJsonFromFile(FILEPATH);
        if (json != null) {
            JSONArray mainTasksJSONArray = (JSONArray) json.get(KEY);
            days = gson.fromJson(mainTasksJSONArray.toString(), mainTaskListType);
        }
    }
    
    
        
    private static void saveDays() {
        Gson gson = new Gson();
        JSONObject json = new JSONObject();
        
        JSONArray durationJson = new JSONArray();
        for (Model.Day day : days) {
            String dayJson = gson.toJson(day);
            durationJson.put(new JSONObject(dayJson));
        }
        
        json.put(KEY, durationJson);
        
        System.out.println("saved");
        JsonEncode.saveJsonToFile(json, FILEPATH);
    }
    
    public static void addDay(Day day) {
        days.add(day);
        saveDays();
    }
    
    public static void updateDays(Day day) {
        days.remove(days.size() - 1);
        days.add(day);
        saveDays();
    }
    
    public static void updateStudy(int k) {
        days.get(days.size() - 1).durationStudy += k;
        saveDays();
    }
    
    public static void updateRest(int k) {
        days.get(days.size() - 1).durationRest += k;
        saveDays();
    }
    
}
