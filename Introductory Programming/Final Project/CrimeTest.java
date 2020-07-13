package finalProject;
import java.util.*;
/*
 * File: CrimeUS.java 
 * Author: Ben Brandhorst 
 * Date: December 15th, 2018 
 * Purpose: CMIS 141 Final Project. Calls methods from other two classes to run program. 
 * 
 */



public class CrimeTest {
  public static void main(String[] args) {
    // starts time calculation in nanoseconds
    final long timeStart = System.nanoTime();
    // Create Crime US and ProjectFrontEnd objects
    CrimeUS crimeUS1 = new CrimeUS();
    ProjectFrontEnd frontEnd1 = new ProjectFrontEnd();
    // Call on readFiles method contained in CrimeUS
    crimeUS1.readFiles(args);
    // Call on frontEnd method contained in ProjectFrontEnd
    frontEnd1.frontEnd(args);

    // stores the nanoseconds elapsed since program start
    final long duration = System.nanoTime() - timeStart;
    // converts nanoseconds into seconds
    long totalTime = (duration / 1000000000);
    // prints the time elapsed in seconds
    System.out.println("");
    System.out.println("Elapsed time in seconds was: " + totalTime);
  }
}

