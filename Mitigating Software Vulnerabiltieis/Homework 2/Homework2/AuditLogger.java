/*File: AuditLogger.java
 * Author: Ben Brandhorst
 * Date: April 12th 2020
 * Purpose: SDEV425 Homework 2
 */
package Homework2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;

public class AuditLogger {
  
  private static final Logger LOGGER = Logger.getLogger(AuditLogger.class.getName());
  private static final String LOGDIR = "/Users/benbrandhorst/NetBeansProjects/Homework2/Audit.log";
  private static FileHandler fh = null;

  // Must make the FileHandler a class instance variable to keep from duplicating logs each
  // time the logInfo method is called
  static {
    try {
			// This block of code creates the FileHandler and directs the output to the Audit.log file
			// while the boolean sets append on the log file so the contents are not constantly overwritten
      fh = new FileHandler(LOGDIR, true);
      LOGGER.addHandler(fh);
      SimpleFormatter formatter = new SimpleFormatter();
      fh.setFormatter(formatter);
    } catch (IOException | SecurityException i) {
    }
  }
	// logInfo method writes the content of the log to the Audit.log
  public void logInfo(String log) {
    LOGGER.log(Level.INFO, log);
  }
	// Creates a log of when the program starts
  public void programStart() {
    String start = "The Program has started";
    logInfo(start);
  }
	// Creates a log of when login is clicked
  public void loginClicked(String user) {
    String clicked = "The login button was pressed by someone using a username of " + user;
    logInfo(clicked);
  }
	// Creates a log of a successful login
  public void loginSuccess(String user) {
    String login = user + " successfully logged in";
    logInfo(login);
  }
	// Creates a log of when a user inputs an incorrect username or password
  public void incorrectLogin(String user) {
    String incorrect = "Someone using a username of " + user + " was unsuccessful logging in";
    logInfo(incorrect);
  }
	// Creates a log of when a user locks out the program from too many bad login attempts
  public void lockOut(String user) {
    String lock = "The program has been locked out by someone using a username of " + user;
    logInfo(lock);
  }
}
