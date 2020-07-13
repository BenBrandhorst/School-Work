

/*
 * File: Guitar.java 
 * Author: Ben Brandhorst 
 * Date: November 15, 2018 
 * Purpose: Homework 2
 */

import java.util.Random;

  public class Guitar {
  private int numStrings;
  private double guitarLength;
  private String guitarManufacturer;
  public Color guitarColor;

  enum Color {
    red, green, blue, yellow, black, white, orange, violet
  }



  // Default constructor for standard 6 string, 28.2 inch, red, Gibson guitar
  public Guitar() {
    numStrings = 6;
    guitarLength = 28.2;
    guitarManufacturer = ("Gibson");
    guitarColor = Color.red;// Identifies the default color as red
  }

  // Constructor which allows a specified number of strings, guitar length, manufacturer, and guitar
  // color
  public Guitar(int numStrings, double guitarLength, String guitarManufacturer, Color guitarColor) {
    this.numStrings = numStrings;
    this.guitarLength = guitarLength;
    this.guitarManufacturer = guitarManufacturer;
    this.guitarColor = guitarColor;

  }

  // Define Getter methods
  // Get number of guitar strings
  public int getStrings() {
    return this.numStrings;
  }

  // Get length of guitar
  public double getLength() {
    return this.guitarLength;
  }

  // Get guitar manufacturer
  public String getManufacturer() {
    return this.guitarManufacturer;
  }

  // Get guitar color
  public Color getColor() {
    return this.guitarColor;
  }

  // This is my workaround to try to change the guitar color in the TestGuitar program
  public void changeColor(Color newColor) {
    guitarColor = newColor;
  }

  // This plays 16 random notes and note lengths
  public String playGuitar() {
    // This line is used with the one below to help select a random letter A-G
    Random a = new Random();
    // This pulls a random ASCII character A-G (1=A,2=B,3=C, etc) the capital 'A' at the end
    // capitalizes the returned letters
    char note = (char) (a.nextInt(7) + 'A');
    // This is used to randomly select one of the five strings the in the line below it
    int b = (int) (Math.random() * 5);
    // String input of the note lengths used
    String length = new String[] {".25", ".5", "1", "2", "4"}[b];
    // I put all of the brackets and commas into Strings so I could easily call them later on
    String open = "[";
    String close = "]";
    String comma = ", ";
    String left = "(";
    String right = ")";
    String printOut = " ";// Empty String to hold values later
    // This line runs a single time and allows me to insert an opening bracket along with a note and
    // note length before starting the loop
    printOut = open + note + left + length + right + comma;
    /// The for loop that runs 15 times to generate random notes and note lengths
    for (int i = 1; i < 16; i++) {
      // This isn't the cleanest code but I couldn't figure out how to pull random notes and lengths
      // without creating a second set of variables within the loop.
      Random c = new Random();
      char otherNote = (char) (c.nextInt(7) + 'A');
      int d = (int) (Math.random() * 5);
      String otherLength = new String[] {".25", ".5", "1", "2", "4"}[d];
      // Prints out notes and note lengths
      printOut = printOut + otherNote + left + otherLength + right;
      // if statement that puts a comma between notes
      if (i != 15)
        printOut = printOut + comma;
    }
    // After the loop finishes this inserts the closing bracket
    printOut = printOut + close;
    return printOut;
  }



  // Lists all the Getter information for the guitar in a string format
  public String toString() {
    String guitarInfo = "(Number of Strings = " + this.numStrings + ", Guitar Length = "
        + this.guitarLength + ", Guitar Manufacturer = " + this.guitarManufacturer
        + ", Guitar Color = " + this.guitarColor + ")";
    return guitarInfo;
  }


}
 
