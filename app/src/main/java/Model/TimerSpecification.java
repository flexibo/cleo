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
    
    public TimerSpecification(String name, int studyTime, int breakTime) {
        this.name = name;
        this.studyTime = studyTime;
        this.breakTime = breakTime;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
}
