/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CleoDevelopmentver1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author sidneylawther
 */

public class MainUI extends JFrame implements ActionListener {
    //ImageIcon image = new ImageIcon("src/main/resources/image0.jpg");
    JButton button = new JButton("Add Task");
    //JTextField textField = new JTextField();
    static ArrayList<MainTask> tasks = new ArrayList<>();
    final static DefaultListModel<String> myTaskList = new DefaultListModel<>();
    static JList<String> taskList = new JList<>(myTaskList);
    JLabel taskTitle = new JLabel("Main Tasks");
    
    final static DefaultListModel<String> myDeadlineList = new DefaultListModel<>();
    static JList<String> deadlineList = new JList<>(myDeadlineList);
    JLabel deadlineTitle = new JLabel("Deadline");
    
    final static DefaultListModel<String> myPriorityList = new DefaultListModel<>();
    static JList<String> priorityList = new JList<>(myPriorityList);
    JLabel priorityTitle = new JLabel("Priority");
    
    
    
    MainUI() {
        this.setTitle("Test");
        this.setSize(620, 420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        
        taskList.setBounds(0,100,200,200);
        deadlineList.setBounds(200,100,80,200);
        priorityList.setBounds(280,100,50,200);
        taskList.setBackground(new Color(255,255,255));
        deadlineList.setBackground(new Color(255,255,255));
        priorityList.setBackground(new Color(255,255,255));
        
        taskTitle.setBounds(0,50,200,80);
        deadlineTitle.setBounds(200,50,80,80);
        priorityTitle.setBounds(280,50,50,80);

        //taskTitle.setVerticalTextPosition(JLabel.BOTTOM);
        //taskTitle.setBackground(Color.black);
        //taskTitle.setOpaque(true);


        
        this.add(taskList);
        this.add(taskTitle);
        this.add(deadlineList);
        this.add(deadlineTitle);
        this.add(priorityList);
        this.add(priorityTitle);
        
        initializeTasks();
        
        button.setBounds(0, 0, 100, 50);
        button.setFocusable(false);
        button.addActionListener(this);
        
        //textField.setPreferredSize(new Dimension(250, 40));
        //this.add(textField);
        this.add(button);
        
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
        this.setJMenuBar(menuBar);
        
       
        this.getContentPane().setBackground(new Color(255,255,255));
        
        this.setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == button) {
            //System.out.println(textField.getText());
            new AddTask();
            System.out.println("hi");
        }
    }
    
    private  void initializeTasks() {
        for (int i = 1; i < 6; i++) {
            this.tasks.add(new MainTask("Task " + i, i + "/7/2023", "1"));
        }
        
        for (int i = 0; i < this.tasks.size();  i++) {
            myTaskList.addElement(this.tasks.get(i).task);
        }
        
         for (int i = 0; i < this.tasks.size();  i++) {
            myDeadlineList.addElement(this.tasks.get(i).deadline);
         }
        for (int i = 0; i < this.tasks.size();  i++) {
            myPriorityList.addElement(this.tasks.get(i).priority);
        }
       
    }
    
}

