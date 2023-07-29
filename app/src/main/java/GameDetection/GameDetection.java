/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameDetection;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peach
 */
public class GameDetection {
    protected boolean found = false;
    private ArrayList<BouncingFrame> bouncingFrames = new ArrayList<>();
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1); 
    private Runnable task;
    private boolean started = false;
    
    public GameDetection () {
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            //System.out.println("Windows OS detected, game detection activated :))))))");
             task = () -> {
                try {
                    found = false;
                    String line;
                    Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");
                    
                    try (BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                        while ((line = input.readLine()) != null) {
                            if (line.toLowerCase().contains("tetr.io.exe")) {
                                found = true;
                                System.out.println("!!!!TETR.IO DETECTED!!!!"); //<-- Parse data here.
                                bouncingFrame();
                                break;
                            } else if (line.toLowerCase().contains("valorant.exe"))  {
                                
                            }
                        }
                    }

                    if (!found) {
                        //System.out.println("not found");
                        found = false;
                        terminateAllFrames();
                    }
                        

                } catch (Exception err) {
                    err.printStackTrace();
                }
            };


            
        } else if (System.getProperty("os.name").toLowerCase().contains("apple")) {
            
        } else {    
            System.out.println("Current OS is not supported for Game Detection");
        }
    }
    
    private void bouncingFrame() {
       bouncingFrames.add(new BouncingFrame("animated/dancing.gif", 155, 70));
    }
    
    private void terminateAllFrames() {
       /*
        for (BouncingFrame frame : bouncingFrames) {
           frame.dispose();
       }*/
       
       for (int i = 0; i < bouncingFrames.size(); i++) {
           bouncingFrames.get(i).dispose();
           bouncingFrames.remove(i);
       }
       
       //bouncingFrames = new ArrayList<>();
    }
    
    private void playSound() {
        
    }
    
    private void pressKeys() {
        try {
            Robot robot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(GameDetection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void callYourMother() {
        
    }
    
    private void crosshairCat() {
        
    }
    
    
    public void startDetection() {
        if (!started){
            scheduler = Executors.newScheduledThreadPool(1); 
            scheduler.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);
            System.out.println("Started Game Detection");
            started = true;
        }
    }
    public void endDetection() {
        terminateAllFrames();
        scheduler.shutdown();
        System.out.println("Ended Game Detection");
        started=false;
    }
}
