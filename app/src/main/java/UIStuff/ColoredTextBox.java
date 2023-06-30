/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UIStuff;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author peach
 */
public class ColoredTextBox extends JTextField{
    public ColoredTextBox() {
        setOpaque(false);
        setBorder(new LineBorder(Color.BLACK,4));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
