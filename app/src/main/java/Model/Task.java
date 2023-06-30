/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sidneylawther
 */
public class Task {
    public String task;
    public Date deadline;
    public int weight; 
    public boolean done;
    
    public Task() {
        
    }
    
    public Task(String task, Date date, int weight) {
        this.task = task;
        this.deadline = date;
        this.weight = weight; 
        this.done = false;
    }
    
    public Task(String task, String date, int weight) {
        this.task = task;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.deadline = formatter.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.weight = weight; 
        this.done = false;
    }
    
    public void setTask(String name) {
        this.task = name;
    }
    
    public void setDeadline (Date date) {
        this.deadline = date;
    }
    
    
    public void setDeadline (String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            this.deadline = formatter.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(MainTask.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Incorrect format for date");
        }
    }
    
}
