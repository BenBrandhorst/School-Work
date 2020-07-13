/*
 * File: TestHeadPhone.java 
 * Author: Ben Brandhorst 
 * Date: November 27, 2018 
 * Purpose: Test HeadPhone class created as part of CMIS 141 Homework 3
 */
public class TestHeadPhone {
  public static void main(String[] args) {
    // Create 3 HeadPhone objects
    // First HeadPhone is created using the default contructor
    HeadPhone headPhone1 = new HeadPhone();
    // The next two HeadPhones are created with different data than default constructor uses
    HeadPhone headPhone2 = new HeadPhone(HeadPhone.LOW, false, "Sony", HeadPhone.Color.violet, "PS4 Gold");
    HeadPhone headPhone3 = new HeadPhone(HeadPhone.HIGH, true, "Dr. Dre", HeadPhone.Color.yellow, "Beats");

    // Verifying the default constructor settings by using the toString method
    System.out.println("Default constructor results of toString for headPhone1: " + headPhone1.toString());
    // Set volume to low
    headPhone1.setVolume(HeadPhone.LOW);
    // Set plugged in status to true
    headPhone1.setPluggedIn(true);
    // Set HeadPhone manufacturer to Bose
    headPhone1.setManufacturer("Bose");
    // Set HeadPhone model to Quiet Comfort 35
    headPhone1.setHeadPhoneModel("Quiet Comfort 35");
    // Set HeadPhone color to white
    headPhone1.setHeadPhoneColor(HeadPhone.Color.white);

    System.out.println("The setter method has been used to change data for headPhone1. New results are below:");
    // Displays new volume setting
    System.out.println("Results of getVolume: " + headPhone1.getVolume());
    // Displays plugged in status
    System.out.println("Results of getPluggedIn: " + headPhone1.getPluggedIn());
    // Display HeadPhone manufacturer
    System.out.println("Results of getManufacturer: " + headPhone1.getManufacturer());
    // Display HeadPhone model
    System.out.println("Results of getHeadPhoneModel: " + headPhone1.getHeadPhoneModel());
    // Display HeadPhone color
    System.out.println("Results of getHeadPhoneColor: " + headPhone1.getHeadPhoneColor());
    // Verify all changes have been reflected in the toString
    System.out.println("toString results after changes: " + headPhone1.toString());
    // Allows user input to change volume
    System.out.println("Using the changeVolume method on headPhone1: ");
    headPhone1.changeVolume();
    System.out.println(
        "Results of getVolume after using changeVolume method: volume = " + headPhone1.getVolume());
    System.out.println("");

    // Verifying the modified constructor settings by using the toString method
    System.out.println("toString results after using modified contructor for headPhone2: " + headPhone2.toString());
    // Set volume to high
    headPhone2.setVolume(HeadPhone.HIGH);
    // Set plugged in status to true
    headPhone2.setPluggedIn(true);
    // Set HeadPhone manufacturer to Sennheiser
    headPhone2.setManufacturer("Sennheiser");
    // Set HeadPhone model to PXC 550
    headPhone2.setHeadPhoneModel("PXC 550");
    // Set HeadPhone color to orange
    headPhone2.setHeadPhoneColor(HeadPhone.Color.orange);

    System.out.println("The setter method has been used to change data for headPhone2. New results are below:");
    // Displays new volume setting
    System.out.println("Results of getVolume: " + headPhone2.getVolume());
    // Displays plugged in status
    System.out.println("Results of getPluggedIn: " + headPhone2.getPluggedIn());
    // Display HeadPhone manufacturer
    System.out.println("Results of getManufacturer: " + headPhone2.getManufacturer());
    // Display HeadPhone model
    System.out.println("Results of getHeadPhoneModel: " + headPhone2.getHeadPhoneModel());
    // Display HeadPhone color
    System.out.println("Results of getHeadPhoneColor: " + headPhone2.getHeadPhoneColor());
    // Verify all changes have been reflected in the toString
    System.out.println("toString results after changes: " + headPhone2.toString());
    // Allows user input to change volume
    System.out.println("Using the changeVolume method on headPhone2: ");
    headPhone2.changeVolume();
    System.out.println(
        "Results of getVolume after using changeVolume method: volume = " + headPhone2.getVolume());
    System.out.println("");

    // Verifying the default constructor settings by using the toString method
    System.out.println("toString results after using modified contructor for headPhone3: " + headPhone3.toString());
    // Set volume to low
    headPhone3.setVolume(HeadPhone.LOW);
    // Set plugged in status to false
    headPhone3.setPluggedIn(false);
    // Set HeadPhone manufacturer to Audio Technica
    headPhone3.setManufacturer("Audio Technica");
    // Set HeadPhone model to ATH-M20x
    headPhone3.setHeadPhoneModel("ATH M20x");
    // Set HeadPhone color to blue
    headPhone3.setHeadPhoneColor(HeadPhone.Color.blue);

    System.out.println("The setter method has been used to change data for headPhone3. New results are below:");
    // Displays new volume setting
    System.out.println("Results of getVolume: " + headPhone3.getVolume());
    // Displays plugged in status
    System.out.println("Results of getPluggedIn: " + headPhone3.getPluggedIn());
    // Display HeadPhone manufacturer
    System.out.println("Results of getManufacturer: " + headPhone3.getManufacturer());
    // Display HeadPhone model
    System.out.println("Results of getHeadPhoneModel: " + headPhone3.getHeadPhoneModel());
    // Display HeadPhone color
    System.out.println("Results of getHeadPhoneColor: " + headPhone3.getHeadPhoneColor());
    // Verify all changes have been reflected in the toString
    System.out.println("toString results after changes: " + headPhone3.toString());
    // Allows user input to change volume
    System.out.println("Using the changeVolume method on headPhone3: ");
    headPhone3.changeVolume();
    System.out.println(
        "Results of getVolume after using changeVolume method: volume = " + headPhone3.getVolume());
    System.out.println("");
  }
}
