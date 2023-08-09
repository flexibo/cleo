/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Manage.ManagePanel;
import Model.MainTask;
import Model.SubTask;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import org.json.JSONArray;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import org.json.JSONException;

/**
 *
 * @author peach
 */
public class MainTasksData {
    private static ArrayList<MainTask> mainTasks;
    final private static String FILEPATH = "tasks.json";
    final private static String KEY = "mainTasks";
    private static boolean loaded = false;
    private static boolean edited = false;
    
    
    public static ArrayList<MainTask> getMainTasks() {
        if (!loaded) {
            loadTasks();
            loaded = true;
        }
        
        return mainTasks;
    }
    
    public static void addTask(MainTask mainTask) {
        mainTasks.add(mainTask);
        sortList();
        saveTasks();
        //System.out.println("size: " + mainTasks.size());
        Manage.ManagePanel.refreshPanel(ManagePanel.CALENDAR_PANEL);
    }
    
    public static void deleteDoneTasks() {
        int count = 0;
        for(int i = 0; i < mainTasks.size(); i++) {
            //System.out.println(mainTasks.get(i));
            if (mainTasks.get(i).done) {
                count++;
                deleteTask(i);
            }
        }
        Manage.ManagePanel.refreshPanel(ManagePanel.CALENDAR_PANEL);
    }
    
    public static void deleteTask(int index) {
        mainTasks.remove(index);
        saveTasks();
        Manage.ManagePanel.refreshPanel(ManagePanel.TASKS_PANEL);
        Manage.ManagePanel.refreshPanel(ManagePanel.CALENDAR_PANEL);
    }
    
    
    public static void deleteTask(MainTask mainTask) {
        mainTasks.remove(mainTask);
        Manage.ManagePanel.refreshPanel(ManagePanel.TASKS_PANEL);
        Manage.ManagePanel.refreshPanel(ManagePanel.CALENDAR_PANEL);
    }
        
        
    public static void editTask(MainTask mainTask, int index) {
        mainTasks.set(index, mainTask);
        sortList();
        saveTasks();
        Manage.ManagePanel.refreshPanel(ManagePanel.TASKS_PANEL);
        Manage.ManagePanel.refreshPanel(ManagePanel.CALENDAR_PANEL);
    }
    
    public static void updateTask(MainTask task) {
        
        saveTasks();
    }
    
    public static int getIndex(MainTask task) {
        return mainTasks.indexOf(task);
    }
    
    public static int size() {
        return mainTasks.size();
    }
    
    private static void sortList() {
        Collections.sort(mainTasks);
    }
    
    private static void loadTasks() {
        Gson gson = new Gson();
        Type mainTaskListType = new TypeToken<ArrayList<MainTask>>() {}.getType();
        JSONObject json = JsonEncode.readJsonFromFile(FILEPATH);
        if (json != null) {
            try {
                JSONArray mainTasksJSONArray = (JSONArray) json.get(KEY);
                mainTasks = gson.fromJson(mainTasksJSONArray.toString(), mainTaskListType);
            } catch (JSONException e) {
                mainTasks = new ArrayList<>();
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
                mainTasks.add(new MainTask("dummy Task", cal.getTime(), 3));
                saveTasks();
                loadTasks();
            }  
        }
        

        for(MainTask mainTask : mainTasks) {
            mainTask.deadline = toMidnight(mainTask.deadline);
            for (SubTask subTask : mainTask.subTasks) {
                subTask.deadline = toMidnight(subTask.deadline);
            }
        }
        if (edited) {
            saveTasks();
            edited = false;
        }
        
    }
    
    private static Date toMidnight(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (cal.get(Calendar.HOUR_OF_DAY) != 0 || cal.get(Calendar.MINUTE) != 0 || cal.get(Calendar.SECOND) != 0 || cal.get(Calendar.MILLISECOND) != 0) {
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
        }
        
        edited = true;
        
        return cal.getTime();
    }
        
    public static void saveTasks() {
        Gson gson = new Gson();
        JSONObject json = JsonEncode.readJsonFromFile(FILEPATH);

        if (json != null) {
            JSONArray tasksJSONArray = json.optJSONArray(KEY);

            tasksJSONArray = new JSONArray();

            for (MainTask task : mainTasks) {
                String timerJson = gson.toJson(task);
                tasksJSONArray.put(new JSONObject(timerJson));
            }

            json.put(KEY, tasksJSONArray);
            JsonEncode.saveJsonToFile(json, FILEPATH);
        }
    }


}