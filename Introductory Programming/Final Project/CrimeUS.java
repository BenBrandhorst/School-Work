
package finalProject;

import java.util.*;
import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
/*
 * File: CrimeUS.java 
 * Author: Ben Brandhorst 
 * Date: December 15th, 2018 
 * Purpose: CMIS 141 Final Project. Contains US Crime stats and associated methods for displaying content
 * 
 */


public class CrimeUS {
  // used in readFiles method
  public static String[][] usStats = new String[0][];
  List<String[]> fileInput = new ArrayList<String[]>();
  String fileLine;
  BufferedReader inputStream = null;
  Scanner scannerIn = null;

  // used in maxMurder and minMurder methods
  public static double[][] murderStats;
  public static String murderString;
  public static String lowestMurderString;
  

  // used in robMax and robMin methods
  public static double[][] robberyStats;
  public static String robberyString;
  public static String lowestRobberyString;

  // used in carTheft and carTheftMin methods
  public static double[][] carTheftStats;
  public static String carTheftString;
  public static String lowestCarTheftString;

  public void readFiles(String[] args) {
    // stores command line arguments as a string for use in reading the csv file
    String fileName = String.valueOf(args[0]);

    try {
      // opens Buffered Reader to CSV file
      inputStream = new BufferedReader(new FileReader(fileName));

      // continues until data from file is all read
      while ((fileLine = inputStream.readLine()) != null) {

        // adds data to an Array List with imports broken up by commas
        fileInput.add(fileLine.split(","));
      }

    } catch (IOException io) {
      System.out.println("File IO exception" + io.getMessage());
    } finally {
      try {
        if (inputStream != null) {
          inputStream.close();
        }
      } catch (IOException io) {
        System.out.println("Issue closing the Files" + io.getMessage());
      }
    }
    // creates a 2d array with a number of rows equal to the size of the Array List I created
    // earlier
    String[][] crimeStats = new String[fileInput.size()][0];
    // imports the content of the array list into the 2d Array
    fileInput.toArray(crimeStats);



    // I had a hard time figuring out how to use my array outside of the readFiles method so I
    // cloned it for use in the other methods
    usStats = crimeStats.clone();
  }

  public static void populationGrowth() {
    // used to format numbers by rounding decimals to four numbers after decimal point and using
    // half up round method
    DecimalFormat df = new DecimalFormat("#.####");
    df.setRoundingMode(RoundingMode.HALF_UP);
    // converts the string values of the array into Double format and stores as variable so they can
    // be used in math equations
    Double ninetyFour = Double.valueOf(usStats[1][1]);
    Double ninetyFive = Double.valueOf(usStats[2][1]);
    Double ninetySix = Double.valueOf(usStats[3][1]);
    Double ninetySeven = Double.valueOf(usStats[4][1]);
    Double ninetyEight = Double.valueOf(usStats[5][1]);
    Double ninetyNine = Double.valueOf(usStats[6][1]);
    Double twoThousand = Double.valueOf(usStats[7][1]);
    Double aughtOne = Double.valueOf(usStats[8][1]);
    Double aughtTwo = Double.valueOf(usStats[9][1]);
    Double aughtThree = Double.valueOf(usStats[10][1]);
    Double aughtFour = Double.valueOf(usStats[11][1]);
    Double aughtFive = Double.valueOf(usStats[12][1]);
    Double aughtSix = Double.valueOf(usStats[13][1]);
    Double aughtSeven = Double.valueOf(usStats[14][1]);
    Double aughtEight = Double.valueOf(usStats[15][1]);
    Double aughtNine = Double.valueOf(usStats[16][1]);
    Double twentyTen = Double.valueOf(usStats[17][1]);
    Double twentyEleven = Double.valueOf(usStats[18][1]);
    Double twentyTwelve = Double.valueOf(usStats[19][1]);
    Double twentyThirteen = Double.valueOf(usStats[20][1]);


    // calculates population growth and prints output in properly formatted style
    System.out.println("");
    System.out.print("Population growth from 1994 to 1995 was ");
    double answer1 = ((ninetyFive - ninetyFour) / ninetyFour) * 100;
    System.out.println((df.format(answer1)) + ("%"));

    System.out.print("Population growth from 1995 to 1996 was ");
    double answer2 = ((ninetySix - ninetyFive) / ninetyFive) * 100;
    System.out.println((df.format(answer2)) + ("%"));

    System.out.print("Population growth from 1996 to 1997 was ");
    double answer3 = ((ninetySeven - ninetySix) / ninetySix) * 100;
    System.out.println((df.format(answer3)) + ("%"));

    System.out.print("Population growth from 1997 to 1998 was ");
    double answer4 = ((ninetyEight - ninetySeven) / ninetySeven) * 100;
    System.out.println((df.format(answer4)) + ("%"));

    System.out.print("Population growth from 1998 to 1999 was ");
    double answer5 = ((ninetyNine - ninetyEight) / ninetyEight) * 100;
    System.out.println((df.format(answer5)) + ("%"));

    System.out.print("Population growth from 1999 to 2000 was ");
    double answer6 = ((twoThousand - ninetyNine) / ninetyNine) * 100;
    System.out.println((df.format(answer6)) + ("%"));

    System.out.print("Population growth from 2000 to 2001 was ");
    double answer7 = ((aughtOne - twoThousand) / twoThousand) * 100;
    System.out.println((df.format(answer7)) + ("%"));

    System.out.print("Population growth from 2001 to 2002 was ");
    double answer8 = ((aughtTwo - aughtOne) / aughtOne) * 100;
    System.out.println((df.format(answer8)) + ("%"));

    System.out.print("Population growth from 2002 to 2003 was ");
    double answer9 = ((aughtThree - aughtTwo) / aughtTwo) * 100;
    System.out.println((df.format(answer9)) + ("%"));

    System.out.print("Population growth from 2003 to 2004 was ");
    double answer10 = ((aughtFour - aughtThree) / aughtThree) * 100;
    System.out.println((df.format(answer10)) + ("%"));

    System.out.print("Population growth from 2004 to 2005 was ");
    double answer11 = ((aughtFive - aughtFour) / aughtFour) * 100;
    System.out.println((df.format(answer11)) + ("%"));

    System.out.print("Population growth from 2005 to 2006 was ");
    double answer12 = ((aughtSix - aughtFive) / aughtFive) * 100;
    System.out.println((df.format(answer12)) + ("%"));

    System.out.print("Population growth from 2006 to 2007 was ");
    double answer13 = ((aughtSeven - aughtSix) / aughtSix) * 100;
    System.out.println((df.format(answer13)) + ("%"));

    System.out.print("Population growth from 2007 to 2008 was ");
    double answer14 = ((aughtEight - aughtSeven) / aughtSeven) * 100;
    System.out.println((df.format(answer14)) + ("%"));

    System.out.print("Population growth from 2008 to 2009 was ");
    double answer15 = ((aughtNine - aughtEight) / aughtEight) * 100;
    System.out.println((df.format(answer15)) + ("%"));

    System.out.print("Population growth from 2009 to 2010 was ");
    double answer16 = ((twentyTen - aughtNine) / aughtNine) * 100;
    System.out.println((df.format(answer16)) + ("%"));

    System.out.print("Population growth from 2010 to 2011 was ");
    double answer17 = ((twentyEleven - twentyTen) / twentyTen) * 100;
    System.out.println((df.format(answer17)) + ("%"));

    System.out.print("Population growth from 2011 to 2012 was ");
    double answer18 = ((twentyTwelve - twentyEleven) / twentyEleven) * 100;
    System.out.println((df.format(answer18)) + ("%"));

    System.out.print("Population growth from 2012 to 2013 was ");
    double answer19 = ((twentyThirteen - twentyTwelve) / twentyTwelve) * 100;
    System.out.println((df.format(answer19)) + ("%"));

  }

  public static void maxMurder() {
    // converts the String values of Array elements into double and stores as a variable
    double ninetyFour = Double.valueOf(usStats[1][5]);// 1994
    double ninetyFive = Double.valueOf(usStats[2][5]);// 1995
    double ninetySix = Double.valueOf(usStats[3][5]);// 1996
    double ninetySeven = Double.valueOf(usStats[4][5]);// 1997
    double ninetyEight = Double.valueOf(usStats[5][5]);// 1998
    double ninetyNine = Double.valueOf(usStats[6][5]);// 1999
    double twoThousand = Double.valueOf(usStats[7][5]);// 2000
    double aughtOne = Double.valueOf(usStats[8][5]);// 2001
    double aughtTwo = Double.valueOf(usStats[9][5]);// 2002
    double aughtThree = Double.valueOf(usStats[10][5]);// 2003
    double aughtFour = Double.valueOf(usStats[11][5]);// 2004
    double aughtFive = Double.valueOf(usStats[12][5]);// 2005
    double aughtSix = Double.valueOf(usStats[13][5]);// 2006
    double aughtSeven = Double.valueOf(usStats[14][5]);// 2007
    double aughtEight = Double.valueOf(usStats[15][5]);// 2008
    double aughtNine = Double.valueOf(usStats[16][5]);// 2009
    double twentyTen = Double.valueOf(usStats[17][5]);// 2010
    double twentyEleven = Double.valueOf(usStats[18][5]);// 2011
    double twentyTwelve = Double.valueOf(usStats[19][5]);// 2012
    double twentyThirteen = Double.valueOf(usStats[20][5]);// 2013
    // creates a more manageable array with murder statistics needed for calculations
    murderStats = new double[20][2];
    murderStats[0][0] = 1994;
    murderStats[0][1] = ninetyFour;
    murderStats[1][0] = 1995;
    murderStats[1][1] = ninetyFive;
    murderStats[2][0] = 1996;
    murderStats[2][1] = ninetySix;
    murderStats[3][0] = 1997;
    murderStats[3][1] = ninetySeven;
    murderStats[4][0] = 1998;
    murderStats[4][1] = ninetyEight;
    murderStats[5][0] = 1999;
    murderStats[5][1] = ninetyNine;
    murderStats[6][0] = 2000;
    murderStats[6][1] = twoThousand;
    murderStats[7][0] = 2001;
    murderStats[7][1] = aughtOne;
    murderStats[8][0] = 2002;
    murderStats[8][1] = aughtTwo;
    murderStats[9][0] = 2003;
    murderStats[9][1] = aughtThree;
    murderStats[10][0] = 2004;
    murderStats[10][1] = aughtFour;
    murderStats[11][0] = 2005;
    murderStats[11][1] = aughtFive;
    murderStats[12][0] = 2006;
    murderStats[12][1] = aughtSix;
    murderStats[13][0] = 2007;
    murderStats[13][1] = aughtSeven;
    murderStats[14][0] = 2008;
    murderStats[14][1] = aughtEight;
    murderStats[15][0] = 2009;
    murderStats[15][1] = aughtNine;
    murderStats[16][0] = 2010;
    murderStats[16][1] = twentyTen;
    murderStats[17][0] = 2011;
    murderStats[17][1] = twentyEleven;
    murderStats[18][0] = 2012;
    murderStats[18][1] = twentyTwelve;
    murderStats[19][0] = 2013;
    murderStats[19][1] = twentyThirteen;
    // calculates which array element contains the highest value
    double highestMurderRate = 0;

    for (int i = 0; i < murderStats.length; i++)

      if (highestMurderRate < murderStats[i][1]) {

        highestMurderRate = murderStats[i][0];
        murderString = Double.toString(highestMurderRate);
      }
    System.out.println("");
    System.out.print("The murder rate was highest in ");
    System.out.println(murderString.substring(0, murderString.length() - 2));

  }

  public static void minMurder() {
    // converts the String values of Array elements into double and stores as a variable
    double ninetyFour = Double.valueOf(usStats[1][5]);// 1994
    double ninetyFive = Double.valueOf(usStats[2][5]);// 1995
    double ninetySix = Double.valueOf(usStats[3][5]);// 1996
    double ninetySeven = Double.valueOf(usStats[4][5]);// 1997
    double ninetyEight = Double.valueOf(usStats[5][5]);// 1998
    double ninetyNine = Double.valueOf(usStats[6][5]);// 1999
    double twoThousand = Double.valueOf(usStats[7][5]);// 2000
    double aughtOne = Double.valueOf(usStats[8][5]);// 2001
    double aughtTwo = Double.valueOf(usStats[9][5]);// 2002
    double aughtThree = Double.valueOf(usStats[10][5]);// 2003
    double aughtFour = Double.valueOf(usStats[11][5]);// 2004
    double aughtFive = Double.valueOf(usStats[12][5]);// 2005
    double aughtSix = Double.valueOf(usStats[13][5]);// 2006
    double aughtSeven = Double.valueOf(usStats[14][5]);// 2007
    double aughtEight = Double.valueOf(usStats[15][5]);// 2008
    double aughtNine = Double.valueOf(usStats[16][5]);// 2009
    double twentyTen = Double.valueOf(usStats[17][5]);// 2010
    double twentyEleven = Double.valueOf(usStats[18][5]);// 2011
    double twentyTwelve = Double.valueOf(usStats[19][5]);// 2012
    double twentyThirteen = Double.valueOf(usStats[20][5]);// 2013
    // creates a more manageable array with murder statistics needed for calculations
    murderStats = new double[20][2];
    murderStats[0][0] = 1994;
    murderStats[0][1] = ninetyFour;
    murderStats[1][0] = 1995;
    murderStats[1][1] = ninetyFive;
    murderStats[2][0] = 1996;
    murderStats[2][1] = ninetySix;
    murderStats[3][0] = 1997;
    murderStats[3][1] = ninetySeven;
    murderStats[4][0] = 1998;
    murderStats[4][1] = ninetyEight;
    murderStats[5][0] = 1999;
    murderStats[5][1] = ninetyNine;
    murderStats[6][0] = 2000;
    murderStats[6][1] = twoThousand;
    murderStats[7][0] = 2001;
    murderStats[7][1] = aughtOne;
    murderStats[8][0] = 2002;
    murderStats[8][1] = aughtTwo;
    murderStats[9][0] = 2003;
    murderStats[9][1] = aughtThree;
    murderStats[10][0] = 2004;
    murderStats[10][1] = aughtFour;
    murderStats[11][0] = 2005;
    murderStats[11][1] = aughtFive;
    murderStats[12][0] = 2006;
    murderStats[12][1] = aughtSix;
    murderStats[13][0] = 2007;
    murderStats[13][1] = aughtSeven;
    murderStats[14][0] = 2008;
    murderStats[14][1] = aughtEight;
    murderStats[15][0] = 2009;
    murderStats[15][1] = aughtNine;
    murderStats[16][0] = 2010;
    murderStats[16][1] = twentyTen;
    murderStats[17][0] = 2011;
    murderStats[17][1] = twentyEleven;
    murderStats[18][0] = 2012;
    murderStats[18][1] = twentyTwelve;
    murderStats[19][0] = 2013;
    murderStats[19][1] = twentyThirteen;
    // calculates which array element contains the lowest value
    double lowestMurderRate = 10000;

    for (int i = 0; i < murderStats.length; i++)

      if (lowestMurderRate > murderStats[i][1]) {

        lowestMurderRate = murderStats[i][0];
        lowestMurderString = Double.toString(lowestMurderRate);

      }
    System.out.println("");
    System.out.print("The murder rate was lowest in ");
    System.out.println(lowestMurderString.substring(0, lowestMurderString.length() - 2));
  }

  public static void robMax() {
    // converts the String values of Array elements into double and stores as a variable
    double ninetyFour = Double.valueOf(usStats[1][9]);// 1994
    double ninetyFive = Double.valueOf(usStats[2][9]);// 1995
    double ninetySix = Double.valueOf(usStats[3][9]);// 1996
    double ninetySeven = Double.valueOf(usStats[4][9]);// 1997
    double ninetyEight = Double.valueOf(usStats[5][9]);// 1998
    double ninetyNine = Double.valueOf(usStats[6][9]);// 1999
    double twoThousand = Double.valueOf(usStats[7][9]);// 2000
    double aughtOne = Double.valueOf(usStats[8][9]);// 2001
    double aughtTwo = Double.valueOf(usStats[9][9]);// 2002
    double aughtThree = Double.valueOf(usStats[10][9]);// 2003
    double aughtFour = Double.valueOf(usStats[11][9]);// 2004
    double aughtFive = Double.valueOf(usStats[12][9]);// 2005
    double aughtSix = Double.valueOf(usStats[13][9]);// 2006
    double aughtSeven = Double.valueOf(usStats[14][9]);// 2007
    double aughtEight = Double.valueOf(usStats[15][9]);// 2008
    double aughtNine = Double.valueOf(usStats[16][9]);// 2009
    double twentyTen = Double.valueOf(usStats[17][9]);// 2010
    double twentyEleven = Double.valueOf(usStats[18][9]);// 2011
    double twentyTwelve = Double.valueOf(usStats[19][9]);// 2012
    double twentyThirteen = Double.valueOf(usStats[20][9]);// 2013
    // creates a more manageable array with murder statistics needed for calculations
    robberyStats = new double[20][2];
    robberyStats[0][0] = 1994;
    robberyStats[0][1] = ninetyFour;
    robberyStats[1][0] = 1995;
    robberyStats[1][1] = ninetyFive;
    robberyStats[2][0] = 1996;
    robberyStats[2][1] = ninetySix;
    robberyStats[3][0] = 1997;
    robberyStats[3][1] = ninetySeven;
    robberyStats[4][0] = 1998;
    robberyStats[4][1] = ninetyEight;
    robberyStats[5][0] = 1999;
    robberyStats[5][1] = ninetyNine;
    robberyStats[6][0] = 2000;
    robberyStats[6][1] = twoThousand;
    robberyStats[7][0] = 2001;
    robberyStats[7][1] = aughtOne;
    robberyStats[8][0] = 2002;
    robberyStats[8][1] = aughtTwo;
    robberyStats[9][0] = 2003;
    robberyStats[9][1] = aughtThree;
    robberyStats[10][0] = 2004;
    robberyStats[10][1] = aughtFour;
    robberyStats[11][0] = 2005;
    robberyStats[11][1] = aughtFive;
    robberyStats[12][0] = 2006;
    robberyStats[12][1] = aughtSix;
    robberyStats[13][0] = 2007;
    robberyStats[13][1] = aughtSeven;
    robberyStats[14][0] = 2008;
    robberyStats[14][1] = aughtEight;
    robberyStats[15][0] = 2009;
    robberyStats[15][1] = aughtNine;
    robberyStats[16][0] = 2010;
    robberyStats[16][1] = twentyTen;
    robberyStats[17][0] = 2011;
    robberyStats[17][1] = twentyEleven;
    robberyStats[18][0] = 2012;
    robberyStats[18][1] = twentyTwelve;
    robberyStats[19][0] = 2013;
    robberyStats[19][1] = twentyThirteen;
    // calculates which array element contains the highest value
    double highestRobberyRate = 0;

    for (int i = 0; i < robberyStats.length; i++)

      if (highestRobberyRate < robberyStats[i][1]) {

        highestRobberyRate = robberyStats[i][0];
        robberyString = Double.toString(highestRobberyRate);

      }
    System.out.println("");
    System.out.print("The robbery rate was highest in ");
    System.out.println(robberyString.substring(0, robberyString.length() - 2));

  }

  public static void robMin() {
    // converts the String values of Array elements into double and stores as a variable
    double ninetyFour = Double.valueOf(usStats[1][9]);// 1994
    double ninetyFive = Double.valueOf(usStats[2][9]);// 1995
    double ninetySix = Double.valueOf(usStats[3][9]);// 1996
    double ninetySeven = Double.valueOf(usStats[4][9]);// 1997
    double ninetyEight = Double.valueOf(usStats[5][9]);// 1998
    double ninetyNine = Double.valueOf(usStats[6][9]);// 1999
    double twoThousand = Double.valueOf(usStats[7][9]);// 2000
    double aughtOne = Double.valueOf(usStats[8][9]);// 2001
    double aughtTwo = Double.valueOf(usStats[9][9]);// 2002
    double aughtThree = Double.valueOf(usStats[10][9]);// 2003
    double aughtFour = Double.valueOf(usStats[11][9]);// 2004
    double aughtFive = Double.valueOf(usStats[12][9]);// 2005
    double aughtSix = Double.valueOf(usStats[13][9]);// 2006
    double aughtSeven = Double.valueOf(usStats[14][9]);// 2007
    double aughtEight = Double.valueOf(usStats[15][9]);// 2008
    double aughtNine = Double.valueOf(usStats[16][9]);// 2009
    double twentyTen = Double.valueOf(usStats[17][9]);// 2010
    double twentyEleven = Double.valueOf(usStats[18][9]);// 2011
    double twentyTwelve = Double.valueOf(usStats[19][9]);// 2012
    double twentyThirteen = Double.valueOf(usStats[20][9]);// 2013
    // creates a more manageable array with murder statistics needed for calculations
    robberyStats = new double[20][2];
    robberyStats[0][0] = 1994;
    robberyStats[0][1] = ninetyFour;
    robberyStats[1][0] = 1995;
    robberyStats[1][1] = ninetyFive;
    robberyStats[2][0] = 1996;
    robberyStats[2][1] = ninetySix;
    robberyStats[3][0] = 1997;
    robberyStats[3][1] = ninetySeven;
    robberyStats[4][0] = 1998;
    robberyStats[4][1] = ninetyEight;
    robberyStats[5][0] = 1999;
    robberyStats[5][1] = ninetyNine;
    robberyStats[6][0] = 2000;
    robberyStats[6][1] = twoThousand;
    robberyStats[7][0] = 2001;
    robberyStats[7][1] = aughtOne;
    robberyStats[8][0] = 2002;
    robberyStats[8][1] = aughtTwo;
    robberyStats[9][0] = 2003;
    robberyStats[9][1] = aughtThree;
    robberyStats[10][0] = 2004;
    robberyStats[10][1] = aughtFour;
    robberyStats[11][0] = 2005;
    robberyStats[11][1] = aughtFive;
    robberyStats[12][0] = 2006;
    robberyStats[12][1] = aughtSix;
    robberyStats[13][0] = 2007;
    robberyStats[13][1] = aughtSeven;
    robberyStats[14][0] = 2008;
    robberyStats[14][1] = aughtEight;
    robberyStats[15][0] = 2009;
    robberyStats[15][1] = aughtNine;
    robberyStats[16][0] = 2010;
    robberyStats[16][1] = twentyTen;
    robberyStats[17][0] = 2011;
    robberyStats[17][1] = twentyEleven;
    robberyStats[18][0] = 2012;
    robberyStats[18][1] = twentyTwelve;
    robberyStats[19][0] = 2013;
    robberyStats[19][1] = twentyThirteen;
    // calculates which array element contains the lowest value
    double lowestRobberyRate = 10000;

    for (int i = 0; i < robberyStats.length; i++)

      if (lowestRobberyRate > robberyStats[i][1]) {

        lowestRobberyRate = robberyStats[i][0];
        lowestRobberyString = Double.toString(lowestRobberyRate);

      }
    System.out.println("");
    System.out.print("The robbery rate was lowest in ");
    System.out.println(lowestRobberyString.substring(0, lowestRobberyString.length() - 2));

  }

  public static void carTheftMax() {
    // converts the String values of Array elements into double and stores as a variable
    double ninetyFour = Double.valueOf(usStats[1][19]);// 1994
    double ninetyFive = Double.valueOf(usStats[2][19]);// 1995
    double ninetySix = Double.valueOf(usStats[3][19]);// 1996
    double ninetySeven = Double.valueOf(usStats[4][19]);// 1997
    double ninetyEight = Double.valueOf(usStats[5][19]);// 1998
    double ninetyNine = Double.valueOf(usStats[6][19]);// 1999
    double twoThousand = Double.valueOf(usStats[7][19]);// 2000
    double aughtOne = Double.valueOf(usStats[8][19]);// 2001
    double aughtTwo = Double.valueOf(usStats[9][19]);// 2002
    double aughtThree = Double.valueOf(usStats[10][19]);// 2003
    double aughtFour = Double.valueOf(usStats[11][19]);// 2004
    double aughtFive = Double.valueOf(usStats[12][19]);// 2005
    double aughtSix = Double.valueOf(usStats[13][19]);// 2006
    double aughtSeven = Double.valueOf(usStats[14][19]);// 2007
    double aughtEight = Double.valueOf(usStats[15][19]);// 2008
    double aughtNine = Double.valueOf(usStats[16][19]);// 2009
    double twentyTen = Double.valueOf(usStats[17][19]);// 2010
    double twentyEleven = Double.valueOf(usStats[18][19]);// 2011
    double twentyTwelve = Double.valueOf(usStats[19][19]);// 2012
    double twentyThirteen = Double.valueOf(usStats[20][19]);// 2013
    // creates a more manageable array with murder statistics needed for calculations
    carTheftStats = new double[20][2];
    carTheftStats[0][0] = 1994;
    carTheftStats[0][1] = ninetyFour;
    carTheftStats[1][0] = 1995;
    carTheftStats[1][1] = ninetyFive;
    carTheftStats[2][0] = 1996;
    carTheftStats[2][1] = ninetySix;
    carTheftStats[3][0] = 1997;
    carTheftStats[3][1] = ninetySeven;
    carTheftStats[4][0] = 1998;
    carTheftStats[4][1] = ninetyEight;
    carTheftStats[5][0] = 1999;
    carTheftStats[5][1] = ninetyNine;
    carTheftStats[6][0] = 2000;
    carTheftStats[6][1] = twoThousand;
    carTheftStats[7][0] = 2001;
    carTheftStats[7][1] = aughtOne;
    carTheftStats[8][0] = 2002;
    carTheftStats[8][1] = aughtTwo;
    carTheftStats[9][0] = 2003;
    carTheftStats[9][1] = aughtThree;
    carTheftStats[10][0] = 2004;
    carTheftStats[10][1] = aughtFour;
    carTheftStats[11][0] = 2005;
    carTheftStats[11][1] = aughtFive;
    carTheftStats[12][0] = 2006;
    carTheftStats[12][1] = aughtSix;
    carTheftStats[13][0] = 2007;
    carTheftStats[13][1] = aughtSeven;
    carTheftStats[14][0] = 2008;
    carTheftStats[14][1] = aughtEight;
    carTheftStats[15][0] = 2009;
    carTheftStats[15][1] = aughtNine;
    carTheftStats[16][0] = 2010;
    carTheftStats[16][1] = twentyTen;
    carTheftStats[17][0] = 2011;
    carTheftStats[17][1] = twentyEleven;
    carTheftStats[18][0] = 2012;
    carTheftStats[18][1] = twentyTwelve;
    carTheftStats[19][0] = 2013;
    carTheftStats[19][1] = twentyThirteen;
    // calculates which array element contains the highest value
    double highestCarTheftRate = 0;

    for (int i = 0; i < carTheftStats.length; i++)

      if (highestCarTheftRate < carTheftStats[i][1]) {

        highestCarTheftRate = carTheftStats[i][0];
        carTheftString = Double.toString(highestCarTheftRate);
      }
    System.out.println("");
    System.out.print("The motor vehicle theft rate was highest in ");
    System.out.println(carTheftString.substring(0, carTheftString.length() - 2));
  }

  public static void carTheftMin() {
    // converts the String values of Array elements into double and stores as a variable
    double ninetyFour = Double.valueOf(usStats[1][19]);// 1994
    double ninetyFive = Double.valueOf(usStats[2][19]);// 1995
    double ninetySix = Double.valueOf(usStats[3][19]);// 1996
    double ninetySeven = Double.valueOf(usStats[4][19]);// 1997
    double ninetyEight = Double.valueOf(usStats[5][19]);// 1998
    double ninetyNine = Double.valueOf(usStats[6][19]);// 1999
    double twoThousand = Double.valueOf(usStats[7][19]);// 2000
    double aughtOne = Double.valueOf(usStats[8][19]);// 2001
    double aughtTwo = Double.valueOf(usStats[9][19]);// 2002
    double aughtThree = Double.valueOf(usStats[10][19]);// 2003
    double aughtFour = Double.valueOf(usStats[11][19]);// 2004
    double aughtFive = Double.valueOf(usStats[12][19]);// 2005
    double aughtSix = Double.valueOf(usStats[13][19]);// 2006
    double aughtSeven = Double.valueOf(usStats[14][19]);// 2007
    double aughtEight = Double.valueOf(usStats[15][19]);// 2008
    double aughtNine = Double.valueOf(usStats[16][19]);// 2009
    double twentyTen = Double.valueOf(usStats[17][19]);// 2010
    double twentyEleven = Double.valueOf(usStats[18][19]);// 2011
    double twentyTwelve = Double.valueOf(usStats[19][19]);// 2012
    double twentyThirteen = Double.valueOf(usStats[20][19]);// 2013
    // creates a more manageable array with murder statistics needed for calculations
    carTheftStats = new double[20][2];
    carTheftStats[0][0] = 1994;
    carTheftStats[0][1] = ninetyFour;
    carTheftStats[1][0] = 1995;
    carTheftStats[1][1] = ninetyFive;
    carTheftStats[2][0] = 1996;
    carTheftStats[2][1] = ninetySix;
    carTheftStats[3][0] = 1997;
    carTheftStats[3][1] = ninetySeven;
    carTheftStats[4][0] = 1998;
    carTheftStats[4][1] = ninetyEight;
    carTheftStats[5][0] = 1999;
    carTheftStats[5][1] = ninetyNine;
    carTheftStats[6][0] = 2000;
    carTheftStats[6][1] = twoThousand;
    carTheftStats[7][0] = 2001;
    carTheftStats[7][1] = aughtOne;
    carTheftStats[8][0] = 2002;
    carTheftStats[8][1] = aughtTwo;
    carTheftStats[9][0] = 2003;
    carTheftStats[9][1] = aughtThree;
    carTheftStats[10][0] = 2004;
    carTheftStats[10][1] = aughtFour;
    carTheftStats[11][0] = 2005;
    carTheftStats[11][1] = aughtFive;
    carTheftStats[12][0] = 2006;
    carTheftStats[12][1] = aughtSix;
    carTheftStats[13][0] = 2007;
    carTheftStats[13][1] = aughtSeven;
    carTheftStats[14][0] = 2008;
    carTheftStats[14][1] = aughtEight;
    carTheftStats[15][0] = 2009;
    carTheftStats[15][1] = aughtNine;
    carTheftStats[16][0] = 2010;
    carTheftStats[16][1] = twentyTen;
    carTheftStats[17][0] = 2011;
    carTheftStats[17][1] = twentyEleven;
    carTheftStats[18][0] = 2012;
    carTheftStats[18][1] = twentyTwelve;
    carTheftStats[19][0] = 2013;
    carTheftStats[19][1] = twentyThirteen;
    // calculates which array element contains the highest value
    double lowestCarTheftRate = 10000;

    for (int i = 0; i < carTheftStats.length; i++)

      if (lowestCarTheftRate > carTheftStats[i][1]) {

        lowestCarTheftRate = carTheftStats[i][0];
        lowestCarTheftString = Double.toString(lowestCarTheftRate);
      }
    System.out.println("");
    System.out.print("The motor vehicle theft rate was lowest in ");
    System.out.println(lowestCarTheftString.substring(0, lowestCarTheftString.length() - 2));
  }

}



