/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UIStuff;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author peach
 */
public class CloseButton extends JButton {

    private boolean over;
    private Color backColor;

    public CloseButton() {
        
        this.backColor = new Color(0,0,0,0);
        setContentAreaFilled(false);
        
        // Add event mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                over = true;
                backColor = new Color(224, 100, 105);
            }
            @Override
            public void mouseExited(MouseEvent me) {
                over = false;
                backColor = new Color(0,0,0,0);
            }
            @Override
            public void mousePressed (MouseEvent me) {
                backColor = new Color(224, 83, 89);
            }
            @Override
            public void mouseReleased (MouseEvent me) {
                if(over) {
                    backColor = new Color(224, 100, 105);
                } else {
                    backColor = new Color(0,0,0,0);
                }
            }
        });
    }
    
    /**
     * @return the over
     */
    public boolean isOver() {
        return over;
    }

    /**
     * @param over the over to set
     */
    public void setOver(boolean over) {
        this.over = over;
    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        
        // Border set 2 px
        g2.setColor(backColor);
        g2.fillRoundRect(0,0, getWidth(), getHeight()+30, 15, 15);
        g2.fillRect(-20, 0, getWidth(), getHeight());
        
         g2.setColor(new Color(223, 197, 232)); // Set the color of the cross
         g2.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        int x1 = 0;
        int y1 = 0;
        int x2 = getWidth();
        int y2 = getHeight();
        g2.drawLine(x1+12, y1+8, x2-12, y2-8);
        g2.drawLine(x2-12, y1+8, x1+12, y2-8);
        
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
   
    
}
