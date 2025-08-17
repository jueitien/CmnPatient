
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


public class Doctor_Timetable extends javax.swing.JFrame {

    public int indexOf(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1; // Return -1 if the value is not found
    }
    
    public Doctor_Timetable() throws IOException {
        initComponents();
        populatetable();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

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

        jLabel1.setText("Doctor's Availability");

        jLabel2.setText("If doctor's availability 5/5 means all doctors are busy.");

        jButton1.setText("Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(307, 307, 307)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(132, 132, 132)))
                        .addComponent(jButton1)
                        .addGap(13, 13, 13)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DoctorSelection a = new DoctorSelection();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    

    public void populatetable() throws IOException {
        int[][] counts = null; 
        ManageDoctorWorkingHours GetAmpmCounts = new ManageDoctorWorkingHours();
        GetAmpmCounts.readFile("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Doctor.txt");
        counts = GetAmpmCounts.count();

        String column[] = {"Days/Time", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "1:30", "2:00", "2:30", "3:00", "3:30", "4:00"};
        String data[][] = {
                {"Mon", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3"},
                {"Tue", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3"},
                {"Wed", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3"},
                {"Thu", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3"},
                {"Fri", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3", "0/3"}
        };

        int DoctorNotAvailable[][] = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String[] times = {"10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "1:30", "2:00", "2:30", "3:00", "3:30", "4:00"};

        try (FileReader fr = new FileReader("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Selected Appointment.txt");
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 7) {
                    int dayIndex = indexOf(days, values[6]);
                    int timeIndex = indexOf(times, values[5]);
                    if (dayIndex != -1 && timeIndex != -1) {
                        DoctorNotAvailable[dayIndex][timeIndex] += 1;
                    }
                }
            }
        }

        int[] daysIndex = {0, 1, 2, 3, 4};
        int[] amIndex = {1, 2, 3, 4, 5, 6};
        int[] pmIndex = {7, 8, 9, 10, 11, 12};
        for (int d : daysIndex) {
            for (int i : amIndex) {
                String a = Integer.toString(DoctorNotAvailable[d][i-1]);
                String b = Integer.toString(counts[d][0]);
                data[d][i] = a + "/" + b;
            }
            for (int i : pmIndex) {
                String a = Integer.toString(DoctorNotAvailable[d][i-1]);
                String b = Integer.toString(counts[d][1]);
                data[d][i] = a + "/" + b;
            }
        }

        DefaultTableModel model = new DefaultTableModel(data, column);
        jTable1.setModel(model);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Doctor_Timetable().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Doctor_Timetable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
