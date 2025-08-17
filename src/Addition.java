
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 60176
 */

public class Addition {
    public String DocIC;
    
    
    public String read(){
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Login.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                DocIC = line;
                return DocIC;
            }
        } catch (IOException e) {
           System.out.println("Error writing to selected appointment file: " + e.getMessage());
        }
        return null;
    }
    
    public void RegisterToDoctorFile(){
        String[][]temp_ls = {};
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Register.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String [] values = line.split(",");
                if(values[5].equals("Doctor")){
                    temp_ls = Arrays.copyOf(temp_ls, temp_ls.length+1);
                    temp_ls[temp_ls.length-1] = values;
                }
            }
        } catch (IOException e) {
           System.out.println("Error writing to selected appointment file: " + e.getMessage());
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Doctor.txt", false))) {
                for (String[] entry : temp_ls) {
                String[] modifiedEntry = new String[entry.length - 5];
                int index = 0;
                for (int j = 0; j < entry.length; j++) {
                    if (j != 2 && j != 3 && j != 4 && j !=5 &&j!=7 ) {
                        modifiedEntry[index++] = entry[j];
                    }
                }

                if (entry[7].equals("am")) {
                    bw.write(String.join(",", modifiedEntry) + ",10:00,10:30,11:00,11:30,12:00,12:30\n");
                } else {
                    bw.write(String.join(",", modifiedEntry) + ",1:30,2:00,2:30,3:00,3:30,4:00\n");
                }

                System.out.println(Arrays.deepToString(modifiedEntry));
            }
            } catch (IOException e) {
                System.out.println("Error writing to selected appointment file: " + e.getMessage());
            } 
        
    }

    
}
