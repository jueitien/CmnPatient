
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author GF63
 */
public class CancelBooking {
    String [][] User_Appointment={};
    String [][] Whole_data={};
    String [] Current_login_info;
    public CancelBooking(String[] Array){
        this.Current_login_info = Array;
    }
    
    
    public void readfile() throws IOException{
        FileReader fr = new FileReader("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Appointment.txt");
        BufferedReader br= new BufferedReader(fr);
        String line = null;
        while ((line = br.readLine()) != null) {
            String [] array=line.split(",");
            
            if (array[0].equals(Current_login_info[0])) {
                User_Appointment=Arrays.copyOf(User_Appointment,User_Appointment.length+1);
                User_Appointment[User_Appointment.length-1]=new String []{array[1],array[5],array[6],"Delete"};
                Whole_data=Arrays.copyOf(Whole_data,Whole_data.length+1);
                Whole_data[Whole_data.length-1]=array;
            }
        }        
    }  
    
    public void rewrite(int index) throws IOException{
        readfile();
        String [][] Temp_data={};
        //System.out.println(Arrays.deepToString(Whole_data));
        for(int i=0;i<Whole_data.length;i++){
            if(i!=index){
                Temp_data=Arrays.copyOf(Temp_data,Temp_data.length+1);
                Temp_data[Temp_data.length-1]=Whole_data[i];
            }
        }
        FileReader fR = new FileReader("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Appointment.txt");
        BufferedReader bR= new BufferedReader(fR);
        String lines = null;
        while ((lines = bR.readLine()) != null) {
            String [] arrays=lines.split(",");
            if (!arrays[0].equals(Current_login_info[0])) {  
                Temp_data=Arrays.copyOf(Temp_data,Temp_data.length+1);
                Temp_data[Temp_data.length-1]=arrays;
            } 
        }
        fR.close();
        bR.close();
        FileWriter fw = new FileWriter("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Appointment.txt", false);
        BufferedWriter bw = new BufferedWriter(fw);
        
        Whole_data=Temp_data;
        for (int i = 0; i < Whole_data.length; i++) {
            String a= String.join(",",Whole_data[i]);
            bw.write(a+"\n");
        }
        
        bw.close();
        fw.close();
    }
    
    
    
    public static void main(String[] args) throws IOException {
        CancelBooking CancelBooking=new CancelBooking(null);
        CancelBooking.rewrite(0);

    }


}
    
