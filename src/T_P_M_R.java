
import java.io.BufferedReader;
import java.io.FileReader;
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
public class T_P_M_R {
    String [] Current_login_info;
    public T_P_M_R(String[] array){
        this.Current_login_info = array;
    
    }
    
    
    String [][] Personal_record={};
    public void readfile() throws IOException{
        FileReader fr =new FileReader("C:\\Users\\GF63\\OneDrive - Asia Pacific University\\desktop\\txt file\\Patient History.txt");
        BufferedReader br= new BufferedReader(fr);
        String line;
        while ((line=br.readLine())!=null){
            String[] record=line.split(",");
            if(record[2].equals(Current_login_info[0])&& record[3].equals(Current_login_info[1])){
                Personal_record=Arrays.copyOf(Personal_record, Personal_record.length+1);
                Personal_record[Personal_record.length-1]=new String[]{record[0],record[1],record[4],record[5],record[6],record[7],record[8]};
            
            } 
        }
        System.out.println(Arrays.deepToString(Personal_record));
    
    }
    public static void main(String[] args) throws IOException {
        T_P_M_R  T_P_M_R =new T_P_M_R(null);
        T_P_M_R.readfile();
    }
}
