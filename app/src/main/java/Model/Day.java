/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author sidneylawther
 */
public class Day {
    
    public int durationStudy;
    public int durationRest;
    public Date date;
    
    public Day(int durationStudy, int durationRest, Date date) {
        this.durationStudy = durationStudy;
        this.durationRest = durationRest;
        this.date = date;
    }
    
    /* 
    convert Date into LocalDate for Json
    */
    private LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
          .atZone(ZoneId.systemDefault())
          .toLocalDate();
    }
    
    /*
    Converted Date to LocalDate
    */
    public LocalDate getLocalDate(){
        return convertToLocalDateViaInstant(date);
    }
}
