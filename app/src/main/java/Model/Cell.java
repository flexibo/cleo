/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author peach
 */
public class Cell extends JButton {
    
    private Date date;
    private boolean title;
    private boolean isToday;
    private boolean selected;
    private int weekWeight;
    private boolean curMonth;
    private boolean subtask;
    private boolean maintask;
    
    public Cell() {
        setContentAreaFilled(false);
        setBorder(null);
        setHorizontalAlignment(JLabel.CENTER);
        setFocusable(false);
        weekWeight = 0;
    }
    
    public void asTitle() {
        this.title = true;
    }
    
    public boolean isTitle() {
        return this.title;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public Date getDate() {
        return this.date;
    }
    
     public void setWeekWeight(int weekWeight) {
        this.weekWeight = weekWeight;
    }
    
    public void currentMonth(boolean act) {
       this.curMonth = act;
       if (act){
           setForeground(new Color(68,68,68));
       } else {
           setForeground(new Color(168,169,169));
       }
    }
    
    public void setAsToday(){
        this.isToday = true;
    }
    
    public void setAsSelected(boolean bool) {
        this.selected = bool;
        if (bool)
            setForeground(Color.WHITE);
        else {
            if (curMonth){
                setForeground(new Color(68,68,68));
            } else {
                setForeground(new Color(168,169,169));
            }
        }
    }
    
    public void setWeightWeek(int weight){
        this.weekWeight = weight; 
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(title) {
            g.setColor(new Color(213, 213, 213));
            g.drawLine(0, getHeight()-1, getWidth(), getHeight()-1);
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
        if(weekWeight > 0 && weekWeight <= 15) {
            g2.setColor(new Color(130, 228, 255));
            g2.fillRect(0, 0, getWidth(), getHeight());
        } else if (weekWeight > 15 && weekWeight <= 30) {
            g2.setColor(new Color(130, 255, 186));
            g2.fillRect(0, 0, getWidth(), getHeight());
        } else if (weekWeight > 30 && weekWeight <= 45) {
            g2.setColor(new Color(248, 252, 106));
            g2.fillRect(0, 0, getWidth(), getHeight());
        } else if (weekWeight > 45 && weekWeight <= 60) {
            g2.setColor(new Color(255, 180, 105));
            g2.fillRect(0, 0, getWidth(), getHeight());
        } else if (weekWeight > 60) {
            g2.setColor(new Color(255, 105, 105));
            g2.fillRect(0, 0, getWidth(), getHeight());
        }
        
        if(isToday) {
            g2.setColor(new Color(255, 255, 255,50));
            int x = getWidth()/2-19;
            int y = getHeight()/2-19;
            g2.fillRoundRect(x, y, 40, 40, 100, 100);
        }
        if (selected) {
            setForeground(Color.WHITE);
            Graphics2D g3 = (Graphics2D) g;
            g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g3.setColor(new Color(181, 40, 61));
            
            int x = getWidth()/2-16;
            int y = getHeight()/2-17;
            g3.fillRoundRect(x, y, 35, 35, 100, 100);
        }
        
        if (subtask) {
            
        }
                
        super.paintComponent(g); 
    }
}
