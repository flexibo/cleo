/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author sidneylawther
 */
public class MainTask extends Task {
    public int priority;
    public ArrayList<Task> subTasks; 
    
    public MainTask(String name, String date, int priority) {
        super(name, date, 0);
        this.priority = priority;
        this.subTasks = new ArrayList<>();
    }
    
    public MainTask(String name, String date, int priority, ArrayList<Task> subtasks) {
        super(name, date, 0);
        this.priority = priority;
        this.subTasks = subtasks;
    }
    
    public void addSubTask(Task subTask) {
        this.subTasks.add(subTask);
    }
    
    public void updateWeight() {
        int sumWeight = 0;
        for (int i = 0; i < subTasks.size(); i++) {
            Task subtask = subTasks.get(i);
            sumWeight += subtask.weight;
        }
        
        this.weight = sumWeight;
    }
}
