import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class OneWayHash{
  
     
    public static void main(String[] args) {
            String password = "SDEV325Password";
          
            System.out.println(password+" has been hashed using MD5 to " + hash(password));
    
    }
 
    public static String hash(String message) {
        String md5Pass = "";
        if(null == message) 
            return null;
         
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(message.getBytes(), 0, message.length());
            md5Pass = new BigInteger(1, digest.digest()).toString(16);
  
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5Pass;
    }}