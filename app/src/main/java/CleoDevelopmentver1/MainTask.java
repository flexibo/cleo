/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CleoDevelopmentver1;

import java.util.ArrayList;
/**
 *
 * @author sidneylawther
 */
public class MainTask extends Task {
    String priority;
    ArrayList<SubTask> subTasks;
    
    MainTask(String name, String date, String priority) {
        super(name, date, "0");
        this.priority = priority;
        this.subTasks = new ArrayList<>();
    }
    
    public void addSubTask(SubTask subTask) {
        this.subTasks.add(subTask);
    }
    
    
    public void updateWeight() {
        int sumWeight = 0;
        for (int i = 0; i < subTasks.size(); i++) {
            SubTask sT = subTasks.get(i);
            sumWeight = sumWeight + Integer.parseInt(sT.weight);
        }
        this.weight = "" + sumWeight;
        
    }
        
}
