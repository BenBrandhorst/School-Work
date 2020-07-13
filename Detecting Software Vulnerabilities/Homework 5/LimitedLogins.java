import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Scanner; 

public class LimitedLogins {
 static int loginAttempts = 0;
 
 
 public static void main(String[] args)
 {
    Scanner input = new Scanner(System.in);

    String username;
    String password;

    System.out.println("Please present your login credentials:");
    System.out.println("Username: ");
    username = input.next();
    System.out.println("Password: ");
    password = input.next();
if (loginAttempts < 4) {
    if (//INSERT LOGIN AUTHENTICATION CODE HERE. IF RETURNS TRUE COMPLETE THE LOGIN ) {
        System.out.println("You have been logged in. Welcome "+ username +":");
    else {
            System.out.println("Incorrect login information. Please try again.");
            loginAttempts ++;
            
        }else{
            System.out.println("You have reached the maximum number of login attempts.");
            // INSERT CODE HERE TO GENERATE A LOCKOUT TIMER TO PREVENT FURTHER ATTEMPTS WITH 
            // THIS USERNAME
}
}
}
}