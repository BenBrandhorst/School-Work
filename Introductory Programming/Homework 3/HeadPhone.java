import java.util.*;


/*
 * File: HeadPhone.java 
 * Author: Ben Brandhorst 
 * Date: November 27, 2018 
 * Purpose: CMIS 141 Homework 3- Create a HeadPhone class
 * Outside References: http://www.vogella.com/tutorials/JavaRegularExpressions/article.html
 * Used to figure out how to use Regular Expressions to scan input and help make a loop that
 * prevents Scanner exceptions
 */
public class HeadPhone {
  // Define constant variables
  public static final int LOW = 1;
  public static final int MEDIUM = 2;
  public static final int HIGH = 3;
  // Define instance variables
  private int volume;
  private boolean pluggedIn;
  private String manufacturer;
  private Color headPhoneColor;
  private String headPhoneModel;

  // enum Color is used here to avoid the headache of trying to get RGB colors to display as a word
  // rather than RGB values. It does have the limitation of forcing the user to know what values are
  // usable beforehand.
  enum Color {
    red, green, blue, yellow, black, white, orange, violet, silver, grey, gold
  }



  // Define getter methods
  // Get the Headphone volume
  public int getVolume() {
    return this.volume;
  }

  // Get plugged in status
  public boolean getPluggedIn() {
    return this.pluggedIn;
  }

  // Get Headphone manufacturer
  public String getManufacturer() {
    return this.manufacturer;
  }

  // Get Headphone color
  public Color getHeadPhoneColor() {
    return this.headPhoneColor;
  }

  // Get Headphone model
  public String getHeadPhoneModel() {
    return this.headPhoneModel;
  }

  // Define setter Methods
  // Set the Headphone volume
  public void setVolume(int vol) {
    this.volume = vol;
  }

  // Set plugged in status
  public void setPluggedIn(boolean plug) {
    this.pluggedIn = plug;
  }

  // Set Headphone manufacturer
  public void setManufacturer(String maker) {
    this.manufacturer = maker;
  }

  // Set Headphone color
  public void setHeadPhoneColor(Color color) {
    this.headPhoneColor = color;
  }

  // Set Headphone model
  public void setHeadPhoneModel(String model) {
    this.headPhoneModel = model;
  }


  // Default constructor
  public HeadPhone() {
    volume = MEDIUM;
    pluggedIn = false;
    manufacturer = ("AKG");
    headPhoneColor = Color.black;
    headPhoneModel = ("K240 Studio");
  }

  // Constructor which allows modification of data when creating the object
  public HeadPhone(int volume, boolean pluggedIn, String manufacturer, Color headPhoneColor,
      String headPhoneModel) {
    this.volume = volume;
    this.pluggedIn = pluggedIn;
    this.manufacturer = manufacturer;
    this.headPhoneColor = headPhoneColor;
    this.headPhoneModel = headPhoneModel;


  }

  // Lists all the HeadPhone getter info in an easily readable format
  public String toString() {
    String headPhoneInfo = "(HeadPhone manufacturer = " + this.manufacturer + ", HeadPhone model = "
        + this.headPhoneModel + ", HeadPhone color = " + this.headPhoneColor
        + ", HeadPhone volume = " + this.volume + ", HeadPhone is plugged in = " + this.pluggedIn
        + ")";
    return headPhoneInfo;
  }

  /*
   * A method to allow user input to change the HeadPhone volume. I finished the homework early this
   * week and really wanted to figure out how to handle scanner exceptions. This method is probably
   * the 4th or 5th version I tried. I started with .nextInt() and using a switch to handle the
   * selection but the program couldn't handle non integer inputs. Then I went with a while loop for
   * users to select an integer greater than 0 and less than 4. The problem was that the input
   * errors happened before the program tried to do anything with the data. I played around with
   * try/catch and converting String to int but i couldn't get the method to loop back after the
   * catch. I tried messing with regex to use a boolean return as a kind of switch. I finally
   * settled on accepting String input and using a while loop to prompt input until specified input
   * was used.
   */
  public void changeVolume() {
    // Scanner for user input
    Scanner keyboard = new Scanner(System.in);
    // variable to hold keyboard input
    String setting;
    System.out.println("Select your HeadPhone volume (1 = LOW, 2 = MEDIUM, 3 = HIGH)");
    setting = keyboard.next();
    // while loop keeps prompting user for input until they select 1, 2, or 3
    while (!setting.matches("(1|2|3)")) {
      System.out.println("You have entered invalid input. Please try again.");
      System.out.println("Select your HeadPhone volume (1 = LOW, 2 = MEDIUM, 3 = HIGH)");
      setting = keyboard.next();
    }
    if (setting.equals("1")) {
      // If user inputs '1' volume is defined as LOW and users are prompted of the change
      volume = LOW;
      System.out.println("The volume has been set to the LOW setting.");
    }
    // If user inputs '2' volume is defined as MEDIUM and users are prompted of the change
    else if (setting.equals("2")) {
      volume = MEDIUM;
      System.out.println("The volume has been set to the MEDIUM setting.");
    }
    // If user inputs '3' volume is defined as HIGH and users are prompted of the change
    else if (setting.equals("3")) {
      volume = HIGH;
      System.out.println("The volume has been set to the HIGH setting.");


    }
  }
}


