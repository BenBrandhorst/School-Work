package Project3;

/*
 * File: Sequence.java
 * Author: Ben Brandhorst
 * Date: April 25th 2019
 * Description: Contains methods to calculate n using recursive and iterative algorithms
 */


class Sequence {
  
  private static int efficiency;

  static int computeIterative(int n) {
    // variables to hold data while method calculates
    efficiency = 0;
    int term = 0;
    int previous = 1;
    int secondPrev = 0;
    int i = 1;
    // if n equals 0 or 1 no calculations are done and 0 or 1 respectively are returned
    if (n == 0) {
      efficiency++;
      return 0;
    } else if (n == 1) {
      efficiency++;
      return 1;
    }
    // if n is greater than 1, the method iterates using the counter
    while (i < n) {
      // efficiency counter increases with each loop
      efficiency++;
      // Loop calculates from 1. Each loop generates the next number in the sequence until the
      // position of n is reached
      term = previous * 2 + secondPrev;
      // Once term has been defined, we need to move the data stored to other variables to keep the
      // loop calculating correctly
      secondPrev = previous;
      previous = term;
      i++;
    }

    return term;
  }

  // Getter method that returns efficiency
  static int getEfficiency() {
    return efficiency;
  }

  // I needed a way to reset the efficiency tracker to 0 outside of the recursive method loop
  static int computeRecursive(int n) {
    efficiency = 0;
    return recursive(n);
  }

  private static int recursive(int n) {
    // efficiency variable counts how many times the recursive method calls on itself
    efficiency++;
    // if n equals 0 or 1 no calculations are done. 0 or 1 is returned instead
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    }
    // if n is greater than 1 the method calls on itself recursively to calculate the term
    return ((recursive(n - 1) * 2) + (recursive(n - 2)));
  }


}
