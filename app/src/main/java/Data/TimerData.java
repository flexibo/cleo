/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Model.TimerSpecification;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author peach
 */
public class TimerData {
    private static ArrayList<TimerSpecification> timers;
    final private static String FILEPATH = "tasks.json";
    final private static String KEY = "timers";
    
    public static TimerSpecification[] getTimers() {
        loadTimers();
        TimerSpecification[] timerArray = {new TimerSpecification("Pomodoro Timer", 25, 5)};
        if (timers != null) {
           timerArray = timers.toArray(TimerSpecification[]::new); 
        } 
        
        return timerArray;
    }
    
    public static void addTimer(TimerSpecification timer) {
        timers.add(timer);
        saveTimers();
    }
    
    public static void deleteTimer(int index) {
        timers.remove(index);
        saveTimers();
    }
    
    public static void deleteTimer(TimerSpecification timer) {
        timers.remove(timer);
        saveTimers();
    }
    
    public static void editTimer(TimerSpecification timer, int index) {
        timers.set(index, timer);
        saveTimers();
    }
    
    private static void loadTimers() {
        Gson gson = new Gson();
        Type mainTaskListType = new TypeToken<ArrayList<TimerSpecification>>() {}.getType();
        JSONObject json = JsonEncode.readJsonFromFile(FILEPATH);
        if (json != null) {
            try {
                JSONArray mainTasksJSONArray = (JSONArray) json.get(KEY);
                timers = gson.fromJson(mainTasksJSONArray.toString(), mainTaskListType);
            } catch (JSONException e) {
                timers = new ArrayList<>();
                addTimer(new Model.TimerSpecification("Pomodoro Timer", 25,5));
                loadTimers();
            }   
        }
    }
        
    private static void saveTimers() {
        Gson gson = new Gson();
        JSONObject json = JsonEncode.readJsonFromFile(FILEPATH);

        if (json != null) {
            JSONArray timersJSONArray = json.optJSONArray(KEY);

            timersJSONArray = new JSONArray();

            for (TimerSpecification timer : timers) {
                String timerJson = gson.toJson(timer);
                timersJSONArray.put(new JSONObject(timerJson));
            }

            json.put(KEY, timersJSONArray);
            JsonEncode.saveJsonToFile(json, FILEPATH);
        }
    }
}
