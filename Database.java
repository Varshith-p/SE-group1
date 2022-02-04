import java.io.*;
import java.io.File;
import java.util.Scanner;

/**Database
 * @author : SEGROUP-1
 * @version : 
 * This class contains the data and methods related to login and registeration of the user. 
 * Methods in this class are : userLogin, isRegistered, registerUser.
 * user can login into his account by entering email and password of his account. 
 * For registeration of new account user will be asked to enter details for creating a new account. 
 */
public class Database {

    /**
     * This method is used to check whether the entered login details are valid or not.
     * @param email Email of the user
     * @param password password of the user of his email
     * @return integer value 1 : if both the email and password are correct
     * @throws FileNotFoundException if the File Data.csv is not available
     * This method throws FileNotFoundException if the file containing the emails and password is not available
     * 
     */
    public  int userLogin(String email,String password) throws FileNotFoundException{
        File file = new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\Data.csv");
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
    /**
     * checks whether the user is registred previously or not
     * @param email email of the user 
     * @return boolean true : if the user is registered with the email 
     *         boolean false : if the user is not registered
     * @throws FileNotFoundException if the File Data.csv is not available
     * 
     * This method throws Exception if the file is not avaialble 
     * File name : Data.csv
     */
   public  boolean isRegistered(String email) throws FileNotFoundException {
        File file = new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\Data.csv");
        try (Scanner scan = new Scanner(file)) {
            Encryption eobj = new Encryption();
            scan.useDelimiter("\n");
            while(scan.hasNext())
            {
                String[] data = scan.next().split(",");
                if(eobj.decryptText(data[0]).equals(email)){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * register the user with his details(creates new account)
     * @param name name of the user 
     * @param rollNumber registered number of the user
     * @param branch the branch in which the student is studying
     * @param email email of the user (college mail)
     * @param year year of study
     * @param password password of his choice
     * @throws IOException if the file DetailsFile.csv is not writable.
     * This method is used to register the user. 
     * The details of the user aere stored in the respective files 
     * email and password are stored in Data.csv file in encrypted format
     * remaining details are stored in detailsFile.csv
     * 
     */
    public  void registerUser(String name , String rollNumber, String branch , String email , int year,String password) throws IOException{
       
        FileOutputStream fos = new FileOutputStream("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\detailsFile.csv",true);
        Encryption eobj3 = new Encryption();
        String details ="\n"+name + "," + rollNumber +"," + branch + "," + year+","+email;
        byte b[] = details.getBytes();
        fos.write(b);
        fos.close();
        FileOutputStream obj = new FileOutputStream("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\Data.csv",true);
        String data = "\n"+eobj3.encryptText(email)+","+eobj3.encryptText(password);
        byte[] array = data.getBytes();
        obj.write(array);
        obj.close();
    }
}