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
public class MinimizeButton extends JButton {
    private boolean over;
    private Color backColor;

    public MinimizeButton () {
        
        this.backColor = new Color(0,0,0,0);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        
        // Add event mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                over = true;
                backColor = new Color(0, 0, 0,10);
            }
            @Override
            public void mouseExited(MouseEvent me) {
                over = false;
                backColor = new Color(0,0,0,0);
            }
            @Override
            public void mousePressed (MouseEvent me) {
                backColor = new Color(0, 0, 0, 20);
            }
            @Override
            public void mouseReleased (MouseEvent me) {
                if(over) {
                    backColor = new Color(0, 0, 0,10);
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
        g2.fillRect(0, 0, getWidth(), getHeight());
        
        g2.setColor(new Color(223, 197, 232)); // Set the color of the cross
        g2.setStroke(new BasicStroke(1f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        int x1 = 0;
        int x2 = getWidth();
        int y1 = getHeight()/2 + 1;
        g2.drawLine(x1+11, y1, x2-11, y1);
        
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
   
}
