
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author TAN JUN HONG
 */
public class Walk_in_Appointment extends javax.swing.JFrame {

    /**
     * Creates new form Walk_in_Appointment1
     */
    int [][] Appointment={{0,0,0,0,0,0,0,0,0,0,0,0},
                              {0,0,0,0,0,0,0,0,0,0,0,0},
                              {0,0,0,0,0,0,0,0,0,0,0,0},
                              {0,0,0,0,0,0,0,0,0,0,0,0},
                              {0,0,0,0,0,0,0,0,0,0,0,0}};
    int[][] times_available={{0,0},
            {0,0},
            {0,0},
            {0,0},
            {0,0}
        };
    String[] all_time= {"10:00","10:30","11:00","11:30","12:00","12:30","1:30","2:00","2:30","3:00","3:30","4:00"};
    public Walk_in_Appointment() throws IOException {
        initComponents();
        available_walkIn();
        first();
        

    }

    
    
    public void available_walkIn() throws IOException{
        String[] day={"Monday","Tuesday","Wednesday","Thursday","Friday"};
        FileReader fr = new FileReader("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Doctor.txt");
        BufferedReader br= new BufferedReader(fr);
        String line = null;
        while((line = br.readLine()) != null){
            String[] array = line.split(",");
            for (int i = 0; i < day.length; i++) {
                if(!array[2].equals(day[i])&& array[3].equals("10:00")){
                    this.times_available[i][0]+=1;
                    
                }else if(!array[2].equals(day[i])&& array[3].equals("1:30")){   
                    this.times_available[i][1]+=1;
                }
            }
        }
        fr.close();
        br.close();
        //System.out.println(Arrays.deepToString(times_available));
        
        
        FileReader fr1 = new FileReader("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Appointment.txt");
        BufferedReader br1= new BufferedReader(fr1);
        String lines = null;
        while((lines = br1.readLine()) != null){
            String[] array = lines.split(",");
            for (int i = 0; i < day.length; i++) {
                for (int j = 0; j < all_time.length; j++) {
                    if (day[i].equals(array[6])&& all_time[j].equals(array[5])) {
                        this.Appointment[i][j]+=1;
                    }
                }
            }
        }
        fr1.close();
        br1.close();
        FileReader fr2 = new FileReader("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Selected Appointment.txt");
        BufferedReader br2= new BufferedReader(fr2);
        String lines1 = null;
        while((lines1 = br2.readLine()) != null){
            String[] array = lines1.split(",");
            for (int i = 0; i < day.length; i++) {
                for (int j = 0; j < all_time.length; j++) {
                    if (day[i].equals(array[6])&& all_time[j].equals(array[5])) {
                        this.Appointment[i][j]+=1;
                    }
                }
            }
        }
        //System.out.println(Arrays.deepToString(times_available));
        jComboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    first();
                } catch (IOException ex) {
                    Logger.getLogger(Walk_in_Appointment.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });     
        
    }
    
    
    public void first() throws IOException {
    // Removed the creation of a new instance of Walk_in_Appointment
    int[][] Appointment = this.Appointment;
    int[][] times_available = this.times_available;
    String[] selection = {};
    String Day = (String) jComboBox2.getSelectedItem();
    System.out.println(Day);

    if (Day.equals("Monday")) {
        for (int j = 0; j < 6; j++) {
            if (Appointment[0][j] < times_available[0][0]) {
                selection = Arrays.copyOf(selection, selection.length + 1);
                selection[selection.length - 1] = all_time[j];
            }
        }
        for (int j = 6; j < 12; j++) {
            if (Appointment[0][j] < times_available[0][1]) {
                selection = Arrays.copyOf(selection, selection.length + 1);
                selection[selection.length - 1] = all_time[j];
            }
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(selection));
    } else if (Day.equals("Tuesday")) {
        for (int j = 0; j < 6; j++) {
            if (Appointment[1][j] < times_available[1][0]) {
                selection = Arrays.copyOf(selection, selection.length + 1);
                selection[selection.length - 1] = all_time[j];
            }
        }
        for (int j = 6; j < 12; j++) {
            if (Appointment[1][j] < times_available[1][1]) {
                selection = Arrays.copyOf(selection, selection.length + 1);
                selection[selection.length - 1] = all_time[j];
            }
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(selection));
    } else if (Day.equals("Wednesday")) {
        for (int j = 0; j < 6; j++) {
            if (Appointment[2][j] < times_available[2][0]) {
                selection = Arrays.copyOf(selection, selection.length + 1);
                selection[selection.length - 1] = all_time[j];
            }
        }
        for (int j = 6; j < 12; j++) {
            if (Appointment[2][j] < times_available[2][1]) {
                selection = Arrays.copyOf(selection, selection.length + 1);
                selection[selection.length - 1] = all_time[j];
            }
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(selection));
    } else if (Day.equals("Thursday")) {
        for (int j = 0; j < 6; j++) {
            if (Appointment[3][j] < times_available[3][0]) {
                selection = Arrays.copyOf(selection, selection.length + 1);
                selection[selection.length - 1] = all_time[j];
            }
        }
        for (int j = 6; j < 12; j++) {
            if (Appointment[3][j] < times_available[3][1]) {
                selection = Arrays.copyOf(selection, selection.length + 1);
                selection[selection.length - 1] = all_time[j];
            }
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(selection));
    } else if (Day.equals("Friday")) {
        for (int j = 0; j < 6; j++) {
            if (Appointment[4][j] < times_available[4][0]) {
                selection = Arrays.copyOf(selection, selection.length + 1);
                selection[selection.length - 1] = all_time[j];
            }
        }
        for (int j = 6; j < 12; j++) {
            if (Appointment[4][j] < times_available[4][1]) {
                selection = Arrays.copyOf(selection, selection.length + 1);
                selection[selection.length - 1] = all_time[j];
            }
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(selection));
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JTIC = new javax.swing.JTextField();
        JTName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTcontact = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JTDisease = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JBADD = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel2.setText("Name:");

        jLabel3.setText("IC:");

        JTIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTICActionPerformed(evt);
            }
        });

        JTName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTNameActionPerformed(evt);
            }
        });

        jLabel4.setText("Contact:");

        JTcontact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTcontactActionPerformed(evt);
            }
        });

        jLabel6.setText("Disease:");

        JTDisease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTDiseaseActionPerformed(evt);
            }
        });

        jLabel7.setText("Time:");

        jLabel8.setText("Day:");

        JBADD.setText("ADD");
        JBADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBADDActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "1:30", "2:00", "2:30", "3:00", "3:30", "4:00" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton5.setForeground(new java.awt.Color(204, 0, 51));
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Walk-In Appointment");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(398, 398, 398)
                                .addComponent(jLabel1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(JTDisease, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addComponent(JTcontact, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(JTIC, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(207, 207, 207)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(363, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JBADD)
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(162, 162, 162))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTIC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTcontact, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JTDisease, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(JBADD)
                .addGap(389, 389, 389))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTICActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTICActionPerformed

    private void JTNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTNameActionPerformed

    private void JTcontactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTcontactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTcontactActionPerformed

    private void JTDiseaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTDiseaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTDiseaseActionPerformed

    private void JBADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBADDActionPerformed
        // TODO add your handling code here:
        String Time=(String) jComboBox1.getSelectedItem();
        String Day=(String) jComboBox2.getSelectedItem();
        if(JTIC.getText().isEmpty() || JTName.getText().isEmpty() || JTcontact.getText().isEmpty() || JTDisease.getText().isEmpty() || Time==null|| Day.isEmpty() ) {
            JOptionPane.showMessageDialog(this,"Please fill in all the data!" );
        }
        else{
            String data[] = {JTIC.getText(),JTName.getText(),JTcontact.getText(),JTDisease.getText(),"Walk-in",Time,Day};
            JOptionPane.showMessageDialog(this, "add Walk-in appointment successful!");
            JTIC.setText("");
            JTName.setText("");
            JTcontact.setText("");
            JTDisease.setText("");
            try {
                FileWriter fw3 = new FileWriter("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Appointment.txt",true);
                BufferedWriter bw3 = new BufferedWriter(fw3);
                bw3.write(String.join(",",data)+"\n");
                bw3.close();
                fw3.close();
                System.out.println(String.join(",",data));
            } catch (IOException ex) {
                Logger.getLogger(Walk_in_Appointment.class.getName()).log(Level.SEVERE, null, ex);
            } 
            Walk_in_Appointment Walk_in_Appointment = null;
            try {
                Walk_in_Appointment = new Walk_in_Appointment();
            } catch (IOException ex) {
                Logger.getLogger(Walk_in_Appointment.class.getName()).log(Level.SEVERE, null, ex);
            }
            Walk_in_Appointment.setVisible(true);
            this.dispose();
            

        }
            
        
    }//GEN-LAST:event_JBADDActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Admin_Registration_GUI Admin_Registration_GUI = new Admin_Registration_GUI();
        Admin_Registration_GUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Walk_in_Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Walk_in_Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Walk_in_Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Walk_in_Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Walk_in_Appointment().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Walk_in_Appointment.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBADD;
    private javax.swing.JTextField JTDisease;
    private javax.swing.JTextField JTIC;
    private javax.swing.JTextField JTName;
    private javax.swing.JTextField JTcontact;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
