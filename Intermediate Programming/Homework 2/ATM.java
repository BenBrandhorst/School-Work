import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

/*
 * File: ATM.java
 * Author: Ben Brandhorst
 * Date: April 12th, 2019
 * Purpose: CMIS 242 Project 2- ATM GUI Project
 */

public class ATM extends JFrame implements ActionListener {


  private JFrame frmATM;
  private JTextField textBox;
  private JButton withdraw, deposit, transfer, balance;
  private JRadioButton checking, savings;
  private final ButtonGroup buttonGroup = new ButtonGroup();


  private Account checkAccount = new Account();
  private Account saveAccount = new Account();
  static int textBoxContent;
  static double textDoubleContent;
  static double accountBalance, accountBalance2;


  //Create the application.
  public ATM() {
    initialize();
  }

  //Launch the application.
  public static void main(String[] args) {

    EventQueue.invokeLater(() -> {
      try {
        ATM window = new ATM();
        window.frmATM.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }


  //Initialize the contents of the frame.
  private void initialize() {
    // creates JFrame
    frmATM = new JFrame();
    frmATM.getContentPane().setLayout(null);
    frmATM.getContentPane().setBackground(Color.LIGHT_GRAY);
    frmATM.setTitle("Automatic Teller Machine");
    frmATM.setBounds(100, 100, 800, 400);
    frmATM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Creates Withdraw JButton
    withdraw = new JButton("Withdraw");
    withdraw.setBounds(166, 21, 200, 70);
    withdraw.setToolTipText("Withdraw from account");
    withdraw.setFont(new Font("Tahoma", Font.PLAIN, 32));
    //adds button to JFrame
    frmATM.getContentPane().add(withdraw);
    //withdraw ActionListener
    withdraw.addActionListener(this);

    //Creates Deposit JButton
    deposit = new JButton("Deposit");
    deposit.setBounds(400, 21, 200, 70);
    deposit.setToolTipText("Deposit into account");
    deposit.setFont(new Font("Tahoma", Font.PLAIN, 32));
    //adds button to JFrame
    frmATM.getContentPane().add(deposit);
    //deposit ActionListener
    deposit.addActionListener(this);

    //Creates Transfer To JButton
    transfer = new JButton("Transfer to");
    transfer.setBounds(166, 101, 200, 70);
    transfer.setToolTipText("Transfer to the selected account");
    transfer.setFont(new Font("Tahoma", Font.PLAIN, 32));
    //adds button to JFrame
    frmATM.getContentPane().add(transfer);
    //transfer ActionListener
    transfer.addActionListener(this);

    // Creates Balance JButton
    balance = new JButton("Balance");
    balance.setBounds(400, 103, 200, 67);
    balance.setToolTipText("Check the selected account balance");
    balance.setFont(new Font("Tahoma", Font.PLAIN, 32));
    //adds button to JFrame
    frmATM.getContentPane().add(balance);
    //balance ActionListener
    balance.addActionListener(this);

    //Creates Savings JRadioButton
    savings = new JRadioButton("Savings");
    savings.setBounds(440, 177, 147, 47);
    savings.setBackground(Color.LIGHT_GRAY);
    savings.setFont(new Font("Tahoma", Font.PLAIN, 32));
    // adds savings to the buttonGroup
    buttonGroup.add(savings);
    //savings ActionListener
    savings.addActionListener(this);
    //adds JRadioButton to the JFrame
    frmATM.getContentPane().add(savings);

    //Creates Checking JRadioButton
    checking = new JRadioButton("Checking");
    checking.setBounds(176, 177, 167, 47);
    checking.setBackground(Color.LIGHT_GRAY);
    checking.setFont(new Font("Tahoma", Font.PLAIN, 32));
    //makes the checking button selected by default
    checking.setSelected(true);
    //adds checking to the buttonGroup
    buttonGroup.add(checking);
    //checking ActionListener
    checking.addActionListener(this);
    //adds JRadioButton to the jFrame
    frmATM.getContentPane().add(checking);

    //Creates JTextField
    textBox = new JTextField();
    textBox.setBounds(166, 231, 434, 45);
    textBox.setFont(new Font("Tahoma", Font.PLAIN, 32));
    //adds JTextField to the JFrame
    frmATM.getContentPane().add(textBox);
    textBox.setColumns(20);


  }

  // Initializes Action Events upon button press
  public void actionPerformed(ActionEvent ae) {

    if (ae.getSource() == withdraw) {
      withdrawClicked();

    } else if (ae.getSource() == deposit) {
      depositClicked();
    } else if (ae.getSource() == transfer) {
      transferClicked();

    } else if (ae.getSource() == balance) {
      balanceClicked();
    }

  }


  public void withdrawClicked() {
    try {
      // parses textField to Integer
      textBoxContent = Integer.parseInt(textBox.getText());
      // checks textField to ensure it is a multiple of 20
      if (textBoxContent % 20 == 0) {
        if (checking.isSelected()) {
          accountBalance = checkAccount.getAccountValue();
          checkAccount.accountWithdraw();
          JOptionPane.showMessageDialog(frmATM,
              "$" + textBoxContent + ".00 withdrawn from Checking. Balance: $" + checkAccount
                  .getAccountValue() + "0");

        } else if (savings.isSelected()) {
          accountBalance = saveAccount.getAccountValue();
          saveAccount.accountWithdraw();
          JOptionPane.showMessageDialog(frmATM,
              "$" + textBoxContent + ".00 withdrawn from Savings. Balance = $" + saveAccount
                  .getAccountValue() + "0");
        }
      } else {
        // prompts user to use integer values in multiples of twenty
        JOptionPane.showMessageDialog(frmATM,
            "This ATM only dispenses 20 dollar bills. Please enter a withdraw amount in multiples of 20.");
      }
      // catches NumberFormatException and prompts user to input correct values
    } catch (NumberFormatException e) {
      JOptionPane
          .showMessageDialog(frmATM, "Please enter a value in whole dollar multiples of $20.");
    }
  }

  public void depositClicked() {
    try {
      //parses textField to Double
      textDoubleContent = Double.parseDouble(textBox.getText());
      //checks radio buttons to see which is selected
      if (checking.isSelected()) {
        accountBalance = checkAccount.getAccountValue();
        checkAccount.accountDeposit();
        JOptionPane.showMessageDialog(frmATM,
            "$" + textDoubleContent + "0 deposited to Checking. Balance: $" + checkAccount
                .getAccountValue() + "0");
        //checks radio buttons to see which is selected
      } else if (savings.isSelected()) {
        accountBalance = saveAccount.getAccountValue();
        saveAccount.accountDeposit();
        JOptionPane.showMessageDialog(frmATM,
            "$" + textDoubleContent + "0 deposited to Savings. Balance: $" + saveAccount
                .getAccountValue() + "0");
      }
    } catch (NumberFormatException e) {
      JOptionPane
          .showMessageDialog(frmATM, "Please enter a numeric value");
    }
  }

  public void transferClicked() {
    try {
    //assigns values of savings and checking accounts to static variables for use in Account class
    accountBalance = saveAccount.getAccountValue();
    accountBalance2 = checkAccount.getAccountValue();
    textDoubleContent = Double.parseDouble(textBox.getText());

    if (checking.isSelected()) {
      // runs accountTransfer method from Account class
      checkAccount.accountTransfer();
      //reduces savings account by the amount of transfer
      saveAccount.setAccountValue(Account.savingsMinus);
      //increases checking account by the amount of transfer
      checkAccount.setAccountValue(Account.checkingPlus);
      JOptionPane
          .showMessageDialog(frmATM,
              "Transferred $" + textDoubleContent
                  + "0 from Savings to Checking. Checking Balance: $" + checkAccount
                  .getAccountValue() + "0");
    } else if (savings.isSelected()) {
      // runs accountTransfer method from Account class
      saveAccount.accountTransfer();
      //reduces checking account by the amount of transfer
      checkAccount.setAccountValue(Account.checkingMinus);
      //increases savings account by the amount of transfer
      saveAccount.setAccountValue(Account.savingsPlus);
      JOptionPane
          .showMessageDialog(frmATM,
              "Transferred $" + textDoubleContent + "0 from Checking to Savings. Savings Balance: $"
                  + saveAccount
                  .getAccountValue() + "0");

    }
    } catch (NumberFormatException e) {
      JOptionPane
          .showMessageDialog(frmATM, "Please enter a numeric value");
    }
  }

  public void balanceClicked() {
    if (checking.isSelected()) {
      //shows checking account balance
      JOptionPane.showMessageDialog(frmATM,
          "Checking Balance: $" + checkAccount
              .getAccountValue() + "0");
      //shows savings account balance
    } else if (savings.isSelected()) {
      JOptionPane.showMessageDialog(frmATM,
          "Savings Balance $" + saveAccount
              .getAccountValue() + "0");
    }

  }

}

