/*
 * File: Student.java
 * Author: Ben Brandhorst
 * Date: May 10th, 2019
 * Purpose: CMIS 242 Project 4- Manage a student database
 */
package project4;

public class Student {

  //variables to hold data
  private String studentName;
  private String major;
  private int credits;//number of credits
  private double quality;//numeric value of grade received times the number of credit hours
  private double gpa = 4.0;

  //constructor with name and major accepted as parameters
  Student(String studentName, String major) {
    this.studentName = studentName;
    this.major = major;
    //initialized fields used to compute GPA to zero
    credits = 0;
    quality = 0;
  }

  //accepts course grade and credit hours as parameters and updates variables to compute GPA
  void courseCompleted(double numericGrade, int hours) {
    // calculates numeric value of grade multiplied by number of credit hours
    numericGrade = numericGrade * hours;
    // calculates quality points
    quality = numericGrade + quality;
    // calculates credit hours
    credits = hours + credits;
    // calculates gpa
    gpa = quality / credits;
  }

  //overrides toString and returns labeled string containing student name, major, and gpa.
  public String toString() {
    return ("Student Name: " + studentName + "\nMajor: " + major + "\nGrade Point Average: "
        + String.format("%.1f", gpa)); // returns gpa displayed to one point right of decimal
  }


}
