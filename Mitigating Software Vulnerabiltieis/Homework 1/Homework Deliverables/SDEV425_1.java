/*File: SDEV425_1.java
 * Author: Ben Brandhorst
 * Date: March 29th 2020
 * Purpose: SDEV425 Homework 1
 */
package sdev425;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/** @author jim */
public class SDEV425_1 {
  // Creates whitelist to match filepath against
  private static final String WHITELISTPATH = "/Users/benbrandhorst/Downloads/";
  // Canonicalized filepath variable
  private static String canonical;
  // Sets a limit to file size to be matched against
  private static final int FILELIMIT = 1000000;

  // Method to confirm argument is a file and in the whitelisted filepath
  private static boolean confirmPath(String filename) {
    File file = new File(filename);
    canonical = null;
    // Confirms that the command line argument is a file
    if (!file.isFile()) {
      System.out.println("You have selected an incorrect filepath or file.");
    } else {
      try {
        // Canonicalizes filename
        canonical = file.getCanonicalPath();
      } catch (IOException io) {
        System.out.println("File IO exception" + io.getMessage());
      }
    }
    // Returns true if the argument contains the specified filepath
    return canonical.contains(WHITELISTPATH);
  }

  // Method to verify the file size is within limits
  private static boolean confirmSize(String canonical) throws IOException {
    long size = Files.size(Paths.get(canonical));
    if (size > FILELIMIT) {
      System.out.println("The file selected is too large. Please try with a smaller file.");
      System.exit(1);
    } else if (size == 0L) {
      throw new IOException("Cannot determine file size. Please try again.");
    }
    return true;
  }

  public static void main(String[] args) {
    BufferedReader inputStream = null;
    if (args.length < 1) {
      System.out.println("Please provide an argument for the filename");
    } else
      try {
        // Read the filename from the command line argument
        String filename = args[0];
        // Checks path of file and file size before reading using BufferedReader
        if (confirmPath(filename) && (confirmSize(canonical))) ;
      } catch (IOException ex) {
        Logger.getLogger(SDEV425_1.class.getName()).log(Level.SEVERE, null, ex);
      }
    try {
      String fileLine;
      inputStream = new BufferedReader(new FileReader(canonical));
      System.out.println("Email Addresses:");
      // Read one Line using BufferedReader and matches it against a regex designed to confirm it is
      // a valid email address before printing
      while ((fileLine = inputStream.readLine()) != null
          && fileLine.matches(
              "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-"
                  + "\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x"
                  + "0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9]"
                  + "(?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?"
                  + "[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*"
                  + "[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\"
                  + "[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
        System.out.println(fileLine);
      }

    } catch (IOException io) {

      System.out.println("File IO exception" + io.getMessage());

    } finally {
      // Need another catch for closing
      // the streams
      try {
        if (inputStream != null) {
          inputStream.close();
        }
      } catch (IOException io) {

        System.out.println("Issue closing the Files" + io.getMessage());
      }
    }
  }
}
