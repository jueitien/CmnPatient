/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 60176
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ManageDoctorWorkingHours {
    
    String[] Mon_available_slot = {};
    String[] Tue_available_slot = {};
    String[] Wed_available_slot = {};
    String[] Thu_available_slot = {};
    String[] Fri_available_slot = {};
    
    public static String[] append(String[] day, String AmPm) {
        day = Arrays.copyOf(day, day.length + 1);
        day[day.length - 1] = AmPm;
        return day;
    }
    
    public int[][] count(){
        String[][] Days = {Mon_available_slot,Tue_available_slot,Wed_available_slot,Thu_available_slot,Fri_available_slot};
        int[][] counts = new int[Days.length][2];
        
        int Counter = -1;
        for (String[] daySlots : Days) {
            Counter+=1;
            int amCount = 0;
            int pmCount = 0;
            for (String slot : daySlots) {
                if(slot.equals("am")){
                   amCount+=1; 
                }else{
                    pmCount+=1;
                }
            }   
            counts[Counter][0] = amCount;
            counts[Counter][1] = pmCount;
        }
        return counts;
    }
    
    
    public static void main(String[] args) throws IOException {
        ManageDoctorWorkingHours manageDoctorWorkingHours = new ManageDoctorWorkingHours();
        manageDoctorWorkingHours.readFile("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Doctor.txt");
        
        // Access the instance variables
        System.out.println("Monday slots: " + Arrays.toString(manageDoctorWorkingHours.Mon_available_slot));
        System.out.println("Tuesday slots: " + Arrays.toString(manageDoctorWorkingHours.Tue_available_slot));
        System.out.println("Wednesday slots: " + Arrays.toString(manageDoctorWorkingHours.Wed_available_slot));
        System.out.println("Thursday slots: " + Arrays.toString(manageDoctorWorkingHours.Thu_available_slot));
        System.out.println("Friday slots: " + Arrays.toString(manageDoctorWorkingHours.Fri_available_slot));
        
    }
    
    public void readFile(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line;
        
        while ((line = br.readLine()) != null) {
            String[] array = line.split(",");
            switch (array[2]) {
                case "Monday" -> {
                    if (array[3].equals("10:00")) {
                        Tue_available_slot = append(Tue_available_slot, "am");
                        Wed_available_slot = append(Wed_available_slot, "am");
                        Thu_available_slot = append(Thu_available_slot, "am");
                        Fri_available_slot = append(Fri_available_slot, "am");
                    } else {
                        Tue_available_slot = append(Tue_available_slot, "pm");
                        Wed_available_slot = append(Wed_available_slot, "pm");
                        Thu_available_slot = append(Thu_available_slot, "pm");
                        Fri_available_slot = append(Fri_available_slot, "pm");
                    }
                }
                case "Tuesday" -> {
                    if (array[3].equals("10:00")) {
                        Mon_available_slot = append(Mon_available_slot, "am");
                        Wed_available_slot = append(Wed_available_slot, "am");
                        Thu_available_slot = append(Thu_available_slot, "am");
                        Fri_available_slot = append(Fri_available_slot, "am");
                    } else {
                        Mon_available_slot = append(Mon_available_slot, "pm");
                        Wed_available_slot = append(Wed_available_slot, "pm");
                        Thu_available_slot = append(Thu_available_slot, "pm");
                        Fri_available_slot = append(Fri_available_slot, "pm");
                    }
                }
                case "Wednesday" -> {
                    if (array[3].equals("10:00")) {
                        Tue_available_slot = append(Tue_available_slot, "am");
                        Mon_available_slot = append(Mon_available_slot, "am");
                        Thu_available_slot = append(Thu_available_slot, "am");
                        Fri_available_slot = append(Fri_available_slot, "am");
                    } else {
                        Tue_available_slot = append(Tue_available_slot, "pm");
                        Mon_available_slot = append(Mon_available_slot, "pm");
                        Thu_available_slot = append(Thu_available_slot, "pm");
                        Fri_available_slot = append(Fri_available_slot, "pm");
                    }
                }
                case "Thursday" -> {
                    if (array[3].equals("10:00")) {
                        Tue_available_slot = append(Tue_available_slot, "am");
                        Wed_available_slot = append(Wed_available_slot, "am");
                        Mon_available_slot = append(Mon_available_slot, "am");
                        Fri_available_slot = append(Fri_available_slot, "am");
                    } else {
                        Tue_available_slot = append(Tue_available_slot, "pm");
                        Wed_available_slot = append(Wed_available_slot, "pm");
                        Mon_available_slot = append(Mon_available_slot, "pm");
                        Fri_available_slot = append(Fri_available_slot, "pm");
                    }
                }
                case "Friday" -> {
                    if (array[3].equals("10:00")) {
                        Tue_available_slot = append(Tue_available_slot, "am");
                        Wed_available_slot = append(Wed_available_slot, "am");
                        Thu_available_slot = append(Thu_available_slot, "am");
                        Mon_available_slot = append(Mon_available_slot, "am");
                    } else {
                        Tue_available_slot = append(Tue_available_slot, "pm");
                        Wed_available_slot = append(Wed_available_slot, "pm");
                        Thu_available_slot = append(Thu_available_slot, "pm");
                        Mon_available_slot = append(Mon_available_slot, "pm");
                    }
                }
                default -> {
                }
            }
        }
        br.close();
        fr.close();
    }
}
