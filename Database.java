package SeProject;
import java.io.*;
import java.util.Scanner;
/**
 * @author : SEGROUP-1
 * @version : 
 */
public class Database {

   
    /**
     * 
     * @param email Email of the user
     * @param password password of the user of his email
     * @return integer value 1 : if both the email and password are correct
     * @throws FileNotFoundException
     * This method throws FileNotFoundException if the file containing the emails and password is not available
     * 
     */
    public  int userLogin(String email,String password) throws FileNotFoundException{
        File file = new File("Data.csv");
        try (Scanner scan = new Scanner(file)) {
            scan.useDelimiter("\n");
            Encryption eobj = new Encryption();
            while(scan.hasNext())
            {
                String temp = scan.next().trim();
                if(!temp.equals("")){
                    String[] data = temp.split(",");
                    if(eobj.decryptText(data[0]).equals(email) && eobj.decryptText(data[1]).equals(password)){
                        return 1;
                    }
                    else if(eobj.decryptText(data[0]).equals(email)){
                        return -1;
                    }
                }
            }
        }
        return 0;
        
    }
}