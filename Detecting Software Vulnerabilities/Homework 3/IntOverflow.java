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
  

    firstQuarter = janRev+febRev+marRev;
    secondQuarter = aprRev+mayRev+junRev;
    thirdQuarter = julRev+augRev+sepRev;
    fourthQuarter = octRev+novRev+decRev;
  
  int annualRev = firstQuarter+secondQuarter+thirdQuarter+fourthQuarter;
  System.out.println("First Quarter revenue: "+firstQuarter);
  System.out.println("Second Quarter revenue: "+secondQuarter);
  System.out.println("Third Quarter revenue: "+thirdQuarter);
  System.out.println("Fourth Quarter revenue: "+fourthQuarter);
  System.out.println("Annual revenue: "+annualRev);
    
  }
}
