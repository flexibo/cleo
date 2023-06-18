/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CleoDevelopmentver1;

import Model.SubTask;
import Model.MainTask;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;



/**
 *
 * @author sidneylawther
 */

public class AddTask implements ActionListener {
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JLabel label2 = new JLabel("Sub-Tasks:");
    JPanel panel2 = new JPanel();
    JButton button = new JButton("Add task");
    JButton button2 = new JButton("+ new Sub-Task");
    JButton button3 = new JButton("Confirm Task");
    JTextField taskTextField = new JTextField("Main Task");
    JTextField deadlineTextField = new JTextField();
    String[] priority = {"1","2","3","4","5"};
    
    ArrayList<JTextField> subtasks = new ArrayList<>();
    ArrayList<JTextField> deadlines = new ArrayList<>();
    ArrayList<JComboBox> weights = new ArrayList<>();
    
    
    JComboBox comboBox = new JComboBox(priority);
    //Task task = new Task();
    
    
    AddTask() {
        frame.setTitle("Add a new task");
        frame.setSize(620, 420);
        frame.setLayout(new FlowLayout(3));
        //frame.setLayout(null);
       
        button.setBounds(0, 0, 100, 50);
        button.setFocusable(false);
        button.addActionListener(this);
        
        button2.setBounds(0, 0, 100, 50);
        button2.setFocusable(false);
        button2.addActionListener(this);
        
        button3.setBounds(0, 0, 100, 50);
        button3.setFocusable(false);
        button3.addActionListener(this);
        
        taskTextField.setPreferredSize(new Dimension(300,40));
        taskTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event) {
                if (taskTextField.getText().equals("Main Task")) {
                    taskTextField.setText("");
                }
            }
            
            @Override
            public void focusLost(FocusEvent event) {
                if (taskTextField.getText().equals("")) {
                    taskTextField.setText("Main Task");
                }
            }
        });
        deadlineTextField.setPreferredSize(new Dimension(200,40));
        
        JLabel label3 = new JLabel("SubTasks");
        label3.setPreferredSize(new Dimension(260,40));
        
        JLabel label4 = new JLabel("Deadline");
        label4.setPreferredSize(new Dimension(115,40));
        
        JLabel label5 = new JLabel("Weight");
        label5.setPreferredSize(new Dimension(60,40));
        
        panel2.add(label3);
        panel2.add(label4);
        panel2.add(label5);
        
        
        
        JMenuBar menuBar = new JMenuBar();
        JMenu importMenu = new JMenu("File");
        JMenu exportMenu = new JMenu("Timer");
        JMenu timerMenu = new JMenu("Progress");
        JMenu calendarMenu = new JMenu("Calendar");
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(importMenu);
        menuBar.add(exportMenu);
        menuBar.add(timerMenu); 
        menuBar.add(calendarMenu);
        menuBar.add(helpMenu);
        frame.setJMenuBar(menuBar);
        
        //frame.add(button);
        frame.add(taskTextField);
        frame.add(deadlineTextField);
        frame.add(comboBox);
        frame.add(label2);
        frame.add(button2);
        frame.add(panel2);
        frame.add(addPannel());
        frame.add(button3);
        frame.add(addPannel());
        frame.getContentPane().setBackground(new Color(255,255,255));
        frame.setVisible(true);
    }
    
    JPanel addPannel() {
        JTextField ST1TextField = new JTextField();
        JTextField ST1deadlineTextField = new JTextField();
        JComboBox weightBox = new JComboBox(priority);
        
        ST1TextField.setPreferredSize(new Dimension(250,40));
        ST1deadlineTextField.setPreferredSize(new Dimension(120,40));
        
        JPanel panel = new JPanel();
        panel.add(ST1TextField);
        this.subtasks.add(ST1TextField);
        panel.add(ST1deadlineTextField);
        this.deadlines.add(ST1deadlineTextField);
        panel.add(weightBox);
        this.weights.add(weightBox);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*if (e.getSource() == button) {
            //System.out.println(textField.getText());
            MainUI.tasks.add(new MainTask(taskTextField.getText(), deadlineTextField.getText(), (String) comboBox.getSelectedItem()));
            MainUI.myTaskList.addElement(taskTextField.getText());
            MainUI.myDeadlineList.addElement(deadlineTextField.getText());
            MainUI.myPriorityList.addElement((String) comboBox.getSelectedItem());
        }*/
        if (e.getSource() == button2) {
            frame.add(addPannel());
            frame.setVisible(true);
        }
        if (e.getSource() == button3) {
            //add main task to to-do list & add subtasks into the main task
            MainTask mainTask = new MainTask(taskTextField.getText(), deadlineTextField.getText(), (int) comboBox.getSelectedItem());

            System.out.println(deadlines.get(1).getText());
            for (int i = 0; i < deadlines.size(); i++) {
                String subTaskTitle = subtasks.get(i).getText();
                String deadline = deadlines.get(i).getText();
                int weight = (int) weights.get(i).getSelectedItem();
                
                SubTask subTask = new SubTask(subTaskTitle, deadline, weight);
                
            }
            
            mainTask.updateWeight();
        }
    }
   
    
}
