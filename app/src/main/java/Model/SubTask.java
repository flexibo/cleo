/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import UIStuff.SubTaskItem;

/**
 *
 * @author sidneylawther
 */
public class SubTask extends Task {

    private SubTaskItem item;
    
    public SubTask(String name, String deadline, int weight) {
        super(name,deadline,weight);
    }
    
    public void setItem(SubTaskItem item) {
        this.item = item;
    }
    
    public SubTaskItem getItem() {
        return this.item;
    }
}
