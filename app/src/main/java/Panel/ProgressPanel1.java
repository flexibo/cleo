/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panel;
//import static Panel.ProgressPanel.data;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author sidneylawther
 */
public class ProgressPanel1 extends javax.swing.JPanel {
    public static ArrayList<Model.Day> data = new ArrayList<>();
    //public static ArrayList<Model.Day> data1 = new ArrayList<>();
    //public static ArrayList<Model.Day> data2 = new ArrayList<>();
    //public static ArrayList<Model.Day> data3 = new ArrayList<>();
   
    int i = 0;
    
    public static int timeStudy = 0;
    public static int timeRest = 0;
            
    /**
     * Creates new form ProgressPanel1
     */
    public ProgressPanel1() {
        initComponents();
        //data.add(new Model.Day(250, 15, LocalDate.of(2023, 5, 20)));
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 4,26)));
        data.add(new Model.Day(0, 0, LocalDate.of(2023, 4,27)));
        /*data.add(new Model.Day(275, 50, LocalDate.of(2023, 4,28)));
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 4,29)));
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 4,30)));
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 5, 31)));
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 6, 1)));
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 6, 2)));
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 6, 3)));
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 6, 4)));
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 6, 5)));
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 6, 6)));
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 6, 7)));        
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 6, 8)));
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 6, 9)));
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 6, 10)));
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 6, 11)));
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 6, 12)));
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 6, 13)));
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 6, 14)));
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 6, 15)));
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 6, 16)));
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 6, 17)));    
        data.add(new Model.Day(275, 50, LocalDate.of(2023, 6, 18)));
        data.add(new Model.Day(250, 10, LocalDate.of(2023, 6, 19)));
        data.add(new Model.Day(120, 70, LocalDate.of(2023, 6, 20)));
        data.add(new Model.Day(75, 20, LocalDate.of(2023, 6, 21)));
        data.add(new Model.Day(50, 5, LocalDate.of(2023, 6, 22)));
        data.add(new Model.Day(360, 25, LocalDate.of(2023, 6, 23)));
        data.add(new Model.Day(250, 15, LocalDate.of(2023, 6, 24)));
        data.add(new Model.Day(250, 15, LocalDate.of(2023, 6, 25)));
        data.add(new Model.Day(250, 15, LocalDate.of(2023, 6, 26)));
        data.add(new Model.Day(250, 15, LocalDate.of(2023, 6, 27)));*/

        
        
        addDate(LocalDate.now());
        updateAllView(data);
        dayView1.setBounds(100, 100, dayView1.getWidth(), dayView1.getHeight());
        dayView1.setVisible(true);
        weekView1.setVisible(false);
        monthView1.setVisible(false);
        
        repaint();
                
        
    }
    
    private static void updateAllView(ArrayList<Model.Day> data) {
        updateWeekView(data);
        updateDayView(data);
        updateMonthView(data);

    }
    
    public static void updateDayView(ArrayList<Model.Day> data) {
        ArrayList<Model.Day> dataRefined = new ArrayList<>();
        int k = 1;
        while (k != 0) {
            dataRefined.add(data.get(data.size() - k));
            k = k - 1;
        }
        dayView1.removeData();
        dayView1.generateGraph(dataRefined);
    }
    
    public static void updateWeekView(ArrayList<Model.Day> data) {
        ArrayList<Model.Day> dataRefined = new ArrayList<>();
        int k = 7;
        while (k != 0) {
            dataRefined.add(data.get(data.size() - k));
            k = k - 1;
        }
        weekView1.removeData();
        weekView1.generateGraph(dataRefined);
    }
    
    public static void updateMonthView(ArrayList<Model.Day> data) {
        ArrayList<Model.Day> dataRefined = new ArrayList<>();
        int k = LocalDate.now().lengthOfMonth();
        while (k != 0) {
            dataRefined.add(data.get(data.size() - k));
            k = k - 1;
        }
        monthView1.generateGraph(dataRefined);
    }
    
    
    public static void updateStudy(int k) {
        Model.Day today = data.get(data.size() - 1);
        ProgressPanel1.timeStudy = ProgressPanel1.timeStudy + k;
        data.get(data.size() - 1).durationStudy = data.get(data.size() - 1).durationStudy + k;
        jLabel2.setText("Time Studying: "+ ProgressPanel1.timeStudy);
        updateAllView(data);
        
    }
    
    public static void updateRest(int k) {
        Model.Day today = data.get(data.size() - 1);
        ProgressPanel1.timeRest = ProgressPanel1.timeRest + k;
        data.get(data.size() - 1).durationRest = data.get(data.size() - 1).durationRest + k;
        jLabel1.setText("Time Resting: "+ ProgressPanel1.timeRest);
        updateAllView(data);
    }
    
    public static void addDate(LocalDate newDate) {
        LocalDate lastRecordedDate = data.get(data.size() - 1).date;
        if (!data.get(data.size() - 1).date.equals(newDate) && lastRecordedDate.isBefore(newDate)) {
            while (!lastRecordedDate.equals(newDate)) {
                lastRecordedDate = lastRecordedDate.plusDays(1);
                data.add(new Model.Day(0, 0 , lastRecordedDate));
            }
            //data.add(new Model.Day(0, 0 , newDate));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dayView1 = new Components.DayView();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        weekView1 = new Components.WeekView();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        monthView1 = new Components.ProgressGraphCurved();

        jButton1.setText("Day-View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Time Resting: 0 min");

        jLabel2.setText("Time Studying: 0 min");

        jButton2.setText("Week-View");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Month-View");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(92, 92, 92)
                                .addComponent(jButton1)
                                .addGap(29, 29, 29)
                                .addComponent(jButton2)
                                .addGap(44, 44, 44)
                                .addComponent(jButton3))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dayView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(weekView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(monthView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(355, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dayView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(weekView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(monthView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(393, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        weekView1.setVisible(false);
        monthView1.setVisible(false);
        dayView1.setVisible(true);
        dayView1.setBounds(100, 120, dayView1.getWidth(), dayView1.getHeight());
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        weekView1.setVisible(true);
        monthView1.setVisible(false);
        dayView1.setVisible(false);
        weekView1.setBounds(100, 120, weekView1.getWidth(), weekView1.getHeight());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        weekView1.setVisible(false);
        monthView1.setVisible(true);
        dayView1.setVisible(false);
        monthView1.setBounds(100, 120, monthView1.getWidth(), monthView1.getHeight());
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static Components.DayView dayView1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private static javax.swing.JLabel jLabel1;
    private static javax.swing.JLabel jLabel2;
    private static Components.ProgressGraphCurved monthView1;
    private static Components.WeekView weekView1;
    // End of variables declaration//GEN-END:variables
}
