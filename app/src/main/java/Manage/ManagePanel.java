/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manage;

import Panel.CalendarPanel;
import Panel.ProgressPanel1;
import Panel.TasksPanel;
import Panel.TimerPanel;

/**
 *
 * @author peach
 */
public class ManagePanel {


    /**
     * @param aTimerPanel the timerPanel to set
     */
    public static void setTimerPanel(TimerPanel aTimerPanel) {
        timerPanel = aTimerPanel;
    }
    private static CalendarPanel calendarPanel;
    private static ProgressPanel1 progressPanel;
    private static TasksPanel tasksPanel;
    private static TimerPanel timerPanel;
    
    public final static int CALENDAR_PANEL = 1;
    public final static int PROGRESS_PANEL = 2;
    public final static int TASKS_PANEL = 3;
    public final static int TIMER_PANEL = 4;
    
    public static void initPanels() {
        calendarPanel = new CalendarPanel();
        progressPanel = new ProgressPanel1();
        tasksPanel = new TasksPanel();
        timerPanel = new TimerPanel();
    }
    
    public static void refreshPanel(int panel) {
        switch (panel) {
            case CALENDAR_PANEL -> calendarPanel.refresh();
            case PROGRESS_PANEL -> {
            }
            case TASKS_PANEL -> {tasksPanel.refresh();}
            case TIMER_PANEL -> {
            }
            default -> {
            }
        }
        //progressPanel.refresh();
        //timerPanel.refresh();
    }

    public static CalendarPanel getCalendarPanel() {
        return calendarPanel;
    }
    
    
     /**
     * @return the progressPanel
     */
    public static ProgressPanel1 getProgressPanel() {
        return progressPanel;
    }

    /**
     * @return the tasksPanel
     */
    public static TasksPanel getTasksPanel() {
        return tasksPanel;
    }


    /**
     * @return the timerPanel
     */
    public static TimerPanel getTimerPanel() {
        return timerPanel;
    }
}
