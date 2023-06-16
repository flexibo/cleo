/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CleoDevelopmentver1;

/**
 *
 * @author sidneylawther
 */
public class TimerSpecification {
    String name;
    int studyTime;
    int breakTime;
    
    TimerSpecification(String name, int studyTime, int breakTime) {
        this.name = name;
        this.studyTime = studyTime;
        this.breakTime = breakTime;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
}
