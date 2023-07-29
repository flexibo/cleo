/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Model.Day;
import Panel.ProgressPanel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author peach
 */
public class DaysData {
    private static ArrayList<Day> days = new ArrayList<>();
    final private static String FILEPATH = "duration.json";
    final private static String KEY = "days";
   
    public static ArrayList<Day> getDays() {
        loadDays();
        return days;
    }
     
     
    public static void addDate(LocalDate newDate) {
        if (days.isEmpty()){
            Calendar calendar = Calendar.getInstance();
            days.add(new Day(250, 15, calendar.getTime()));
        }
        
        LocalDate lastRecordedDate = days.get(days.size() - 1).getLocalDate();
        
        if (!days.get(days.size() - 1).date.equals(newDate) && lastRecordedDate.isBefore(newDate)) {
            while (!lastRecordedDate.equals(newDate)) {
                lastRecordedDate = lastRecordedDate.plusDays(1);
                days.add(new Day(0, 0, Date.from(lastRecordedDate.atStartOfDay(ZoneId.systemDefault()).toInstant())));
            }
            //data.add(new Model.Day(0, 0 , newDate));
        }
        saveDays();
        ProgressPanel.updateAllView(days);
    }
    
    public static void updateTodayRest(int k) {
        Day today = days.get(days.size()-1);
        today.durationRest += k;
        saveDays();
    }
    
    public static void updateTodayStudy(int k) {
        Day today = days.get(days.size()-1);
        today.durationStudy += k;
        saveDays();
    }
    
    public static void resetDays() {
        days = new ArrayList<>();
        saveDays();
    }
    
    private static void loadDays() {
        Gson gson = new Gson();
        Type mainTaskListType = new TypeToken<ArrayList<Day>>() {}.getType();
        JSONObject json = JsonEncode.readJsonFromFile(FILEPATH);
        if (json != null) {
            try {
                JSONArray mainTasksJSONArray = (JSONArray) json.get(KEY);
                days = gson.fromJson(mainTasksJSONArray.toString(), mainTaskListType);
            } catch (JSONException e) {
                days = new ArrayList<>();
                days.add(new Day(250, 15, new Date(1234567890000L)));
                saveDays();
                loadDays();
            }  
        } 
    }
        
    private static void saveDays() {
        Gson gson = new Gson();
        JSONObject json = JsonEncode.readJsonFromFile(FILEPATH);

        if (json != null) {
            JSONArray tasksJSONArray = json.optJSONArray(KEY);

            tasksJSONArray = new JSONArray();

            for (Day day : days){
                String daysJson = gson.toJson(day);
                tasksJSONArray.put(new JSONObject(daysJson));
            }

            json.put(KEY, tasksJSONArray);
            JsonEncode.saveJsonToFile(json, FILEPATH);
        }
    }
}
