public class IntOverflow {
  public static void main(String[] args) {
  int janRev = 200000000;
  int febRev = 100000000;
  int marRev = 100000000;
  int aprRev = 100000000;
  int mayRev = 100000000;
  int junRev = 100000000;
  int julRev = 100000000;
  int augRev = 100000000;
  int sepRev = 100000000;
  int octRev = 100000000;
  int novRev = 100000000;
  int decRev = 100000000;
  int firstQuarter = 0;
  int secondQuarter = 0;
  int thirdQuarter = 0;
  int fourthQuarter = 0;
  
  if(janRev <= 178956970 && febRev <= 178956970 && marRev <= 178956970){
    firstQuarter = janRev+febRev+marRev;
  }else{ 
    System.out.println ("Your First Quarter Revenue amounts are too high. Please check the input.");
  }
  
  if(aprRev <= 178956970 && mayRev <= 178956970 && junRev <= 178956970){
   secondQuarter = aprRev+mayRev+junRev;
  }else{ 
    System.out.println ("Your Second Quarter Revenue amounts are too high. Please check the input.");
  }
  
  if(julRev <= 178956970 && augRev <= 178956970 && sepRev <= 178956970){
    thirdQuarter = julRev+augRev+sepRev;
  }else{ 
    System.out.println ("Your Third Quarter Revenue amounts are too high. Please check the input.");
  }
  
 if(octRev <= 178956970 && novRev <= 178956970 && decRev <= 178956970){
    fourthQuarter = octRev+novRev+decRev;
  }else{ 
    System.out.println ("Your Fourth Quarter Revenue amounts are too high. Please check the input.");
  }
  
  int annualRev = firstQuarter+secondQuarter+thirdQuarter+fourthQuarter;
  System.out.println("First Quarter revenue: "+firstQuarter);
  System.out.println("Second Quarter revenue: "+secondQuarter);
  System.out.println("Third Quarter revenue: "+thirdQuarter);
  System.out.println("Fourth Quarter revenue: "+fourthQuarter);
  System.out.println("Annual revenue: "+annualRev);
    
  }
}