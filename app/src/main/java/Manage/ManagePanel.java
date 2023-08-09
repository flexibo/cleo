/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manage;

import Panel.CalendarPanel;
import Panel.ProgressPanel;
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
    private static ProgressPanel progressPanel;
    private static TasksPanel tasksPanel;
    private static TimerPanel timerPanel;
    
    public final static int CALENDAR_PANEL = 1;
    public final static int PROGRESS_PANEL = 2;
    public final static int TASKS_PANEL = 3;
    public final static int TIMER_PANEL = 4;
    
    public static void initPanels() {
        tasksPanel = new TasksPanel();
        calendarPanel = new CalendarPanel();
        progressPanel = new ProgressPanel();
        timerPanel = new TimerPanel();
    }
    
    public static void refreshPanel(int panel) {
        switch (panel) {
            case CALENDAR_PANEL -> calendarPanel.refreshCal();
            case PROGRESS_PANEL -> {
            }
            case TASKS_PANEL -> tasksPanel.refresh();
            case TIMER_PANEL -> {
            }
            default -> {
            }
        }
        //progressPanel.refreshCal();
        //timerPanel.refreshCal();
    }
    
    public static CalendarPanel getCalendarPanel() {
        return calendarPanel;
    }
    
    
     /**
     * @return the progressPanel
     */
    public static ProgressPanel getProgressPanel() {
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
