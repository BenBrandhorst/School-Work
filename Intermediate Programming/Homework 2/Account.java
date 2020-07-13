/*
 * File: Account.java
 * Author: Ben Brandhorst
 * Date: April 12th, 2019
 * Purpose: CMIS 242 Project 2- ATM GUI Project
 */

public class Account {

  private double serviceFee = 1.5;
  static int counter;
  static double checkingPlus, checkingMinus, savingsPlus, savingsMinus;
  private double accountValue;

  public Account() {
    accountValue = 1000;

  }

  // Define setter Methods
  public void setAccountValue(double accountValue) {
    this.accountValue = accountValue;
  }

  public void accountWithdraw() throws InsufficientFunds {
    //counter used to track number of withdraws
    if (counter <= 3) {
      if (ATM.accountBalance >= ATM.textBoxContent) {
        accountValue = (ATM.accountBalance - ATM.textBoxContent);
        counter++;
      } else if (ATM.accountBalance < ATM.textBoxContent) {
        throw new InsufficientFunds();
      }
      //once four withdraws are successful adds service fee to balance check
    } else if (counter > 3) {
      if ((ATM.accountBalance - serviceFee) > ATM.textBoxContent) {
        //all withdraws incur a $1.50 service fee
        accountValue = (ATM.accountBalance - ATM.textBoxContent - serviceFee);
        counter++;
      } else if ((ATM.accountBalance - serviceFee) < ATM.textBoxContent) {
        throw new InsufficientFunds();
      }
    }
  }

  public void accountDeposit() {
    accountValue = (ATM.accountBalance + ATM.textDoubleContent);
  }


  public void accountTransfer() throws InsufficientFunds {
    //verifies there is enough funds in the account
    if (ATM.accountBalance >= ATM.textDoubleContent) {
      //variables to assist in making account balances correct when transferring funds
      checkingPlus = (ATM.accountBalance2 + ATM.textDoubleContent);
      checkingMinus = (ATM.accountBalance2 - ATM.textDoubleContent);
      savingsPlus = (ATM.accountBalance + ATM.textDoubleContent);
      savingsMinus = (ATM.accountBalance - ATM.textDoubleContent);
    } else if (ATM.accountBalance < ATM.textDoubleContent) {
      throw new InsufficientFunds();
    }
    // if insufficient funds are available throws exception
    else if (ATM.accountBalance2 < ATM.textDoubleContent) {
      throw new InsufficientFunds();
    }
  }

  //Used in conjunction with the Balance button
  public double getAccountValue() {
    return accountValue;
  }
}
