import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Register {
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
    public static void registerUser(String name , String rollNumber, String branch , String email , int year,String password ) throws IOException{
        /*writing into file is pending 
        FileWriter fw1 = new FileWriter("detailsFile.txt",true);
        fw1.write(name+" "+rollNumber+" "+branch+" "+ year);
        fw1.write("\n");
        FileWriter fw2 = new FileWriter("Emailsfile.txt",true);
        fw2.write("\n"+email);
        FileWriter fw3 = new FileWriter("passwords.txt",true);
        fw2.write("\n"+password);*/
        
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
