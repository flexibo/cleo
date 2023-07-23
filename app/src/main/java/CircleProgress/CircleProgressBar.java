/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CircleProgress;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.SwingConstants;


/**
 *
 * @author sidneylawther
 */
public class CircleProgressBar extends JProgressBar{
    JLabel jLabel1 = new JLabel();
    JPanel panel1 = new JPanel();
    
    public CircleProgressBar() {
        setOpaque(true);
        setBackground(new Color(220,220, 220 ));
        setForeground(new Color(97, 97, 97));
        setStringPainted(true);
        setUI(new ProgressCircleUI());  
        
        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("00:00");
        
        panel1.setLayout(new GridBagLayout());
        panel1.add(jLabel1);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        panel1.setOpaque(false);
        
        this.setLayout(new OverlayLayout(this));
        this.add(panel1);
        
        this.setVisible(true);
        
        
    }
    
    public void setText(String time) {
        this.jLabel1.setText(time);
    }
    
}
