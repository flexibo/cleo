/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import UIStuff.MainTaskItem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sidneylawther
 */
public class MainTask extends Task implements Comparable<MainTask>{
    public int priority;
    public ArrayList<SubTask> subTasks; 
     
    public MainTask() {
        subTasks = new ArrayList<>();
        priority = 1;
    }
    public MainTask(String name, Date date, int priority) {
        super(name, date, 0);
        this.priority = priority;
        this.subTasks = new ArrayList<>();
    }
    
    public MainTask(String name, Date date, int priority, ArrayList<SubTask> subtasks) {  
        super(name, date, 0);
        this.priority = priority;
        this.subTasks = subtasks;
        updateWeight();
    }
    
    
    public MainTask(String name, String date, int priority, ArrayList<SubTask> subtasks) {  
        super(name, date, 0);
        this.priority = priority;
        this.subTasks = subtasks;
        updateWeight();
    }
    
    public String getTask() {
        return this.task;
    }
    public void addSubTask(SubTask subTask) {
        this.subTasks.add(subTask);
        updateWeight();
    }
    
    public SubTask getSubTask(int i) {
        return subTasks.get(i);
    }
    
    
    public final void updateWeight() {
        int sumWeight = 0;
        for (int i = 0; i < subTasks.size(); i++) {
            Task subtask = subTasks.get(i);
            sumWeight += subtask.weight;
        }
        
        this.weight = sumWeight;
    }
    
    
    public int numOfSubTasks() {
        return subTasks.size();
    }

    
    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    @Override
    public int compareTo(MainTask t) {
        int deadlineComparison = this.deadline.compareTo(t.deadline);
        
        if (deadlineComparison == 0) {
            return Integer.compare(this.priority, t.priority);
        }
    
        return deadlineComparison;
    }
}
