/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student_Management;

import java.io.Serializable;

/**
 *
 * @author Tuan
 */
public class clsStudent implements Serializable{
    public String EnrolID;
    public String FirstName;
    public String LastName;
    public int Age;

    public clsStudent() {
        EnrolID = "";
        FirstName = "";
        LastName = "";
        Age = 0;
    }

    public clsStudent(String EnrolID, String FirstName, String LastName, int Age) {
        this.EnrolID = EnrolID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Age = Age;
    }

    public void setEnrolID(String EnrolID) {
        this.EnrolID = EnrolID;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getEnrolID() {
        return EnrolID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public int getAge() {
        return Age;
    }
   
    @Override
    public String toString(){
        return "EnrolID: " + EnrolID + ", fullname: " + FirstName + " " + LastName + ", age: " + Age;
    }
}
