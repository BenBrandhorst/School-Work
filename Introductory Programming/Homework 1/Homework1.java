/*
 * File: Homework1.java Author: Ben Brandhorst 
 * Date: October 30, 2018 
 * Purpose: This program demonstrates the requisite inputs, outputs, and calculations for the homework assignment which includes
 * storing user inputs for student id, several quizes, age, and temperature. The program then performs various simple calculations and returns 
 * both the original input and the calculated changes. 
 */

// Import each required Java class

public class Homework1 {
  public static void main(String[] args) throws IOException {

    // Variables to hold values
    int empId = 0;
    double quiz1 = 0.0;
    double quiz2 = 0.0;
    double quiz3 = 0.0;
    int usrAge = 0;
    int usrYears = 0;
    double cTemp = 0.0;
    double fTemp = 0.0;
    double avgQuiz = 0.0;
    final String DEGREE = "\u00b0"; // unicode character for the degree symbol

    // Define a InputStreamReader based on Standard Input (System.in)
    InputStreamReader isReader = new InputStreamReader(System.in);
    // Send the InputStreamReader to a BufferedReader
    BufferedReader stdin = new BufferedReader(isReader);

    // Prompt the user to enter an employee ID
    System.out.println("Please enter your student EMPLID: (0-999999):");
    // Convert the entered value to an int
    empId = Integer.parseInt(stdin.readLine());

    // Prompt the user to enter a quiz score
    System.out.println("Enter your quiz1 percentage score (0-100.0):");
    // Read the line and convert to a double
    quiz1 = Double.parseDouble(stdin.readLine());

    // Prompt the user to enter a second quiz score
    System.out.println("Enter your quiz2 percentage score (0-100.0):");
    // Read the line and convert to a double
    quiz2 = Double.parseDouble(stdin.readLine());

    // Prompt the user to enter a third quiz score
    System.out.println("Enter your quiz3 percentage score (0-100.0):");
    // Read the line and convert to a double
    quiz3 = Double.parseDouble(stdin.readLine());

    // Prompt the user to enter an age
    System.out.println("Enter your age in months (0-1440):");
    // Read the line and convert to a int
    usrAge = Integer.parseInt(stdin.readLine());

    // Prompt the user to enter the temperature in Celsius
    System.out.println("Enter the temperature in degrees Celsius:");
    // Read the line and convert to a double
    cTemp = Double.parseDouble(stdin.readLine());

    // Display the stored values for user inputs EMPLID and quiz 1 through 3
    System.out.println("Thank You For Your Inputs!");
    System.out.println("Your student EMPLID: is: " + empId);
    System.out.println("Your quiz 1 score is: " + quiz1);
    System.out.println("Your quiz 2 score is: " + quiz2);
    System.out.println("Your quiz 3 score is: " + quiz3);

    // Calculate the average of the three quiz inputs
    avgQuiz = (quiz1 + quiz2 + quiz3) / 3;
    System.out.println("Your average quiz score is: " + avgQuiz);

    // Read back user input age in months and convert age to years
    usrYears = (usrAge / 12);
    System.out.println("Your age in months is: " + usrAge);
    System.out.println("Your age in years is: " + usrYears);

    // Display user input temperature in Celcius and convert to Fahrenheit
    fTemp = (cTemp * 1.8) + 32;
    System.out.println("The temperature in Celsius is: " + cTemp + DEGREE);
    System.out.println("The temperature in Fahrenheit is: " + fTemp + DEGREE);

  }
}
