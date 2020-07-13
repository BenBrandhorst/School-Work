import java.util.*;
/*
 * File: StateInfo.java 
 * Author: Ben Brandhorst 
 * Date: December 7th, 2018 
 * Purpose: CMIS 141 Homework 4- Write a Java program the displays the State bird and flower
 * 
 */

public class StateInfo {
  // Array with states, state bird, and state flower. The lower case state names are used during
  // linear search.
  String[][] states = {
      {"alabama", "Alabama", "Yellowhammer", "Camellia"},
      {"alaska", "Alaska", "Willow Ptarmigan", "Forget-me-not"},
      {"arizona", "Arizona", "Cactus Wren", "Saguaro Cactus"},
      {"arkansas", "Arkansas", "Mockingbird", "Apple Blossom"},
      {"california", "California", "California Valley Quail", "Golden Poppy"},
      {"colorado", "Colorado", "Lark Bunting", "Rocky Mountain Columbine"},
      {"connecticut", "Connecticut", "Robin", "Mountain Laurel"},
      {"delaware", "Delaware", "Blue Hen Chicken", "Peach Blossom"},
      {"florida", "Florida", "Mockingbird", "Orange Blossom"},
      {"georgia", "Georgia", "Brown Thrasher", "Cherokee Rose"},
      {"hawaii", "Hawaii", "Nene", "Hibiscus"}, 
      {"idaho", "Idaho", "Mountain Bluebird", "Syringa"},
      {"illinois", "Illinois", "Cardinal", "Native Violet"},
      {"indiana", "Indiana", "Cardinal", "Peony"},
      {"iowa", "Iowa", "Eastern Goldfinch", "Wild Rose"},
      {"kansas", "Kansas", "Western Meadowlark", "Native Sunflower"},
      {"kentucky", "Kentucky", "Cardinal", "Goldenrod"},
      {"louisiana", "Louisiana", "Brown Pelican", "Magnolia"},
      {"maine", "Maine", "Chickadee", "Pine Cone & Tassle"},
      {"maryland", "Maryland", "Baltimore Oriole", "Black Eyed Susan"},
      {"massachusetts", "Massachusetts", "Chickadee", "Mayflower"},
      {"michigan", "Michigan", "Robin", "Apple Blossom"},
      {"minnesota", "Minnesota", "Common Loon", "Lady Slipper"},
      {"mississippi", "Mississippi", "Mockingbird", "Magnolia"},
      {"missouri", "Missouri", "Bluebird", "Hawthorn"},
      {"montana", "Montana", "Western Meadowlark", "Bitterroot"},
      {"nebraska", "Nebraska", "Western Meadowlark", "Goldenrod"},
      {"nevada", "Nevada", "Mountain Bluebird", "Sagebrush"},
      {"new hampshire", "New Hampshire", "Purple Finch", "Purple lilac"},
      {"new jersey", "New Jersey", "Eastern Goldfinch", "Purple Violet"},
      {"new mexico", "New Mexico", "Roadrunner", "Yucca"},
      {"new york", "New York", "Bluebird", "Rose"},
      {"north carolina", "North Carolina", "Cardinal", "Dogwood"},
      {"north dakota", "North Dakota", "Western Meadowlark", "Wild Prairie Rose"},
      {"ohio", "Ohio", "Cardinal", "Scarlet Carnation"},
      {"oklahoma", "Oklahoma", "Scissor-tailed Flycatcher", "Mistletoe"},
      {"oregon", "Oregon", "Western Meadowlark", "Oregon Grape"},
      {"pennsylvania", "Pennsylvania", "Ruffed Grouse", "Mountain Laurel"},
      {"rhode island", "Rhode Island", "Rhode Island Red", "Violet"},
      {"south carolina", "South Carolina", "Great Carolina Wren", "Yellow Jessamine"},
      {"south dakota", "South Dakota", "Ring-necked Pheasant", "Pasque Flower"},
      {"tennessee", "Tennessee", "Mockingbird", "Purple Iris"},
      {"texas", "Texas", "Mockingbird", "Texas Blue Bonnet"},
      {"utah", "Utah", "American Seagull", "Sego Lily"},
      {"vermont", "Vermont", "Hermit Thrush", "Red Clover"},
      {"virginia", "Virginia", "Cardinal", "Dogwood"},
      {"washington", "Washington", "Willow Goldfinch", "Western Rhododendron"},
      {"west virginia", "West Virginia", "Cardinal", "Rhododendron"},
      {"wisconsin", "Wisconsin", "Robin", "Wood Violet"},
      {"wyoming", "Wyoming", "Western Meadowlark", "Indian Paint Brush"},
      {"BLANK", "INPUT", "USED", "FOR COUNTER"}};

  // holds a running String of program outputs which are displayed when queries are complete
  StringBuilder wrapUp = new StringBuilder("A summary report for each State, Bird, and Flower is: ");

  // default constructor. Not sure this even needs to be used but I put it here just in case
  public StateInfo() {}

  /*
   * Method that prompts scanner input, converts input to lower case, compares that input against
   * array and returns state flowers and birds if the input matches a state. It also collects output
   * and stores it in a Stringbuilder for use later
   */
  public void findState() {
    
    String lowerCaseInput;

    System.out.println("Enter a State or None to Exit");
    Scanner keyboard = new Scanner(System.in);
    // converts all string input to lower case and trims blank spaces before and after
    lowerCaseInput = keyboard.nextLine().toLowerCase().trim();
    // i is used to hold counter values
    int i;
    for (i = 0; i < 51; i++) {
      // compares scanner input to column[0] (lowercase state names) in every row of the array.
      if (lowerCaseInput.equals(states[i][0])) {
        // appends stringbuilder with contents of columns [1], [2], and [3] of whatever row is
        // matched
        wrapUp.append(states[i][1] + ", ");
        wrapUp.append(states[i][2] + ", ");
        wrapUp.append(states[i][3] + ", ");
        // prints state bird and flower of whatever state was matched
        System.out.println("Bird: " + states[i][2]);
        System.out.println("Flower: " + states[i][3]);
        // prompts user for more input and resets counter to zero
        System.out.println("Enter a State or None to Exit");
        lowerCaseInput = keyboard.nextLine().toLowerCase().trim();
        // resets counter to zero
        i = 0;
      }
      // executes if user inputs any upper or lowercase version of "NONE"
      if (lowerCaseInput.equals("none")) {
        break;
      }
      // Array contains 50 rows of data with a 51st containing filler. Linear search is used to
      // compare values of scanner input against state names. If no matches are found, counter goes
      // to 51st row
      while (i == 50) {
        // informs user that their input is not in the array and prompts them for new input
        System.out.println(lowerCaseInput + " doesn't exist in array.");
        System.out.println("Enter a State or None to Exit");
        lowerCaseInput = keyboard.nextLine().toLowerCase().trim();
        // resets counter to zero
        i = 0;

      }
    }
  }

  // method which generates summary of program output
  public void summary() {
    // Removes final comma of wrapUp if it's appended with any additional inputs
    if (wrapUp.length() > 54) {
      wrapUp.setLength(wrapUp.length() - 2);
      // adds period to String after removing final comma
      wrapUp.append(".");
    }
    // prints wrapUp of all outputs displayed previously and stops program
    System.out.println("");
    System.out.println("**** Thank you *****");
    System.out.println(wrapUp);
    System.out.println("Please visit our site again!");
    System.out.println("");

  }
}



