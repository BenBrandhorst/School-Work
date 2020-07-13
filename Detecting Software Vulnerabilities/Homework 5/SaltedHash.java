import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
public class SaltedHash{
	
	
	static String SHAPass = "";
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException
    {
		String password = "SDEV325Password";
        byte[] salt = getSalt();
                   
        Object securePassword = hash(password, salt);
        System.out.println(password+ " hashed using SHA-512 with salt to become "+securePassword);
    }
 
    public static String hash(String message, byte[] salt) throws NoSuchAlgorithmException, 
    NoSuchProviderException {
        if(null == message) 
            return null;
         
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.update(salt);
            digest.update(message.getBytes(), 0, message.length());
            SHAPass = new BigInteger(1, digest.digest()).toString(16);
            
  
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return SHAPass;
    }
    private static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
}    

