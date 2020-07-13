import java.util.Scanner; 

public class UnrestrictedLogin {
 
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String username;
    String password;

    System.out.println("Please present your login credentials:");
    System.out.println("Username: ");
    username = input.next();

    System.out.println("Password: ");
    password = input.next();

    //insert code here to validate username and password with credentials on backend 
    //ideally these would be stored as a salted hash
    
        System.out.println("You have been logged in. Welcome "+ username +":");

}

}