import java.lang.Math;
/**
 * This class contains the methods to encrypt and decrypt the data and store them securely.
 * Encryption is used to store the data in a format other than its original format. 
 * Methods in this class are : encryptText , decryptText.
 * The text to be encrypted or decrypted is passed as parameter and the encrypted or decrypted text is returned.
 * @author : SEGROUP-1
 * @version : 
 * 
 */
public class Encryption 
{
    /**
     * Encrypts the given text.
     * @param text The text to be encrypted is passed as parameter to this method
     * @return encrypted text 
     * this method encrypts the text passed to it as parameter and returns the encrypted text.
     */
    public String encryptText(String text) {
        int key = 3;
        int i =0;
        char[] array = text.toCharArray();
        for(char c : array){
            array[i]=(char)((int)c+key);
            i++;
        }
        String etext ="";
        for(char c : array){
            etext = etext+c;
        }

        return etext;
    }
    /**
     * Decrypts the text given as input
     * @param text The text to be decrypted 
     * @return decrypted text 
     * this method decrypts the text passed to it as parameter and returns the decrypted text.
     */
    public String decryptText(String text){
        int key = 3;
        int i =0;
        char[] array = text.toCharArray();
        for(char c : array){
            array[i]=(char)Math.abs((key - (int)c));
            i++;
        }
        String dtext ="";
        for(char c : array){
            dtext = dtext+c;
        }
        return dtext;
    }
}
