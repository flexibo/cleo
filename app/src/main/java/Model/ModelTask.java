/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author peach
 */
public class ModelTask {
    public String task;
    public String deadline;
    public int weight; 
    public boolean done;
    
    public ModelTask(String task, String date, int weight) {
        this.task = task;
        this.deadline = date;
        this.weight = weight; 
        this.done = false;
    }
}
