
import java.io.*;
import java.util.Arrays;
import javax.swing.JOptionPane;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 60176
 */
public class Select_Appoinment {
    private String docInputIC;

    public Select_Appoinment(String docInputIC) {
        this.docInputIC = docInputIC;
    }

    public static void main(String[] args) {
        // Assuming docInputIC is passed as a command line argument or obtained elsewhere
        if (args.length == 0) {
            System.out.println("Please provide a Patient IC as an argument.");
            return;
        }

        String docInputIC = args[0];
        Select_Appoinment selectAppointment = new Select_Appoinment(docInputIC);
        selectAppointment.processAppointment();
    }

    public void processAppointment() {
        boolean selectedSuccessful = false;
        String docName = null;
        String patientIC = null;
        String patientName = null;
        String patientDisease = null;
        String patientAppointmentMethod = null;
        String patientTime = null;
        String patientDay = null;
        
        String [][] NewAppointmentList = {}; 
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Appointment.txt"))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                count+=1;
                if (docInputIC.equals(values[0])) {
                    patientIC = values[0];
                    patientName = values[1];
                    patientDisease = values[3];
                    patientAppointmentMethod = values[4];
                    patientTime = values[5];
                    patientDay = values[6];
                    count = 0;
                }
                if (count > 0){
                    NewAppointmentList = Arrays.copyOf(NewAppointmentList, NewAppointmentList.length+1);
                    NewAppointmentList[NewAppointmentList.length-1] = values;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading appointment file: " + e.getMessage());
        }
        System.out.println(Arrays.deepToString(NewAppointmentList));
        try (BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Doctor.txt"))) {
            String line2;
            Addition a = new Addition();
            String DocIC = a.read();
            while ((line2 = br2.readLine()) != null) {
                String[] values = line2.split(",");
                if (values[0].equals(DocIC)) {
                    docName = values[1];
                    if (!values[2].equals(patientDay)) {
                        for (int i = 3; i < values.length; i++) { // start from index 3 to skip non-time values
                            if (values[i].equals(patientTime)) {
                                selectedSuccessful = true;
                                System.out.println("Select Successful");
                                break;
                            } else if (values[i] == null) {
                                break;
                            }
                        }
                    }
                }              
            }
          
        } catch (IOException e) {
            System.out.println("Error reading doctor file: " + e.getMessage());
        }

        if (selectedSuccessful) {
            Addition a = new Addition();
            String DocIC = a.read();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Selected Appointment.txt", true))) {
                String sentence = DocIC + "," + docName + "," + patientIC + "," + patientName + "," + patientDisease + "," + patientTime + "," + patientDay + "," + patientAppointmentMethod + "\n";
                bw.write(sentence);
                bw.close();
            } catch (IOException e) {
                System.out.println("Error writing to selected appointment file: " + e.getMessage());
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Appointment.txt", false))) {
                for(int i =0;i <NewAppointmentList.length; i++){
                    String b = String.join(",", NewAppointmentList[i]);
                    bw.write(b+"\n");
                }
            } catch (IOException e) {
                System.out.println("Error writing to selected appointment file: " + e.getMessage());
            }      
        } else {
            System.out.println("Select Unsuccessful");  
        }
    }
}