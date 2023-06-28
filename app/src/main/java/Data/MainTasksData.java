/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Model.MainTask;
import Model.SubTask;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import org.json.JSONArray;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peach
 */
public class MainTasksData {
    private static ArrayList<MainTask> mainTasks;
    final private static String FILEPATH = "tasks.json";
    final private static String KEY = "mainTasks";
    
    public static ArrayList<MainTask> getMainTasks() {
        loadTasks();
        return mainTasks;
    }
    
    public static void addTask(MainTask mainTask) {
        mainTasks.add(mainTask);
        sortList();
        saveTasks();
    }
    
    public static void deleteTask(int index) {
        mainTasks.remove(index);
        saveTasks();
    }
    
    public static void editTask(MainTask mainTask, int index) {
        mainTasks.set(index, mainTask);
        sortList();
        saveTasks();
    }
    
    private static void sortList() {
        Collections.sort(mainTasks);
    }
    
    private static void loadTasks() {
        Gson gson = new Gson();
        Type mainTaskListType = new TypeToken<ArrayList<MainTask>>() {}.getType();
        JSONObject json = JsonEncode.readJsonFromFile(FILEPATH);
        
        JSONArray mainTasksJSONArray = (JSONArray) json.get(KEY);
        
        mainTasks = gson.fromJson(mainTasksJSONArray.toString(), mainTaskListType);
    }
        
    private static void saveTasks() {
        Gson gson = new Gson();
        JSONObject json = new JSONObject();
        
        JSONArray mainTasksJson = new JSONArray();
        for (MainTask task : mainTasks) {
            String taskJson = gson.toJson(task);
            mainTasksJson.put(new JSONObject(taskJson));
        }
        
        json.put(KEY, mainTasksJson);
        
        System.out.println("saved");
        JsonEncode.saveJsonToFile(json, FILEPATH);
    }
    
   

    /*
    public static void initData() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        if (mainTasks == null) {
            mainTasks = new ArrayList<>();
            for (int i = 1; i < 6; i++) {
                ArrayList<SubTask> subtasks = new ArrayList<>();
                for (int j = 1; j < 6; j++) {
                    try {
                        subtasks.add(new SubTask("Subtask " + j, df.parse(j + "/7/2023"), j));
                    } catch (ParseException ex) {
                        Logger.getLogger(MainTasksData.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                MainTask mainTask = null;
                try {
                    mainTask = new MainTask("Task " + i, df.parse(i + "/7/2023"), 2, subtasks);
                } catch (ParseException ex) {
                    Logger.getLogger(MainTasksData.class.getName()).log(Level.SEVERE, null, ex);
                }
                mainTasks.add(mainTask);
            }
        }
        
        saveTasks();
    }
    */
}