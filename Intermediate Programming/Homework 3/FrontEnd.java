package Project3;
/*
 * File: FrontEnd.java
 * Author: Ben Brandhorst
 * Date: April 25th 2019
 * Description: Contains the GUI Main Class for the Number Sequence (0, 1, 2, 5, 12, 29...)  program
 */


import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;


public class FrontEnd extends JFrame implements ActionListener {

  private JFrame projectFrame;
  private JTextField enternText;
  private JTextField resultText;
  private JTextField efficiencyText;
  private JRadioButton iterativeRadio;
  private JRadioButton recursiveRadio;
  private JButton computeButton;
  private String result;
  private String efficiency;
  private final ButtonGroup buttonGroup = new ButtonGroup();
  private static int textBoxContent;


  // Create the application.
  public FrontEnd() {
    initialize();
  }


  // Initialize the contents of the frame.
  private void initialize() {
    projectFrame = new JFrame();
    // Window listener used for when window is closed
    projectFrame.addWindowListener(new CloseWindow());
    projectFrame.setTitle("Project 3");
    projectFrame.setBounds(100, 100, 600, 300);
    projectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    projectFrame.getContentPane().setLayout(null);

    // Iterative Radio Button with selection set to true and assigned to buttonGroup
    iterativeRadio = new JRadioButton("Iterative");
    iterativeRadio.setBounds(243, 8, 131, 33);
    iterativeRadio.setSelected(true);
    buttonGroup.add(iterativeRadio);
    iterativeRadio.setFont(new Font("Monospaced", Font.BOLD, 18));
    projectFrame.getContentPane().add(iterativeRadio);

    // Recursive Radio Button with selection set to false and assigned to buttonGroup
    recursiveRadio = new JRadioButton("Recursive");
    recursiveRadio.setBounds(243, 49, 131, 33);
    buttonGroup.add(recursiveRadio);
    recursiveRadio.setFont(new Font("Monospaced", Font.BOLD, 18));
    projectFrame.getContentPane().add(recursiveRadio);

    // Label for JTextField "Enter n:"
    JLabel lblNewLabel = new JLabel("Enter n:");
    lblNewLabel.setBounds(7, 93, 88, 25);
    lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
    projectFrame.getContentPane().add(lblNewLabel);

    // JTextField "Enter n:"
    enternText = new JTextField();
    enternText.setBounds(243, 90, 328, 31);
    enternText.setFont(new Font("Monospaced", Font.BOLD, 18));
    projectFrame.getContentPane().add(enternText);
    enternText.setColumns(10);

    // Compute Button
    computeButton = new JButton("Compute");
    computeButton.setBounds(243, 129, 328, 33);
    computeButton.setFont(new Font("Monospaced", Font.BOLD, 18));
    projectFrame.getContentPane().add(computeButton);
    // Action Listener for computButton
    computeButton.addActionListener(this);

    // Label for JTextField "Results:"
    JLabel resultLabel = new JLabel("Result:");
    resultLabel.setBounds(7, 173, 77, 25);
    resultLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
    projectFrame.getContentPane().add(resultLabel);

    // JTextField "Results:"
    resultText = new JTextField();
    resultText.setBounds(243, 170, 328, 31);
    resultText.setEditable(false);
    resultText.setFont(new Font("Monospaced", Font.BOLD, 18));
    resultText.setColumns(10);
    projectFrame.getContentPane().add(resultText);

    // Label for JTextField "Efficiency:"
    JLabel efficiencyLabel = new JLabel("Efficiency:");
    efficiencyLabel.setBounds(7, 212, 121, 25);
    efficiencyLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
    projectFrame.getContentPane().add(efficiencyLabel);

    // Efficiency JTextField
    efficiencyText = new JTextField();
    efficiencyText.setBounds(243, 209, 328, 31);
    efficiencyText.setEditable(false);
    efficiencyText.setFont(new Font("Monospaced", Font.BOLD, 18));
    efficiencyText.setColumns(10);
    projectFrame.getContentPane().add(efficiencyText);
  }


  // Initializes Action Events upon button press
  public void actionPerformed(ActionEvent e) {
    try {
      textBoxContent = Integer.parseInt(enternText.getText());
      // I used the same format try block as was used in the last assignment
      if (iterativeRadio.isSelected()) {
        result = String.valueOf(Sequence.computeIterative(textBoxContent));
        efficiency = String.valueOf(Sequence.getEfficiency());
      } else if (recursiveRadio.isSelected()) {
        result = String.valueOf(Sequence.computeRecursive(textBoxContent));
        efficiency = String.valueOf(Sequence.getEfficiency());
      }
      resultText.setText(result);
      efficiencyText.setText(efficiency);

    } catch (NumberFormatException f) {
      JOptionPane.showMessageDialog(projectFrame, "Please enter a whole number");
    }
  }

  //sub class to handle window closing event
  class CloseWindow extends WindowAdapter {

    public void windowClosing(WindowEvent e) {
      JOptionPane.showMessageDialog(projectFrame, "Program-Output file written with n values 0-10");

      try {
        BufferedWriter fileWrite = new BufferedWriter(new FileWriter("Program-Output.txt"));
        int n;
        String nValue;
        String efficient;
        // loops to calculate n from values 0-10 and writes iterative and recursive efficiency
        // to a file
        for (n = 0; n < 11; n++) {
          nValue = String.valueOf(n);
          fileWrite.append(nValue);
          fileWrite.append(",");
          Sequence.computeIterative(n);
          // converts from integer to String and stores as local variable
          efficient = String.valueOf(Sequence.getEfficiency());
          fileWrite.append(efficient);
          fileWrite.append(",");
          Sequence.computeRecursive(n);
          efficient = String.valueOf(Sequence.getEfficiency());
          // \n starts another line when the loop begins again
          fileWrite.append(efficient + "\n");
        }
        fileWrite.close();
      } catch (IOException g) {

      }
    }

    ;
  }

  // Launch the application.
  public static void main(String[] args) {

    FrontEnd window = new FrontEnd();
    window.projectFrame.setVisible(true);
  }
}

