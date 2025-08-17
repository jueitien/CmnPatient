/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author GF63
 */
import java.io.*;
import java.util.Arrays;

public class View_Available_Time_Slot {

    String [] Mon_available_slot = {};
    String [] Tue_available_slot = {};
    String [] Wed_available_slot = {};
    String [] Thu_available_slot = {};
    String [] Fri_available_slot = {};
    
    
    int  Mon_am_available_slot = 0;
    int  Tue_am_available_slot = 0;
    int  Wed_am_available_slot = 0;
    int  Thu_am_available_slot = 0;
    int  Fri_am_available_slot = 0;
    
    int  Mon_pm_available_slot = 0;
    int  Tue_pm_available_slot = 0;
    int  Wed_pm_available_slot = 0;
    int  Thu_pm_available_slot = 0;
    int  Fri_pm_available_slot = 0;
    
    int[][] available_time = new int[5][2];
    String[] all_day= {"Monday","Tuesday","Wednesday","Thursday","Friday"};
    String[] all_time= {"10:00","10:30","11:00","11:30","12:00","12:30","1:30","2:00","2:30","3:00","3:30","4:00"};
    public int[] Mon_appointmented={0,0,0,0,0,0,0,0,0,0,0,0};
    int[] Tue_appointmented={0,0,0,0,0,0,0,0,0,0,0,0};
    int[] Wed_appointmented={0,0,0,0,0,0,0,0,0,0,0,0};
    int[] Thu_appointmented={0,0,0,0,0,0,0,0,0,0,0,0};
    int[] Fri_appointmented={0,0,0,0,0,0,0,0,0,0,0,0};
    String day_time[][]= new String[0][2];   
    
    static String[] append(String[] day,String AmPm){
        day =Arrays.copyOf(day,day.length+1);
        day[day.length-1] = AmPm;
        return day;
    }
    
    static int[] times(String[] day) {
        int Times_am = 0;
        int Times_pm = 0;
        for (String s : day) {
            if (s.equals("am")) {
                Times_am++;
            } else {
                Times_pm++;
            }
        }
        int[] sb = {Times_am, Times_pm};
        return sb;
    }

  
    public void readfile() throws IOException{
        FileReader fr = new FileReader("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Doctor.txt");
        BufferedReader br= new BufferedReader(fr);
        String line = null;
        

        while((line = br.readLine()) != null){
            String[] array = line.split(",");
            if (array[2].equals("Monday")){
                if(array[3].equals("10:00")){
                    Tue_available_slot = append(Tue_available_slot,"am");
                    Wed_available_slot = append(Wed_available_slot,"am");
                    Thu_available_slot = append(Thu_available_slot,"am");
                    Fri_available_slot = append(Fri_available_slot,"am");
                }
                else{
                    Tue_available_slot = append(Tue_available_slot,"pm");
                    Wed_available_slot = append(Wed_available_slot,"pm");
                    Thu_available_slot = append(Thu_available_slot,"pm");
                    Fri_available_slot = append(Fri_available_slot,"pm");
                }
                
            }else if (array[2].equals("Tuesday")){
                if(array[3].equals("10:00")){
                    Mon_available_slot = append(Mon_available_slot,"am");
                    Wed_available_slot = append(Wed_available_slot,"am");
                    Thu_available_slot = append(Thu_available_slot,"am");
                    Fri_available_slot = append(Fri_available_slot,"am");
                }
                else{
                    Mon_available_slot = append(Mon_available_slot,"pm");
                    Wed_available_slot = append(Wed_available_slot,"pm");
                    Thu_available_slot = append(Thu_available_slot,"pm");
                    Fri_available_slot = append(Fri_available_slot,"pm");
                }
                
            }else if (array[2].equals("Wednesday")){
                if(array[3].equals("10:00")){
                    Tue_available_slot = append(Tue_available_slot,"am");
                    Mon_available_slot = append(Mon_available_slot,"am");
                    Thu_available_slot = append(Thu_available_slot,"am");
                    Fri_available_slot = append(Fri_available_slot,"am");
                }
                else{
                    Tue_available_slot = append(Tue_available_slot,"pm");
                    Mon_available_slot = append(Mon_available_slot,"pm");
                    Thu_available_slot = append(Thu_available_slot,"pm");
                    Fri_available_slot = append(Fri_available_slot,"pm");
                }
                
            }else if (array[2].equals("Thursday")){
                if(array[3].equals("10:00")){
                    Tue_available_slot = append(Tue_available_slot,"am");
                    Wed_available_slot = append(Wed_available_slot,"am");
                    Mon_available_slot = append(Mon_available_slot,"am");
                    Fri_available_slot = append(Fri_available_slot,"am");
                }
                else{
                    Tue_available_slot = append(Tue_available_slot,"pm");
                    Wed_available_slot = append(Wed_available_slot,"pm");
                    Mon_available_slot = append(Mon_available_slot,"pm");
                    Fri_available_slot = append(Fri_available_slot,"pm");
                }
                
            }else if (array[2].equals("Friday")){
                if(array[3].equals("10:00")){
                    Tue_available_slot = append(Tue_available_slot,"am");
                    Wed_available_slot = append(Wed_available_slot,"am");
                    Thu_available_slot = append(Thu_available_slot,"am");
                    Mon_available_slot = append(Mon_available_slot,"am");
                }
                else{
                    Tue_available_slot = append(Tue_available_slot,"pm");
                    Wed_available_slot = append(Wed_available_slot,"pm");
                    Thu_available_slot = append(Thu_available_slot,"pm");
                    Mon_available_slot = append(Mon_available_slot,"pm");
                }
                
            }
            
        }
        int[] Mon_counts = times(Mon_available_slot);
        Mon_am_available_slot = Mon_counts[0];
        Mon_pm_available_slot = Mon_counts[1];

        int[] Tue_counts = times(Tue_available_slot);
        Tue_am_available_slot = Tue_counts[0];
        Tue_pm_available_slot = Tue_counts[1];

        int[] Wed_counts = times(Wed_available_slot);
        Wed_am_available_slot = Wed_counts[0];
        Wed_pm_available_slot = Wed_counts[1];

        int[] Thu_counts = times(Thu_available_slot); 
        Thu_am_available_slot = Thu_counts[0];
        Thu_pm_available_slot = Thu_counts[1];

        int[] Fri_counts = times(Fri_available_slot);
        Fri_am_available_slot = Fri_counts[0];
        Fri_pm_available_slot = Fri_counts[1];
        
        available_time= new int[][]{{Mon_am_available_slot,Mon_pm_available_slot},
        {Tue_am_available_slot,Tue_pm_available_slot},
        {Wed_am_available_slot,Wed_pm_available_slot},
        {Thu_am_available_slot,Thu_pm_available_slot},
        {Fri_am_available_slot,Fri_pm_available_slot}};

    
    }
      
    public void readappointment() throws IOException{
        FileReader fr = new FileReader("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Appointment.txt");
        BufferedReader br= new BufferedReader(fr);
        String line=null;
        while((line = br.readLine()) != null){
            String[] app_array = line.split(",");
            day_time =Arrays.copyOf(day_time,day_time.length+1);
            day_time[day_time.length-1] =new String[]{app_array[5],app_array[6]};
        }
        br.close();
        fr.close();

        //System.out.println(Arrays.deepToString(day_time));

        for(int a=0;a<all_time.length;a++){
            for(int i=0;i<day_time.length;i++){
                if(day_time[i][0].equals(all_time[a])&&day_time[i][1].equals("Monday")){
                    Mon_appointmented[a]++;
                }
                else if(day_time[i][0].equals(all_time[a])&&day_time[i][1].equals("Tuesday")){
                    Tue_appointmented[a]++;
                }
                else if(day_time[i][0].equals(all_time[a])&&day_time[i][1].equals("Wednesday")){
                    Wed_appointmented[a]++;
                }
                else if(day_time[i][0].equals(all_time[a])&&day_time[i][1].equals("Thursday")){
                    Thu_appointmented[a]++;
                }
                else if(day_time[i][0].equals(all_time[a])&&day_time[i][1].equals("Friday")){
                    Fri_appointmented[a]++;
                }
            }
        }
        day_time=new String[0][2];
        
        
        FileReader fr1 = new FileReader("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Selected Appointment.txt");
        BufferedReader br1= new BufferedReader(fr1);
        String lines=null;
        while((lines = br1.readLine()) != null){
            String[] app_array = lines.split(",");
            day_time =Arrays.copyOf(day_time,day_time.length+1);
            day_time[day_time.length-1] =new String[]{app_array[5],app_array[6]};
        }
        br1.close();
        fr1.close();

        //System.out.println(Arrays.deepToString(day_time));

        for(int a=0;a<all_time.length;a++){
            for(int i=0;i<day_time.length;i++){
                if(day_time[i][0].equals(all_time[a])&&day_time[i][1].equals("Monday")){
                    Mon_appointmented[a]++;
                }
                else if(day_time[i][0].equals(all_time[a])&&day_time[i][1].equals("Tuesday")){
                    Tue_appointmented[a]++;
                }
                else if(day_time[i][0].equals(all_time[a])&&day_time[i][1].equals("Wednesday")){
                    Wed_appointmented[a]++;
                }
                else if(day_time[i][0].equals(all_time[a])&&day_time[i][1].equals("Thursday")){
                    Thu_appointmented[a]++;
                }
                else if(day_time[i][0].equals(all_time[a])&&day_time[i][1].equals("Friday")){
                    Fri_appointmented[a]++;
                }
            }
        }
        
        
    }
    
    public static void main(String[] args) throws IOException{
        View_Available_Time_Slot a= new View_Available_Time_Slot();
        a.readfile();
        int[] z =a.Mon_appointmented;
        int[] y =a.Tue_appointmented;
        int num=a.Mon_pm_available_slot;
        String [] b = a.Mon_available_slot;
        a.readappointment();
        System.out.println(Arrays.deepToString(a.available_time));

    }
}
