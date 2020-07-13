package finalProject;
import java.util.*;
/*
 * File: ProjectFrontEndjava 
 * Author: Ben Brandhorst 
 * Date: December 15th, 2018 
 * Purpose: CMIS 141 Final Project. Contains menu items for project.
 * 
 */
public class ProjectFrontEnd {

  public void frontEnd(String[] args) {
    // variable to hold keyboard input
    String setting;
    
    System.out.println(
        "********** Welcome to the US Crime Statistical Application **************************");
    System.out.println("");
    System.out.println(
        "Enter the number of the question you want answered. Enter ‘Q’ to quit the program :");
    System.out.println("");
    System.out.println(
        "1. What were the percentages in population growth for each consecutive year from 1994 – 2013?");
    System.out.println("2. What year was the Murder rate the highest?");
    System.out.println("3. What year was the Murder rate the lowest?");
    System.out.println("4. What year was the Robbery rate the highest?");
    System.out.println("5. What year was the Robbery rate the lowest?");
    System.out.println("6. What year was the Motor Vehicle Theft rate the highest?");
    System.out.println("7. What year was the Motor Vehicle Theft rate the lowest?");
    System.out.println("Q. Quit the program");
    System.out.println("");
    System.out.print("Enter your selection: ");
    Scanner keyboard = new Scanner(System.in);
    setting = keyboard.next();


    // while loop keeps prompting user for input until they select a valid input
    while (!setting.matches("(q|Q)")) {

      if (setting.equals("1")) {
        // If user inputs '1' populationGrowth method is called from CrimeUS Class and user is
        // prompted to continue

        CrimeUS.populationGrowth();
        System.out.println("");
        System.out.println(
            "Enter the number of the question you want answered. Enter ‘Q’ to quit the program :");
        System.out.println("");
        System.out.println(
            "1. What were the percentages in population growth for each consecutive year from 1994 – 2013?");
        System.out.println("2. What year was the Murder rate the highest?");
        System.out.println("3. What year was the Murder rate the lowest?");
        System.out.println("4. What year was the Robbery rate the highest?");
        System.out.println("5. What year was the Robbery rate the lowest?");
        System.out.println("6. What year was the Motor Vehicle Theft rate the highest?");
        System.out.println("7. What year was the Motor Vehicle Theft rate the lowest?");
        System.out.println("Q. Quit the program");
        System.out.println("");
        System.out.print("Enter your selection: ");
        
        setting = keyboard.next();
     
      // If user inputs '2' maxMurder method is called from CrimeUS Class and user is prompted to
      // continue
      } else if (setting.equals("2")) {
        CrimeUS.maxMurder();
        System.out.println("");
        System.out.println(
            "Enter the number of the question you want answered. Enter ‘Q’ to quit the program :");
        System.out.println("");
        System.out.println(
            "1. What were the percentages in population growth for each consecutive year from 1994 – 2013?");
        System.out.println("2. What year was the Murder rate the highest?");
        System.out.println("3. What year was the Murder rate the lowest?");
        System.out.println("4. What year was the Robbery rate the highest?");
        System.out.println("5. What year was the Robbery rate the lowest?");
        System.out.println("6. What year was the Motor Vehicle Theft rate the highest?");
        System.out.println("7. What year was the Motor Vehicle Theft rate the lowest?");
        System.out.println("Q. Quit the program");
        System.out.println("");
        System.out.print("Enter your selection: ");
   
        setting = keyboard.next();
      
      // If user inputs '3' minMurder method is called and user is prompted to continue
      } else if (setting.equals("3")) {
        CrimeUS.minMurder();
        System.out.println("");
        System.out.println(
            "Enter the number of the question you want answered. Enter ‘Q’ to quit the program :");
        System.out.println("");
        System.out.println(
            "1. What were the percentages in population growth for each consecutive year from 1994 – 2013?");
        System.out.println("2. What year was the Murder rate the highest?");
        System.out.println("3. What year was the Murder rate the lowest?");
        System.out.println("4. What year was the Robbery rate the highest?");
        System.out.println("5. What year was the Robbery rate the lowest?");
        System.out.println("6. What year was the Motor Vehicle Theft rate the highest?");
        System.out.println("7. What year was the Motor Vehicle Theft rate the lowest?");
        System.out.println("Q. Quit the program");
        System.out.println("");
        System.out.print("Enter your selection: ");
      
        setting = keyboard.next();
        // If user inputs '4' robMax method is called from CrimeUS Class and user is prompted to
        // continue
      } else if (setting.equals("4")) {
        CrimeUS.robMax();
        System.out.println("");
        System.out.println(
            "Enter the number of the question you want answered. Enter ‘Q’ to quit the program :");
        System.out.println("");
        System.out.println(
            "1. What were the percentages in population growth for each consecutive year from 1994 – 2013?");
        System.out.println("2. What year was the Murder rate the highest?");
        System.out.println("3. What year was the Murder rate the lowest?");
        System.out.println("4. What year was the Robbery rate the highest?");
        System.out.println("5. What year was the Robbery rate the lowest?");
        System.out.println("6. What year was the Motor Vehicle Theft rate the highest?");
        System.out.println("7. What year was the Motor Vehicle Theft rate the lowest?");
        System.out.println("Q. Quit the program");
        System.out.println("");
        System.out.print("Enter your selection: ");
   
        setting = keyboard.next();
        // If user inputs '5' robMin method is called from CrimeUS Class and user is prompted to
        // continue
      } else if (setting.equals("5")) {
        CrimeUS.robMin();
        System.out.println("");
        System.out.println(
            "Enter the number of the question you want answered. Enter ‘Q’ to quit the program :");
        System.out.println("");
        System.out.println(
            "1. What were the percentages in population growth for each consecutive year from 1994 – 2013?");
        System.out.println("2. What year was the Murder rate the highest?");
        System.out.println("3. What year was the Murder rate the lowest?");
        System.out.println("4. What year was the Robbery rate the highest?");
        System.out.println("5. What year was the Robbery rate the lowest?");
        System.out.println("6. What year was the Motor Vehicle Theft rate the highest?");
        System.out.println("7. What year was the Motor Vehicle Theft rate the lowest?");
        System.out.println("Q. Quit the program");
        System.out.println("");
        System.out.print("Enter your selection: ");
      
        setting = keyboard.next();
        // If user inputs '6' carTheftMax method is called from CrimeUS Class and user is prompted
        // to continue
      } else if (setting.equals("6")) {
        CrimeUS.carTheftMax();
        System.out.println("");
        System.out.println(
            "Enter the number of the question you want answered. Enter ‘Q’ to quit the program :");
        System.out.println("");
        System.out.println(
            "1. What were the percentages in population growth for each consecutive year from 1994 – 2013?");
        System.out.println("2. What year was the Murder rate the highest?");
        System.out.println("3. What year was the Murder rate the lowest?");
        System.out.println("4. What year was the Robbery rate the highest?");
        System.out.println("5. What year was the Robbery rate the lowest?");
        System.out.println("6. What year was the Motor Vehicle Theft rate the highest?");
        System.out.println("7. What year was the Motor Vehicle Theft rate the lowest?");
        System.out.println("Q. Quit the program");
        System.out.println("");
        System.out.print("Enter your selection: ");
  
        setting = keyboard.next();
        // If user inputs '7' carTheftMin method is called from CrimeUS Class and user is prompted
        // to continue
      } else if (setting.equals("7")) {
        CrimeUS.carTheftMin();
        System.out.println("");
        System.out.println(
            "Enter the number of the question you want answered. Enter ‘Q’ to quit the program :");
        System.out.println("");
        System.out.println(
            "1. What were the percentages in population growth for each consecutive year from 1994 – 2013?");
        System.out.println("2. What year was the Murder rate the highest?");
        System.out.println("3. What year was the Murder rate the lowest?");
        System.out.println("4. What year was the Robbery rate the highest?");
        System.out.println("5. What year was the Robbery rate the lowest?");
        System.out.println("6. What year was the Motor Vehicle Theft rate the highest?");
        System.out.println("7. What year was the Motor Vehicle Theft rate the lowest?");
        System.out.println("Q. Quit the program");
        System.out.println("");
        System.out.print("Enter your selection: ");

        setting = keyboard.next();
        // If user inputs anything else error message is displayed and they are prompted to continue
      } else {
        System.out.println("");
        System.out.println("You have entered invalid input. Please try again.");
        System.out.println("");
        System.out.println(
            "Enter the number of the question you want answered. Enter ‘Q’ to quit the program :");
        System.out.println("");
        System.out.println(
            "1. What were the percentages in population growth for each consecutive year from 1994 – 2013?");
        System.out.println("2. What year was the Murder rate the highest?");
        System.out.println("3. What year was the Murder rate the lowest?");
        System.out.println("4. What year was the Robbery rate the highest?");
        System.out.println("5. What year was the Robbery rate the lowest?");
        System.out.println("6. What year was the Motor Vehicle Theft rate the highest?");
        System.out.println("7. What year was the Motor Vehicle Theft rate the lowest?");
        System.out.println("Q. Quit the program");
        System.out.println("");
        System.out.print("Enter your selection: ");
     
        setting = keyboard.next();
      }
    }
    // loop is broken once user inputs 'q' or 'Q' and message is displayed
    System.out.println("");
    System.out.println("Thank you for trying the US Crimes Statistics Program.");
  }
}


