/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student_Management;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.html.HTML;

/**
 *
 * @author Tuan
 */
public class StudentManagement {
    static ArrayList<clsStudent> listStudent = new ArrayList<>();;
    
    public StudentManagement(){
    }
    
    public static void AddStudent(){
        Scanner input = new Scanner(System.in);
        String EnrolID;
        String FirstName, LastName;
        int Age;
        System.out.println("Enter EnrolID.");
        EnrolID = input.nextLine();
        System.out.println("Enter First Name.");
        FirstName = input.nextLine();
        System.out.println("Enter Last Name.");
        LastName = input.nextLine();
        System.out.println("Enter Age.");
        Age = clsUntilities.InputInt();
        
        clsStudent student = new clsStudent(EnrolID, FirstName, LastName, Age);
        listStudent.add(student);
    }
    
    public static void ReadFile(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("students.dat");
            ois = new ObjectInputStream(fis);
            listStudent.clear();
            int n = ois.readInt();
            for(int i = 0; i < n; i++){
                clsStudent student = (clsStudent) ois.readObject();
                listStudent.add(student);
            }
            System.out.println("Load file success.");
        } catch (FileNotFoundException ex) {
            System.out.println("File not exists.");
            //Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("File opening error.");
            //Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(ois != null) ois.close();
                if(fis != null) fis.close();
            } catch (IOException ex) {
                System.out.println("File closing error");
               // Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void WriteFile(){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("students.dat", false);
            oos = new ObjectOutputStream(fos);
            oos.writeInt(listStudent.size());
            for (clsStudent student : listStudent) {
                oos.writeObject(student);
            }
            System.out.println("Write success.");
        } catch (FileNotFoundException ex) {
            System.out.println("Counld not find file.");
           // Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("File open error.");
           // Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos != null) oos.close();
                if(fos != null) fos.close();
            } catch (IOException ex) {
                System.out.println("File closing error.");
                //Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void DisplayListST(){
        
        if(listStudent.size() > 0){
            int n = listStudent.size();
            System.out.println("Display " + n + " student: ");
            System.out.println("  EnrollID          FullName           Age");
            System.out.println("  ------------     ---------------   --------");
            listStudent.forEach((st) -> {
                System.out.printf("%9s", st.getEnrolID());
                System.out.printf("%20s", st.getLastName() + " " + st.getFirstName());
                System.out.printf("%12d \n", st.getAge());
            });
        }else{}
        
    }
    
    public static int Menu(){
        int select;
        System.out.println("Menu.");
        System.out.println("1.Add new Student.");
        System.out.println("2.Save.");
        System.out.println("3.Display all Student.");
        System.out.println("4.Exit.");
        System.out.println("Enter number from 1 to 4.");
        select = clsUntilities.InputInt();
        return select;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int select;
        String conFirm = "";
        do{
            select = Menu();
            switch(select){
                case 1:
                    AddStudent();
                    break;
                case 2:
                    WriteFile();
                    break;
                case 3:
                    ReadFile();
                    DisplayListST();
                    break;
                case 4:
                    System.out.println("Goodbye.");
                    System.exit(0);
                default:
                    System.out.println("Please enter number from 1 to 4.");
            }
            System.out.println("Are you to continue.");
            conFirm = input.nextLine();
        }while(conFirm.equalsIgnoreCase("yes")); 
    }
}
