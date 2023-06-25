/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author sidneylawther
 */
public class Task {
    public String task;
    public Date deadline;
    public int weight; 
    public boolean done;
    
    public Task(String task, Date date, int weight) {
        this.task = task;
        this.deadline = date;
        this.weight = weight; 
        this.done = false;
    }
}
