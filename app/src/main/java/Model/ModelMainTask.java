/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author peach
 */
public class ModelMainTask extends ModelTask {
    public int priority;
    public ArrayList<ModelTask> subTasks; 
    
    public ModelMainTask(String name, String date, int priority) {
        super(name, date, 0);
        this.priority = priority;
        this.subTasks = new ArrayList<>();
    }
    
    public ModelMainTask(String name, String date, int priority, ArrayList<ModelTask> subtasks) {
        super(name, date, 0);
        this.priority = priority;
        this.subTasks = subtasks;
    }
    
    public void addSubTask(ModelTask subTask) {
        this.subTasks.add(subTask);
    }
    
    public void updateWeight() {
        int sumWeight = 0;
        for (int i = 0; i < subTasks.size(); i++) {
            ModelTask subtask = subTasks.get(i);
            sumWeight += subtask.weight;
        }
        
        this.weight = sumWeight;
    }
}
