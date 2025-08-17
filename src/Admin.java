
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TAN JUN HONG
 */

public class Admin {
    public static void main(String[] args) throws IOException{
        System.out.println("Welcome to Admin System");
        File Register = new File("Register.txt");
        FileWriter fw = new FileWriter(Register,true);
        BufferedWriter bw = new BufferedWriter(fw);
        String Name;
        String Ic;
        String Contact;
        String email;
        String password;
        String[] role = {"Admin","Doctor","Patient"};
        int roleIndex = -1;
        
        
        
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("Please Enter Your IC (12 digits):");
            Ic = sc.nextLine();
            if (Ic.length() == 12 && Ic.chars().allMatch(Character::isDigit)) {
                break;
            } else {
                System.out.println("IC digit number error. Please type it again.");
            }
        }
        
        
        System.out.println("Please Enter Your Name:");
        Name = sc.nextLine();
        
        System.out.println("Please Enter Your Contact:");
        Contact = sc.nextLine();
        
        System.out.println("Please Enter Your email:");
        email = sc.nextLine(); 
        
        System.out.println("Please Enter Your Password:");
        password = sc.nextLine();
        System.out.println("Please Select Your role:");
        
        while (roleIndex < 0 || roleIndex > 2){
        System.out.println("1[Admin],2[Doctor],3[Patient]");
        if(sc.hasNextInt()){
          roleIndex = sc.nextInt()-1;
            
    }
    }
        
        
        System.out.println("Welcome, " + Name + "!");
        System.out.println("Your IC is: " + Ic);
        System.out.println("Your Password is: " + password); 
        System.out.println("Your Contact is: " + Contact); 
        System.out.println("Your email is:" + email );
        System.out.println("Role:" + role[roleIndex]);
        bw.write(Ic+","+ Name +","+ Contact +","+ email +","+ password +","+ role[roleIndex]);
        bw.close();
        fw.close();
       
        
        
    }
}
   
