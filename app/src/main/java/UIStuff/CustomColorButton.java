/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UIStuff;

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
public class CustomColorButton extends JButton {

    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private Color borderColor;
    private Color chooseColor;
    
    public CustomColorButton() {
        setContentAreaFilled(false);
        setFocusable(false);
        color = new Color(190, 90, 131);
        colorOver = new Color(212, 116, 155);
        colorClick = new Color(212, 116, 155);
        setForeground(color);
        setBorderPainted(false);
    
        // Add event mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                over = true;
                chooseColor = colorOver;
                setForeground(chooseColor);
            }
            @Override
            public void mouseExited(MouseEvent me) {
                over = false;
                chooseColor = color;
                setForeground(chooseColor);
            }
            @Override
            public void mousePressed (MouseEvent me) {
                chooseColor = colorClick;
                setForeground(chooseColor);
            }
            @Override
            public void mouseReleased (MouseEvent me) {
                if(over) {
                    chooseColor = colorOver;
                    setForeground(chooseColor);
                } else {
                    chooseColor = color;
                    setForeground(chooseColor);
                }
            }
        });
    }
    
    
    /**
     * @return the colorOver
     */
    public Color getColorOver() {
        return colorOver;
    }

    /**
     * @param colorOver the colorOver to set
     */
    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    /**
     * @return the colorClick
     */
    public Color getColorClick() {
        return colorClick;
    }

    /**
     * @param colorClick the colorClick to set
     */
    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    /**
     * @return the borderColor
     */
    public Color getBorderColor() {
        return borderColor;
    }

    /**
     * @param borderColor the borderColor to set
     */
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
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

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        
        // Border set 2 px
        g2.setColor(chooseColor);
        g2.fillRoundRect(0,0, getWidth(), getHeight(), 30, 30);
        
        g2.setColor(new Color(255, 212, 213));
        g2.fillRoundRect(3,3, getWidth()-6, getHeight()-6, 30, 30);

        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
