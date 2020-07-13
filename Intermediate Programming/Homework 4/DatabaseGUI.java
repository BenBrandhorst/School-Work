/*
 * File: DatabaseGUI.java
 * Author: Ben Brandhorst
 * Date: May 10th, 2019
 * Purpose: CMIS 242 Project 4- Manage a student database
 */
package project4;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;


public class DatabaseGUI extends JFrame implements ActionListener {

  private JFrame project4Frame;
  private JTextField idTextField;
  private JTextField nameTextField;
  private JTextField majorTextField;
  private String[] selectCombo = {"Insert", "Delete", "Find", "Update"};
  private String[] grades = {"A", "B", "C", "D", "F"};
  private Integer[] credits = {3, 6};
  private final JComboBox<String> selectionCombo = new JComboBox<>(selectCombo);
  private final JComboBox<String> gradeCombo = new JComboBox<>(grades);
  private final JComboBox<Integer> creditCombo = new JComboBox<>(credits);
  //HashMap is String because it can't be Primitive Type
  private HashMap<String, Student> database = new HashMap<>();

  private void initialize() {
    //create and set boundaries of JFrame
    project4Frame = new JFrame();
    project4Frame.setResizable(false);
    project4Frame.setTitle("Project 4");
    project4Frame.setBounds(100, 100, 530, 350);
    project4Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    project4Frame.getContentPane().setLayout(null);

    //create and set boundaries of idTextField
    idTextField = new JTextField();
    idTextField.setFont(new Font("Calibri", Font.PLAIN, 28));
    idTextField.setBounds(290, 21, 186, 32);
    project4Frame.getContentPane().add(idTextField);
    idTextField.setColumns(10);

    //create and set boundaries of nameTextField
    nameTextField = new JTextField();
    nameTextField.setFont(new Font("Calibri", Font.PLAIN, 28));
    nameTextField.setColumns(10);
    nameTextField.setBounds(290, 71, 186, 32);
    project4Frame.getContentPane().add(nameTextField);

    //create and set boundaries of majorTextField
    majorTextField = new JTextField();
    majorTextField.setFont(new Font("Calibri", Font.PLAIN, 28));
    majorTextField.setColumns(10);
    majorTextField.setBounds(290, 127, 186, 32);
    project4Frame.getContentPane().add(majorTextField);

    //create and set boundaries of selection combobox
    selectionCombo.setSelectedIndex(-1);
    selectionCombo.setFont(new Font("Calibri", Font.PLAIN, 26));
    selectionCombo.setMaximumRowCount(4);
    selectionCombo.setBounds(290, 177, 186, 32);
    project4Frame.getContentPane().add(selectionCombo);

    // create and place Id Label
    JLabel IdLabel = new JLabel("Id:");
    IdLabel.setFont(new Font("Calibri", Font.PLAIN, 28));
    IdLabel.setBounds(21, 24, 92, 26);
    project4Frame.getContentPane().add(IdLabel);

    //create and place Name Label
    JLabel nameLabel = new JLabel("Name:");
    nameLabel.setFont(new Font("Calibri", Font.PLAIN, 28));
    nameLabel.setBounds(21, 77, 92, 26);
    project4Frame.getContentPane().add(nameLabel);

    //create and place Major Label
    JLabel majorLabel = new JLabel("Major:");
    majorLabel.setFont(new Font("Calibri", Font.PLAIN, 28));
    majorLabel.setBounds(21, 130, 92, 26);
    project4Frame.getContentPane().add(majorLabel);

    // create and place Choose Selection label
    JLabel chooseSelectionLabel = new JLabel("Choose Selection:");
    chooseSelectionLabel.setFont(new Font("Calibri", Font.PLAIN, 28));
    chooseSelectionLabel.setBounds(21, 183, 217, 26);
    project4Frame.getContentPane().add(chooseSelectionLabel);

    // create and set boundaries of Process Request button
    JButton processRequestButton = new JButton("Process Request");
    processRequestButton.setFont(new Font("Calibri", Font.PLAIN, 28));
    processRequestButton.setBounds(21, 223, 236, 35);
    project4Frame.getContentPane().add(processRequestButton);
    processRequestButton.addActionListener(this);
  }

  //event handler for when Process Request button is clicked
  public void actionPerformed(ActionEvent ae) {
    // choice holds ComboBox value during switch calculations
    String choice = (String) selectionCombo.getSelectedItem();
    //displays error message if Id text field is empty
    if (idTextField.getText().contentEquals("")) {
      JOptionPane.showMessageDialog(project4Frame,
          "Please Enter a Student ID");
      // displays error if no selection is made from combobox
    } else if (choice == null) {
      JOptionPane.showMessageDialog(project4Frame,
          "Please Choose Selection");

    } else {
      try {
        // parses contents of Id text field to integer to confirm value entered is correct variable type
        int id = Integer.parseInt(idTextField.getText());
        //switch calls appropriate methods depending on user selection
        switch (choice) {
          case "Insert":
            insertPicked();
            break;
          case "Delete":
            deletePicked();
            break;
          case "Find":
            findPicked();
            break;
          case "Update":
            updatePicked();
            break;
        }
        //catches number format exceptions if non integer format is used for Id field
      } catch (NumberFormatException e) {
        JOptionPane
            .showMessageDialog(project4Frame, "Please use a whole number for the Id field");

      }
    }
  }

  private void insertPicked() {
    //displays error if Id is already in use
    if (database.containsKey(idTextField.getText())) {
      JOptionPane.showMessageDialog(project4Frame,
          "The selected Id already exists in database. Please choose another.");
    } else {
      //creates new database record with Id field as key and new Student with Name and Major
      database.put((idTextField.getText()),
          new Student(nameTextField.getText(), majorTextField.getText()));
      JOptionPane.showMessageDialog(project4Frame,
          "Student record added to database");
    }
  }

  private void deletePicked() {
    //removes record from database
    if (database.containsKey(idTextField.getText())) {
      database.remove(idTextField.getText());
      JOptionPane.showMessageDialog(project4Frame,
          "Student record deleted");
    } else {
      //displays error if Id is not found
      JOptionPane.showMessageDialog(project4Frame,
          "The selected Id was not found. Please try again.");
    }
  }

  private void findPicked() {
    // displays overridden toString
    if (database.containsKey(idTextField.getText())) {
      database.get(idTextField.getText());
      String toString = database.get(idTextField.getText()).toString();
      JOptionPane.showMessageDialog(project4Frame,
          toString);
    } else {
      //displays error if Id is not found
      JOptionPane.showMessageDialog(project4Frame,
          "The selected Id was not found. Please try again.");
    }

  }

  private void updatePicked() {
    //displays error if Id is not found
    if (!database.containsKey(idTextField.getText())) {
      JOptionPane.showMessageDialog(project4Frame,
          "Student Id not found. Please try again.");
    } else if (database.containsKey(idTextField.getText())) {
      //creates new JOptionPane with appropriate JComboBox
      JOptionPane.showMessageDialog(project4Frame, gradeCombo, "Choose Grade:",
          JOptionPane.QUESTION_MESSAGE);
      //converts letter grade to numeric grade
      String grade = (String) gradeCombo.getSelectedItem();
      double numericGrade = 0;
      switch (grade) {
        case "A":
          numericGrade = 4;
          break;
        case "B":
          numericGrade = 3;
          break;
        case "C":
          numericGrade = 2;
          break;
        case "D":
          numericGrade = 1;
          break;
        case "F":
          numericGrade = 0;
          break;

      }
      // opens second JOptionPane once a grade is selected
      if (grade.matches("(A|B|C|D|F)")) {
        JOptionPane.showMessageDialog(project4Frame, creditCombo, "Choose credits:",
            JOptionPane.QUESTION_MESSAGE);

      } else  {
        JOptionPane.showMessageDialog(project4Frame,
            "Please select a Grade");

      }
      // creates third JOptionPane once hours are selected
      int hours = (int) creditCombo.getSelectedItem();
      while (hours != 0) {
        database.get(idTextField.getText()).courseCompleted(numericGrade, hours);
        JOptionPane.showMessageDialog(project4Frame,
            "Record Updated");
        break;
      }


    }
  }


  //Create the application.
  public DatabaseGUI() {
    initialize();
  }

  //launch the application.
  public static void main(String[] args) {
    DatabaseGUI window = new DatabaseGUI();
    window.project4Frame.setVisible(true);


  }

}