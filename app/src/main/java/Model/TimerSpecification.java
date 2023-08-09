/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author sidneylawther
 */
public class TimerSpecification {
    public String name;
    public int studyTime;
    public int breakTime;
    
    /* 
    Create an instance of TimerSpecification, this class is used to create timers, every timer will
    have its own duration for work and rest and a name
    */
    public TimerSpecification(String name, int studyTime, int breakTime) {
        this.name = name;
        this.studyTime = studyTime;
        this.breakTime = breakTime;
    }
    
    /*
    To print out the name of the timer so that the ComboBox of timers in the timer panel 
    shows only the name of the timer
    */
    @Override
    public String toString() {
        return this.name;
    }
    
}
