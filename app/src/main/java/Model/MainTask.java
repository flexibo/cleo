/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import UIStuff.MainTaskItem;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sidneylawther
 */
public class MainTask extends Task {
    public int priority;
    private ArrayList<SubTask> subTasks;
    private MainTaskItem item;
    
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
    
    public void addSubTask(SubTask subTask) {
        this.subTasks.add(subTask);
        updateWeight();
    }
    
    public void updateWeight() {
        int sumWeight = 0;
        for (int i = 0; i < subTasks.size(); i++) {
            Task subtask = subTasks.get(i);
            sumWeight += subtask.weight;
        }
        
        this.weight = sumWeight;
    }
    
    public void setItem(MainTaskItem item) {
        this.item = item;
    }
    
    public MainTaskItem getItem() {
        return this.item; 
    }
    
    public SubTask getSubTask(int i) {
        return subTasks.get(i);
    }
    
    public int numOfSubTasks() {
        return subTasks.size();
    }
}
