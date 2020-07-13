/*File: Homework2.java
 * Author: Ben Brandhorst
 * Date: April 12th 2020
 * Purpose: SDEV425 Homework 2
 */
package Homework2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.control.Alert.AlertType;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author jim Adopted from Oracle's Login Tutorial Application
 * https://docs.oracle.com/javafx/2/get_started/form.htm
 */
public class Homework2 extends Application {

	private static int x = 0;
	private static final AuditLogger AUDIT = new AuditLogger();
	private static final TwoFactor VERIFY = new TwoFactor();
	private static String user;
	private boolean checksOut = false;
	Stage stage = new Stage();
	
  @Override
  public void start(Stage primaryStage) {
    // Updates audit log to indicate the program was started
    AUDIT.programStart();
    /* Checks lockout.txt for value and compares against current system time in milliseconds
     *  If current system time is not 1.8 million milliseconds (30 minutes) greater than value
     *  stored in lockout.txt, the program locks out until more time has passed.
     */
    String line = "";
    long time;
    long clock;
    BufferedReader reader;
    try {
      reader =
          new BufferedReader(
              new FileReader("/Users/benbrandhorst/NetBeansProjects/Homework2/lockout.txt"));
      line = reader.readLine();
      reader.close();
    } catch (IOException f) {
    }
    time = Long.parseLong(line);
    clock = (System.currentTimeMillis());
    /*Verifies that there is at least a 1.8 million millisecond difference in the values of current
     * system time and the value stored in the time variable before allowing access to login
     */
    if ((clock) - (time) > (1800000)) {
      primaryStage.setTitle("SDEV425 Login");
      // Grid Pane divides your window into grids
      GridPane grid = new GridPane();
      // Align to Center
      // Note Position is geometric object for alignment
      grid.setAlignment(Pos.CENTER);
      // Set gap between the components
      // Larger numbers mean bigger spaces
      grid.setHgap(10);
      grid.setVgap(10);

      // Create some text to place in the scene
      Text scenetitle = new Text("Welcome. Login to continue.");
      // Add text to grid 0,0 span 2 columns, 1 row
      grid.add(scenetitle, 0, 0, 2, 1);

      // Create Label
      Label userName = new Label("User Name:");
      // Add label to grid 0,1
      grid.add(userName, 0, 1);

      // Create Textfield
      TextField userTextField = new TextField();
      // Add textfield to grid 1,1
      grid.add(userTextField, 1, 1);

      // Create Label
      Label pw = new Label("Password:");
      // Add label to grid 0,2
      grid.add(pw, 0, 2);

      // Create Passwordfield
      PasswordField pwBox = new PasswordField();
      // Add Password field to grid 1,2
      grid.add(pwBox, 1, 2);

      // Create Login Button
      Button btn = new Button("Login");
      // Add button to grid 1,4
      grid.add(btn, 1, 4);

      final Text actiontarget = new Text();
      grid.add(actiontarget, 1, 6);

      // Set the Action when button is clicked
      btn.setOnAction(
          new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
              user = userTextField.getText();
              notification(primaryStage);

              // Authenticate the user
              boolean isValid = authenticate(userTextField.getText(), pwBox.getText());
              // If valid clear the grid and Welcome the user
              if (isValid) {
                Integer digits = ThreadLocalRandom.current().nextInt(1000, 9999);
                VERIFY.sendEmail(digits);
								
                GridPane grid4 = new GridPane();
								Scene scene = new Scene(grid4, 500, 400);
								// Align to Center
								// Note Position is geometric object for alignment
								grid4.setAlignment(Pos.CENTER);
								// Set gap between the components
								// Larger numbers mean bigger spaces
								grid4.setHgap(10);
								grid4.setVgap(10);
								Text scenetitle2 = new Text("Please enter the two factor code emailed to the admin email address.");
								// Add text to grid 0,0 span 2 columns, 1 row
								grid4.add(scenetitle2, 0, 0, 2, 1);
								// Create Label
								Label code = new Label("Enter Code:");
								// Add label to grid 0,1
								grid4.add(code, 0, 1);

								// Create Textfield
								TextField codeTextField = new TextField();
								// Add textfield to grid 1,1
								grid4.add(codeTextField, 1, 1);
								 // Create Login Button
								Button btn2 = new Button("Submit");
								// Add button to grid 1,4
								grid4.add(btn2, 1, 4);

								final Text actiontarget = new Text();
								grid4.add(actiontarget, 1, 6);
								
								primaryStage.setScene(scene);
								primaryStage.show();
			
                // Set the Action when button is clicked
                btn2.setOnAction(
                    new EventHandler<ActionEvent>() {

                      public void handle(ActionEvent f) {
                        String codeText = codeTextField.getText();
                        Integer codeInt = Integer.parseInt(codeText);

                        if (codeInt.equals(digits)) {
                          checksOut = true;
                        }
                    
                if (checksOut == true) {
                  AUDIT.loginSuccess(user);
                  grid.setVisible(false);
                  GridPane grid2 = new GridPane();
                  // Align to Center
                  // Note Position is geometric object for alignment
                  grid2.setAlignment(Pos.CENTER);
                  // Set gap between the components
                  // Larger numbers mean bigger spaces
                  grid2.setHgap(10);
                  grid2.setVgap(10);
                  Text scenetitle3 = new Text("Welcome " + userTextField.getText() + "!");
                  // Add text to grid 0,0 span 2 columns, 1 row
                  grid2.add(scenetitle3, 0, 0, 2, 1);
                  Scene scene2 = new Scene(grid2, 500, 400);
                  primaryStage.setScene(scene2);
                  primaryStage.show();
                  /* Uses BuferedWriter to write "0" to the Lockout.txt file to reset the
                   * lockout timer once a user successfully logs in.
                   */
                  String reset = "0";
                  BufferedWriter writer = null;
                  try {
                    writer = new BufferedWriter(new FileWriter("lockout.txt"));
                    writer.write(reset);
                  } catch (IOException io) {
                    System.out.println("File IO Exception" + io.getMessage());
                  } // close the file
                  finally {
                    try {
                      if (writer != null) {
                        writer.close();
                      }
                    } // print error message if there is one
                    catch (IOException io) {
                      System.out.println("Issue closing the File." + io.getMessage());
                    }
                  }
                }
								  }
                    });
                // If Invalid Ask user to try again
              } else if (x < 4) {
                // Updates audit log to record an incorrect login attempt
                AUDIT.incorrectLogin(user);
                final Text actiontarget = new Text();
                grid.add(actiontarget, 1, 6);
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Please try again.");
                x = x + 1;
              } else {
                // Updates audit log to record a program lockout
                AUDIT.lockOut(user);
                badLogin();
                grid.setVisible(false);
                GridPane grid2 = new GridPane();
                // Align to Center
                // Note Position is geometric object for alignment
                grid2.setAlignment(Pos.CENTER);
                // Set gap between the components
                // Larger numbers mean bigger spaces
                grid2.setHgap(10);
                grid2.setVgap(10);
                Text scenetitle = new Text("Too many bad login attempts. Please try again later.");
                // Add text to grid 0,0 span 2 columns, 1 row
                grid2.add(scenetitle, 0, 0, 2, 1);
                Scene scene = new Scene(grid2, 500, 400);
                primaryStage.setScene(scene);
                primaryStage.show();
              }
            }
          });
			// Set the size of Scene
			Scene scene = new Scene(grid, 500, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} else {
			AUDIT.lockOut(user);
			GridPane grid2 = new GridPane();
			// Align to Center
			// Note Position is geometric object for alignment
			grid2.setAlignment(Pos.CENTER);
			// Set gap between the components
			// Larger numbers mean bigger spaces
			grid2.setHgap(10);
			grid2.setVgap(10);
			Text scenetitle = new Text("Too many bad login attempts. Please try again later.");
			// Add text to grid 0,0 span 2 columns, 1 row
			grid2.add(scenetitle, 0, 0, 2, 1);
			Scene scene = new Scene(grid2, 500, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * @param user the username entered
	 * @param pword the password entered
	 * @return isValid true for authenticated
	 */
	public boolean authenticate(String user, String pword) {
		boolean isValid = false;
		if (user.equalsIgnoreCase("sdevadmin")
				&& pword.equals("425!pass")) {

			isValid = true;
		}

		return isValid;
	}

	public static void badLogin() {
		//triggers log of program lockout
		AUDIT.lockOut(user);
		/**
		 * Stores the system time in milliseconds in the time variable and writes the contents of time
		 * variable to lockout.txt using BufferedWriter
		 */
		String time = String.valueOf(System.currentTimeMillis());
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("/Users/benbrandhorst/NetBeansProjects/Homework2/lockout.txt"));
			writer.write(time);
		} catch (IOException io) {
			System.out.println("File IO Exception" + io.getMessage());
		} // close the file
		finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} // print error message if there is one
			catch (IOException io) {
				System.out.println("Issue closing the File." + io.getMessage());
			}
		}
	}

	public static void notification(Stage warning) {
		Alert a = new Alert(AlertType.NONE);
		//updates audit log to include the time the Login button was clicked and what username
		//was used
		AUDIT.loginClicked(user);
		// Displays Information alert before allowing access to system
		a.setAlertType(AlertType.INFORMATION);
		a.setTitle("Access Control");
		a.setHeaderText("System Use Notification");
		a.setContentText(
				"You are accessing a U.S. Government informations system. Information system usage"
				+ "may be monitored, recorded, and subject to audit. Unauthorized use of the information "
				+ "system is prohibited and subject to criminal and civil penalties. Use of the information "
				+ "system indicates consent to monitoring and recording.");
		a.initModality(Modality.APPLICATION_MODAL);
		// show the dialog
		a.show();
	}
}