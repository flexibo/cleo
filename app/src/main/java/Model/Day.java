/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.time.LocalDate;
/**
 *
 * @author sidneylawther
 */
public class Day {
    public int durationStudy;
    public int durationRest;
    public LocalDate date;
    
    public Day(int durationStudy, int durationRest, LocalDate date) {
        this.durationStudy = durationStudy;
        this.durationRest = durationRest;
        this.date = date;
    }
    
}