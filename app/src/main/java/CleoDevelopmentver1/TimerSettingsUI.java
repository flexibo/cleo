/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CleoDevelopmentver1;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.event.*;
import javax.swing.JTextField;
import javax.swing.Timer;


/**
 *
 * @author sidneylawther
 */
public class TimerSettingsUI implements ChangeListener, ActionListener {
    JFrame frame = new JFrame();
    
    //panel 1: start/end session timer
    JPanel panel1 = new JPanel(); 
    JLabel label = new JLabel("Timer");
    JLabel showTime = new JLabel("00:00");
    JLabel currentStage = new JLabel();
    JButton button1 = new JButton("Start Session");
    JButton button2 = new JButton("End Session");
    TimerSpecification defaultPomodoro = new TimerSpecification("Pomodoro Timer", 25,5);
    TimerSpecification[] options = {defaultPomodoro};
    JComboBox comboBox = new JComboBox(options);
    Timer timer = new Timer(1000, this); // timer with faster speed for testing purposes
    
    
    //stuff for interval timer
    int k = 0;
    int studyDurationInt = 0;
    int restDurationInt = 0;
    boolean isWorking = true;
    boolean extendedWork = false;
    boolean extendedRest = false;
    
    //panel 2: custom timer set-up
    JPanel panel2 = new JPanel(); // setting a timer specification
    JPanel panel3 = new JPanel(); // for formatting
    JPanel panel4 = new JPanel(); // for formatting
    JLabel label2 = new JLabel("Set Custom Timer");
    JLabel studyDuration = new JLabel();
    JLabel restDuration = new JLabel();
    JSlider studySlider = new JSlider(0, 120,60);
    JSlider restSlider = new JSlider(0,120,60);
    JTextField textField1 = new JTextField("Name of Custom Timer");
    JButton button3 = new JButton("Save Settings");
    
    //notification frame (for move to rest)
    JFrame frame2 = new JFrame();
    JLabel label3 = new JLabel("Work Period over!");
    JPanel panel5 = new JPanel();
    JButton button4 = new JButton("5 more minutes");
    JButton button5 = new JButton("Time to rest!");
    
    //notification frame (for move to break)
    JFrame frame3 = new JFrame();
    JLabel label4 = new JLabel("Rest is over!");
    JPanel panel6 = new JPanel();
    JButton button6 = new JButton("5 more minutes");
    JButton button7 = new JButton("Ready for Work!");
    
    
    
    
    
    TimerSettingsUI() {
        frame.setTitle("Timer");
        frame.setSize(620, 420);
        frame.setLayout(null);
        
        button1.addActionListener(this);
        button2.addActionListener(this);
        showTime.setFont(new Font("Serif", Font.PLAIN, 40));
        
        panel1.add(label);
        panel1.add(comboBox);
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(currentStage);
        panel1.add(showTime);
        panel1.setBounds(0,0,310,210);
        
        studyDuration.setText("Work Duration: " + studySlider.getValue());
        studySlider.addChangeListener(this);
        restDuration.setText("Rest Duration: " + restSlider.getValue());
        restSlider.addChangeListener(this);
        textField1.setPreferredSize(new Dimension(300,40));
        textField1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event) {
                if (textField1.getText().equals("Name of Custom Timer")) {
                    textField1.setText("");
                }
            }
            
            @Override
            public void focusLost(FocusEvent event) {
                if (textField1.getText().equals("")) {
                    textField1.setText("Name of Custom Timer");
                }
            }
        });
        button3.addActionListener(this);
         
        panel3.add(studyDuration);
        panel3.add(studySlider);
        panel4.add(restDuration);
        panel4.add(restSlider);
        
        panel2.add(label2);
        panel2.add(panel3);
        panel2.add(panel4);
        panel2.add(textField1);
        panel2.add(button3);
        panel2.setBounds(310,0,310,210);
        
        frame.add(panel1);
        frame.add(panel2);
        frame.setVisible(true);
    }
    
    
    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == studySlider) {
            studyDuration.setText("Work Duration: " + studySlider.getValue());
        }
        if (e.getSource() == restSlider) {
            restDuration.setText("Rest Duration: " + restSlider.getValue());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {     
        if (e.getSource() == button1) {
            //k = 0;
            //timer = new Timer(10, this);
            timer.start();
            currentStage.setText("Work Period");
            TimerSpecification timerUsed = (TimerSpecification) comboBox.getSelectedItem();
            studyDurationInt = timerUsed.studyTime;
            restDurationInt = timerUsed.breakTime;
            
            
        }
        
        if (e.getSource() == button2) {
            timer.stop();
            showTime.setText(String.valueOf(mins(0) + ":" + secs(0)));
            
        }
        
        if (e.getSource() == button3) {
            TimerSpecification newCustomTimer = new TimerSpecification(textField1.getText(), studySlider.getValue(), restSlider.getValue());
            comboBox.addItem(newCustomTimer);
            textField1.setText("Name of Custom Timer");
            studySlider.setValue(60);
            restSlider.setValue(60);
            
        }
        
        if (e.getSource() == button4) { //extend study
            extendedWork = true;
            timer.start();
            frame2.dispose();
            button4.setEnabled(false);
        }
        
        if (e.getSource() == button5) { // move to rest
            k = 0;
            timer.start();
            isWorking = false;
            frame2.dispose();
            button4.setEnabled(true);
        }
        if (e.getSource() == button6) { // extend rest
            extendedRest = true;
            timer.start();
            frame3.dispose();
            button6.setEnabled(false);
            
            
        }
        if (e.getSource() == button7) { //move to work
            k = 0;
            timer.start();
            isWorking = true;
            frame3.dispose();
            button6.setEnabled(true);
            
        }
        
        if (e.getSource() == timer) {
            
            showTime.setText(String.valueOf(mins(k) + ":" + secs(k)));
            //JLabel mainUIShowTime = new JLabel();
            //mainUIShowTime.setText(String.valueOf(mins(k) + ":" + secs(k)));
            k++;
            currentStage.setText(isWorking? "Work Period" : "Rest Period");
            
            
            if(extendedWork && k == 5 + studyDurationInt + 1) {
                extendedWork = false;
                timer.stop();
                moveToRest();
            }
            else if(extendedRest && k == 5 + restDurationInt + 1) {
                extendedRest = false;
                timer.stop();
                moveToWork();
            }
            
            
            else if(isWorking && k  == studyDurationInt + 1) {
                timer.stop();
                moveToRest();
                //isWorking = false;
                //System.out.println(k);
            }
            
            else if (!isWorking && k == restDurationInt + 1) {
                timer.stop();
                //isWorking = true;
                moveToWork();
                
                
            }
        }
            
        }
            
        
    
    private String mins(int k) {
        if ((k / 60) < 10) {
            return "0" + (k / 60);
        } else {
            return k / 60 + "";
        }
    }
    
    private String secs(int k) {
        
        if (k - ((k / 60) * 60) < 10) {
            return "0" + (k - ((k / 60) * 60));
        } else {
            return k - ((k / 60) * 60) + "";
        }
    }
    
    private void moveToRest() {
        
        //frame.setTitle("Timer");
        frame2.setSize(300, 120);
        frame2.setLayout(new FlowLayout(3));
        
        button4.addActionListener(this);
        button5.addActionListener(this);
        panel5.add(button4);
        panel5.add(button5);
        frame2.add(label3);
        frame2.add(panel5);
        frame2.setVisible(true);
    }
    
    private void moveToWork() {
        frame3.setSize(300, 120);
        frame3.setLayout(new FlowLayout(3));
        
        button6.addActionListener(this);
        button7.addActionListener(this);
        panel6.add(button6);
        panel6.add(button7);
        frame3.add(label4);
        frame3.add(panel6);
        frame3.setVisible(true);
    }
}
