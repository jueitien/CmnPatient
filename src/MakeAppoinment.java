
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author GF63
 */
public class MakeAppoinment {    
    int[][] All_app;
    boolean Appointment_Status;

    public void readfile() throws IOException{
        View_Available_Time_Slot a= new View_Available_Time_Slot();
        a.readfile();
        a.readappointment();
        All_app=new int[][] {a.Mon_appointmented,a.Tue_appointmented,a.Wed_appointmented,a.Thu_appointmented,a.Fri_appointmented};
    }
    
    
    
    //String Book_day,String Book_time
    public void Booking_check(String Book_day,String Book_time,String disease,String [] array) throws IOException{
        readfile();
        View_Available_Time_Slot a= new View_Available_Time_Slot();
        a.readfile();
        a.readappointment();
        int [][] available_time = a.available_time;
        int[][] All_apps=All_app;
        for(int i=0;i<All_apps.length;i++){
           for(int z=0;z<All_apps[i].length;z++){
                if(z<=6 && All_apps[i][z]<available_time[i][0] && a.all_day[i].equals(Book_day) && a.all_time[z].equals(Book_time)){
                   All_app[i][z]=All_apps[i][z]+=1;
                   //System.out.println(All_apps[i][z]);
                   //System.out.println(Arrays.toString(All_apps[0]));
                   FileWriter fw = new FileWriter("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Appointment.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(array[0]+","+array[1]+","+array[2]+","+disease+",book," + Book_time + "," + Book_day + "\n");
                    bw.close();
                    Appointment_Status=true;
                    return;
                }else if(z>6 && All_apps[i][z]<available_time[i][0] && a.all_day[i].equals(Book_day) && a.all_time[z].equals(Book_time)){
                    All_app[i][z]=All_apps[i][z]+=1;
                   //System.out.println(All_apps[i][z]);
                   //System.out.println(Arrays.toString(All_apps[0]));
                    FileWriter fw = new FileWriter("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Appointment.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                   bw.write(array[0]+","+array[1]+","+array[2]+","+disease+",book," + Book_time + "," + Book_day + "\n");
                    bw.close();
                    Appointment_Status=true;
                    return;
                }else{
                    Appointment_Status=false;
                }
                    
                
            }
        }
        
        

     }
    
    
    
     public static void main(String[] args) throws IOException{
        MakeAppoinment MakeAppoinment=new MakeAppoinment();
        
     
     }

}
