/*
* File: StateInfoTest.java 
* Author: Ben Brandhorst 
* Date: December 7th, 2018 
* Purpose: CMIS 141 Homework 4- Call on methods contained in StateInfo
* 
*/

public class StateInfoTest {
  public static void main(String[] args) {

    // Create 3 StateInfo objects
    StateInfo stateInfo1 = new StateInfo();
    StateInfo stateInfo2 = new StateInfo();
    StateInfo stateInfo3 = new StateInfo();
    // Call on findState and summary methods contained in StateInfo for all three objects
    stateInfo1.findState();
    stateInfo1.summary();
    stateInfo2.findState();
    stateInfo2.summary();
    stateInfo3.findState();
    stateInfo3.summary();

  }
}

