import javax.swing.JOptionPane;
/*
 * File: InsufficientFunds.java
 * Author: Ben Brandhorst
 * Date: April 13th, 2019
 * Purpose: CMIS 242 Project 2- ATM GUI Project
 */

public class InsufficientFunds extends RuntimeException {

  public InsufficientFunds() {
    JOptionPane.showMessageDialog(null,
        "Insufficient Funds in Account. Please Try Again");
  }



  }

