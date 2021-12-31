import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Register {
    /**
     * 
     * @param email
     * @return boolean true if the mail is already registered
     * returns false if the mail is not registered
     * @throws FileNotFoundException
     */
    public static boolean isRegistered(String email) throws FileNotFoundException{
        
        File file = new File("EmailsFile.txt");
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()){
                if(scan.nextLine().equals(email)){
                  return true;
                }
            }
        }
        return false;
    }
    /**
     * 
     * @param name
     * @param rollNumber
     * @param branch
     * @param email
     * @param year
     * @param password
     * @throws IOException
     * this method is used to create an account for the user if he is not previously registered
     */
    public static void registerUser(String name , String rollNumber, String branch , String email , int year,String password ) throws IOException{
       
        FileOutputStream fos = new FileOutputStream("detailsFile.csv",true);
        String details = name + "," + rollNumber +"," + branch + "," + year+"\n";
        byte b[] = details.getBytes();
        fos.write(b);
        fos.close();
        FileOutputStream fos1 = new FileOutputStream("EmailsFile.txt",true);
        email = "\n"+email;
        byte[] b1 = email.getBytes();
        fos1.write(b1);
        fos1.close();
        FileOutputStream fos2 = new FileOutputStream("Passwords.txt",true);
        password = "\n" + password;
        byte[] b2 = password.getBytes();
        fos2.write(b2);
        fos2.close();

    }
}
