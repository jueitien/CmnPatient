import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author 60176
 */
public class Doctor_Individual_Timetable extends javax.swing.JFrame {

    /**
     * Creates new form Doctor_Individual_Timetable
     * @throws java.io.IOException
     */
    String DocTime;
    public void getTime(){
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Doctor.txt"))) {
            String line;
            Addition a =new Addition();
            String DocIC = a.read();
            while ((line = br.readLine()) != null) {
                String values [] = line.split(",");
                    if(values[0].equals(DocIC)){
                        if(values[3].equals("10:00")){
                            this.DocTime = "10:00";
                        }else{
                            this.DocTime = "1:30";
                        }
                    }
            }
        } catch (IOException e) {
           System.out.println("Error writing to selected appointment file: " + e.getMessage());
        }
    }
    public Doctor_Individual_Timetable() throws IOException {
        initComponents();
        populateTable();
        getTime();
        //System.out.println(getTime());
        if(DocTime.equals("10:00")){
            jLabel2.setText("Morning Shift (10am - 12:30pm)"); 
        } else{
            jLabel2.setText("Afternoon Shift (1:30pm - 4:00pm)"); 
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Your Individual Timetable");

        jButton1.setText("Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1178, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(308, 308, 308)
                .addComponent(jButton1)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DoctorSelection a = new DoctorSelection();
        a.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed
//041226050053,Alex,8382834,Jun,cough,12:00,Thursday,walk-in
    public void populateTable() throws IOException {
        Addition a = new Addition();
        String DocIc = a.read();
        String[] times = {"10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "1:30", "2:00", "2:30", "3:00", "3:30", "4:00"};
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        int[][] data = new int[times.length][days.length];

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Selected Appointment.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            if (values[0].equals(DocIc)) {
                String time = values[5];
                String day = values[6];

                Doctor_Timetable dt = new Doctor_Timetable();
                int daysIndex = dt.indexOf(days, day);
                int timesIndex = dt.indexOf(times, time);

                if (daysIndex != -1 && timesIndex != -1) {
                    data[timesIndex][daysIndex] += 1;
                }
            }
        }
        }

        Object[][] tableData = new Object[days.length][times.length + 1];
        for (int i = 0; i < days.length; i++) {
            tableData[i][0] = days[i];
            for (int j = 0; j < times.length; j++) {
                tableData[i][j + 1] = data[j][i];
            }
        }

        String offDay = null;
        try (BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Doctor.txt"))) {
            String line2;
            while ((line2 = br2.readLine()) != null) {
                String[] values = line2.split(",");
                if (values[0].equals(DocIc)) {
                    offDay = values[2];
                    break;
                }
            }
        }

        

        String[] columnNames = {"Time", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "1:30", "2:00", "2:30", "3:00", "3:30", "4:00"};
        DefaultTableModel model = new DefaultTableModel(tableData, columnNames);
        jTable1.setModel(model);
        jTable1.setDefaultRenderer(Object.class, new CustomRenderer(offDay));
    }
    
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
            java.util.logging.Logger.getLogger(Doctor_Individual_Timetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Doctor_Individual_Timetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Doctor_Individual_Timetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Doctor_Individual_Timetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Doctor_Individual_Timetable().setVisible(true);
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Doctor_Individual_Timetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        });
    }

    
    class CustomRenderer extends DefaultTableCellRenderer {
        private final String offDay;

        public CustomRenderer(String offDay) {
            this.offDay = offDay;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            cell.setBackground(Color.WHITE);

            if (table.getValueAt(row, 0).equals(offDay)) {
            cell.setBackground(Color.RED);
        } else if (value instanceof Integer) {
            int intValue = (Integer) value;
            if (intValue > 0) {
                cell.setBackground(Color.YELLOW);
            } else if (intValue == 0) {
                cell.setBackground(Color.WHITE);
            }
        }


            return cell;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
